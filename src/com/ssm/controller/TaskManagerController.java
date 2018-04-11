package com.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.ssm.mapper.ResourceMapper;
import com.ssm.mapper.SchedulejobMapper;
import com.ssm.pojo.Resource;
import com.ssm.pojo.ResourceExample;
import com.ssm.pojo.Schedulejob;
import com.ssm.pojo.SchedulejobExample;
import com.ssm.pojo.SchedulejobExample.Criteria;
import com.ssm.service.TaskService;
import com.ssm.shedule.BaseScheduleJob;
import com.ssm.shedule.JobManager;
import com.ssm.utils.BeanUtil;
import com.ssm.utils.CommonUtil;

@Controller
@RequestMapping("/totask")
public class TaskManagerController {

	private static Logger logger = LoggerFactory.getLogger(TaskManagerController.class);

	@Autowired
	private ResourceMapper resourceMapper;

	@Autowired
	private SchedulejobMapper schedulejobMapper;

	@RequestMapping("/task")
	public String toTask(ModelMap modelMap, @RequestParam(required = true, defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) {

		PageBounds pageBounds = new PageBounds(page, limit);
		List<Schedulejob> pagedScdJobList = schedulejobMapper.selectByExample(null, pageBounds);
		modelMap.put("scdjboList", pagedScdJobList);
		return "task/task";
	}

	@RequestMapping(value = "/searchtask", method = RequestMethod.POST)
	public String searTask(ModelMap modelMap, @ModelAttribute Schedulejob schedulejob) {
		String scdId = schedulejob.getScdId();
		String scdType = schedulejob.getScdJobType();

		PageBounds pageBounds = new PageBounds(1, 10);
		SchedulejobExample example = new SchedulejobExample();
		Criteria criteria = example.createCriteria();
		if (scdId != null && scdId != "") {
			criteria.andScdIdEqualTo(scdId);
		}

		if (scdType != null && scdType != "") {
			criteria.andScdJobTypeEqualTo(scdType);
		}

		List<Schedulejob> pagedScdJobList = schedulejobMapper.selectByExample(example, pageBounds);
		modelMap.put("scdjboList", pagedScdJobList);

		return "task/task";
	}

	@RequestMapping("/delettask")
	public String deleteResource(@RequestParam(value = "scduuid") String ScdUuid) {
		schedulejobMapper.deleteByPrimaryKey(ScdUuid);
		return "redirect:task.action";
	}

	@RequestMapping("/disabletask")
	public String disableResource(@RequestParam(value = "scduuid") String ScdUuid) {
		Schedulejob schedulejob = schedulejobMapper.selectByPrimaryKey(ScdUuid);
		schedulejob.setScdStatus(0);
		schedulejobMapper.updateByPrimaryKey(schedulejob);
		return "redirect:task.action";
	}

	@RequestMapping("/enabletask")
	public String enableResource(@RequestParam(value = "scduuid") String ScdUuid) {
		Schedulejob schedulejob = schedulejobMapper.selectByPrimaryKey(ScdUuid);
		schedulejob.setScdStatus(1);
		schedulejobMapper.updateByPrimaryKey(schedulejob);
		return "redirect:task.action";
	}

	@RequestMapping(value = "/gettask", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Schedulejob getTask(@RequestBody String jsonString) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		String scduuid = mapper.readTree(jsonString).asText();
		Schedulejob schedulejob = schedulejobMapper.selectByPrimaryKey(scduuid);
		return schedulejob;
	}

	@RequestMapping(value = "/gettaskchian", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public List<Schedulejob> getTaskChain() throws Exception {
		List<Schedulejob> schedulejobList = schedulejobMapper.selectByExample(null);
		return schedulejobList;
	}

	@RequestMapping("/taskdetail")
	public String toTaskDetail() {
		return "task/taskdetail";
	}

	@RequestMapping(value = "/getresourcebyscd", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public List<Resource> getResourceByScd(@RequestBody Map<String, String> json) {

		String scdJobType = json.get("scd_job_type");

		List<Resource> resourceList = null;

		if (scdJobType.equals("com.ssm.shedule.UserSynchronisedScheduleJob")) {
			// 信任
			ResourceExample example = new ResourceExample();
			example.createCriteria().andResTrustEqualTo(1);
			resourceList = resourceMapper.selectByExample(example, new PageBounds());
		} else if (scdJobType.equals("com.ssm.shedule.AssignAccountOwnerScheduleJob")) {
			// 非信任
			ResourceExample example = new ResourceExample();
			example.createCriteria().andResTrustEqualTo(0);
			resourceList = resourceMapper.selectByExample(example, new PageBounds());
		} else {
			// 全部
			resourceList = resourceMapper.selectByExample(null, new PageBounds());
		}

		return resourceList;
	}

	@RequestMapping(value = "/savescdjob", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Map<String, String> saveScdJob(@RequestBody String jsonString) throws Exception {
		Map<String, String> result = new HashMap<>();
		result.put("result", "success");

		JobManager jobManager = (JobManager) BeanUtil.getBean("jobManager");

		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(jsonString);
		String scdUuid = node.get("scduuid").asText();
		JsonNode baseNode = node.get("scdJobBaseJson");
		String scdJobId = baseNode.get("scd_job_id").asText();
		String scdJobType = baseNode.get("scd_job_type").asText();
		String scdJobCron = baseNode.get("scd_job_cron").asText();
		String scdJobStatus = baseNode.get("scd_job_status").asText();
		String scdJobLastRunTime = baseNode.get("scd_job_last_run_time").asText();
		String scdJobNextRunTime = baseNode.get("scd_job_next_run_time").asText();
		String scdJobDesc = baseNode.get("scd_job_desc").asText();
		String scdJsonAttr = node.get("tabJson").toString();

		Schedulejob schedulejob = new Schedulejob();
		schedulejob.setScdUuid(CommonUtil.generateUUID());
		schedulejob.setScdId(scdJobId);
		schedulejob.setScdJobGroup(scdJobId);
		schedulejob.setScdName(scdJobId);
		schedulejob.setScdJobType(scdJobType);
		schedulejob.setScdCron(scdJobCron);
		if (scdJobStatus != null && !scdJobStatus.equals("")) {
			schedulejob.setScdStatus(Integer.parseInt(scdJobStatus));
		}
		schedulejob.setScdLastRunTime(CommonUtil.formateToDate(scdJobLastRunTime));
		if (scdJobCron != null && scdJobCron != "") {
			schedulejob.setScdNextRunTime(CommonUtil.formateToDate(scdJobNextRunTime));
		}
		schedulejob.setScdDesc(scdJobDesc);
		schedulejob.setScdJsonAttr(scdJsonAttr);
		schedulejob.setScdStatus(1);

		if (scdUuid != null && scdUuid != "null") { // update
			schedulejob.setScdUuid(scdUuid);
			int updateNum = schedulejobMapper.updateByPrimaryKeyWithBLOBs(schedulejob);
			if (updateNum > 0) {
				jobManager.saveOrUpdateJob(schedulejob);
			}
		} else { // insert
			int insertNum = schedulejobMapper.insert(schedulejob);
			if (insertNum > 0) {
				jobManager.saveOrUpdateJob(schedulejob);
			}
		}

		return result;
	}

	@RequestMapping(value = "/runtask", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String runTask(@RequestBody String scdUuid) throws Exception {
		Schedulejob schedulejob = schedulejobMapper.selectByPrimaryKey(scdUuid.replace("\"",""));
		
		
		BaseScheduleJob baseschedulejob = (BaseScheduleJob) BeanUtil.getBean(schedulejob.getScdJobType());//com.ssm.shedule.UserSynchronisedScheduleJob
		baseschedulejob.setSchedulejob(schedulejob);
		((TaskService)baseschedulejob).exec();
		
		return "success";
	}

}
