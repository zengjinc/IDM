package com.ssm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/toresource")
public class ResourceManagerController {
	
	private static Logger logger = LoggerFactory.getLogger(ResourceManagerController.class);
	
	@RequestMapping("/resource")
	public String toResource(){
		return "resource/resource";
	}
	
	@RequestMapping("/resourcedetail")
	public String toResourceDetail(){
		return "resource/resourcedetail";
	}
}
