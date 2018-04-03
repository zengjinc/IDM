package com.ssm.shedule;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssm.mapper.SchedulejobMapper;
import com.ssm.service.SchedulejobService;
import com.ssm.service.TaskService;
import com.ssm.utils.BeanUtil;

public class AssignAccountOwnerScheduleJob extends BaseScheduleJob implements TaskService{

	@Autowired
	private SchedulejobMapper scheduleMapper;
	
	@Override
	public void exec() {
		
		SchedulejobService schedulejobService = (SchedulejobService)BeanUtil.getBean("schedulejobService");
		schedulejobService.updateSchedulejobTime(this.getSchedulejob());
	}

}
