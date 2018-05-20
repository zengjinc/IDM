package com.ssm.shedule;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssm.connector.JDBCConnector;
import com.ssm.mapper.ResourceMapper;
import com.ssm.mapper.SchedulejobMapper;
import com.ssm.pojo.Resource;
import com.ssm.pojo.ResourceExample;
import com.ssm.service.TaskService;
import com.ssm.service.impl.SchedulejobService;
import com.ssm.utils.BeanUtil;

public class ReconAccountScheduleJob extends BaseScheduleJob implements TaskService{

	private static Logger logger = LoggerFactory.getLogger(ReconAccountScheduleJob.class);
	
	@Autowired
	private SchedulejobMapper scheduleMapper;
	
	@Autowired
	private ResourceMapper resourceMapper;
	
	@Override
	public void exec() throws Exception{
		
		ObjectMapper mapper = new ObjectMapper();
		String resourceId = null;
		try {
			JsonNode node = mapper.readTree(this.getSchedulejob().getScdJsonAttr());
			JsonNode attrJson = node.get("attrJson");
			resourceId = attrJson.get("resource_uuid_sel").asText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.debug("test schedule : scd_id --> " + this.getSchedulejob().getScdId() + ", resourceid --> " +resourceId);
		
		ResourceExample example = new ResourceExample();
		example.createCriteria().andResIdEqualTo(resourceId);
		Resource resource = resourceMapper.selectByExampleWithBLOBs(example).get(0);
		
		
		//根据resource type获取对应的连接器。这里只有jdbc连接器
		JDBCConnector jdbcConnector = (JDBCConnector) BeanUtil.getBean("jdbcConnector");
		
		jdbcConnector.setResource(resource);
		
		//回收账号
		jdbcConnector.listAccounts();
		
		
		SchedulejobService schedulejobService = (SchedulejobService)BeanUtil.getBean("schedulejobService");
		schedulejobService.updateSchedulejobTime(this.getSchedulejob());
	}

}
