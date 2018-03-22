package com.ssm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/totask")
public class TaskManagerController {

	private static Logger logger = LoggerFactory.getLogger(TaskManagerController.class);
	
	@RequestMapping("task")
	public String toTask(){
		return "task/task";
	}
	
	@RequestMapping("taskdetail")
	public String toTaskDetail(){
		return "task/taskdetail";
	}
	
}
