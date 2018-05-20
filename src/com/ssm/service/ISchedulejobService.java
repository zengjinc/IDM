package com.ssm.service;

import com.ssm.pojo.Schedulejob;

public interface ISchedulejobService {

	void updateSchedulejobTime(Schedulejob schedulejob) throws Exception;

	boolean deleSchedulejobByResource(String resUuid) throws Exception;

}
