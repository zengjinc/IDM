package com.ssm.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.mapper.SchedulejobMapper;
import com.ssm.pojo.Schedulejob;
import com.ssm.service.ISchedulejobService;
import com.ssm.shedule.JobManager;

@Service
public class SchedulejobService implements ISchedulejobService{

	@Autowired
	private SchedulejobMapper scheduleMapper;
	
	public void updateSchedulejobTime(Schedulejob schedulejob){
		String cron = null;
		if((cron = schedulejob.getScdCron()) != null && cron != ""){
			Date nextRunTime = JobManager.getNextRunTime(cron);
			schedulejob.setScdNextRunTime(nextRunTime);
		}
		schedulejob.setScdLastRunTime(new Date());
		scheduleMapper.updateByPrimaryKey(schedulejob);
	}
	
}
