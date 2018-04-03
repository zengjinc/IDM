package com.ssm.shedule;

import com.ssm.service.SchedulejobService;
import com.ssm.service.TaskService;
import com.ssm.utils.BeanUtil;

public class ReconOUJob extends BaseScheduleJob implements TaskService{

	@Override
	public void exec() {
		// TODO Auto-generated method stub
		SchedulejobService schedulejobService = (SchedulejobService)BeanUtil.getBean("schedulejobService");
		schedulejobService.updateSchedulejobTime(this.getSchedulejob());
	}

}
