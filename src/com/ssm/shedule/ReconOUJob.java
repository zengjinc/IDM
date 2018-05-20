package com.ssm.shedule;

import com.ssm.service.TaskService;
import com.ssm.service.impl.SchedulejobService;
import com.ssm.utils.BeanUtil;

public class ReconOUJob extends BaseScheduleJob implements TaskService{

	@Override
	public void exec() throws Exception {
		// TODO Auto-generated method stub
		SchedulejobService schedulejobService = (SchedulejobService)BeanUtil.getBean("schedulejobService");
		schedulejobService.updateSchedulejobTime(this.getSchedulejob());
	}

}
