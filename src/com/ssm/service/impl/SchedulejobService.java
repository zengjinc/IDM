package com.ssm.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssm.mapper.SchedulejobMapper;
import com.ssm.pojo.Resource;
import com.ssm.pojo.Schedulejob;
import com.ssm.service.IResourceService;
import com.ssm.service.ISchedulejobService;
import com.ssm.shedule.JobManager;

@Service
public class SchedulejobService implements ISchedulejobService{

	@Autowired
	private SchedulejobMapper scheduleMapper;
	
	@Autowired
	private IResourceService resourceService;
	
	@Override
	public void updateSchedulejobTime(Schedulejob schedulejob) throws Exception{
		String cron = null;
		if((cron = schedulejob.getScdCron()) != null && cron != ""){
			Date nextRunTime = JobManager.getNextRunTime(cron);
			schedulejob.setScdNextRunTime(nextRunTime);
		}
		schedulejob.setScdLastRunTime(new Date());
		scheduleMapper.updateByPrimaryKey(schedulejob);
	}
	
	@Override
	public boolean deleSchedulejobByResource(String resUuid) throws Exception{
		
		//获取全部定时任务，如果关联的 resource 是 resUuid，就删除该定时任务
		List<Schedulejob> scdjobList = scheduleMapper.selectByExampleWithBLOBs(null);
		
		for(Schedulejob scdjob : scdjobList){
			
			JsonNode rootNode = new ObjectMapper().readTree(scdjob.getScdJsonAttr());
			
			String resId = rootNode.get("attrJson").get("resource_uuid_sel").asText();
			
			Resource resource = resourceService.getResourceByPrimarKey(resUuid);
			
			if(resId.equals(resource.getResId())){
				//删除定时任务
				try {
					scheduleMapper.deleteByPrimaryKey(scdjob.getScdUuid());
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
				
			}
		}
		
		return true;
	}
	
}
