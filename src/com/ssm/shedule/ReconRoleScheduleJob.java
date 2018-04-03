package com.ssm.shedule;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ssm.service.SchedulejobService;
import com.ssm.service.TaskService;
import com.ssm.utils.BeanUtil;

public class ReconRoleScheduleJob extends BaseScheduleJob implements TaskService{
	private static Logger logger = LoggerFactory.getLogger(ReconRoleScheduleJob.class);
	
	@Override
	public void exec() {
		ObjectMapper mapper = new ObjectMapper();
		String resourceUuid = null;
		try {
			JsonNode node = mapper.readTree(this.getSchedulejob().getScdJsonAttr());
			JsonNode attrJson = node.get("attrJson");
			resourceUuid = attrJson.get("resource_uuid_sel").asText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.debug("test schedule : scd_id --> " + this.getSchedulejob().getScdId() + ", resourceid --> " +resourceUuid);
		
		SchedulejobService schedulejobService = (SchedulejobService)BeanUtil.getBean("schedulejobService");
		schedulejobService.updateSchedulejobTime(this.getSchedulejob());
	}

}
