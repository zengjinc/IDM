package com.ssm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/toou")
public class OrgUnitManagerController {

	private static Logger logger = LoggerFactory.getLogger(OrgUnitManagerController.class);
	
	@RequestMapping("/ou")
	public String toOu(){
		
		return "ou/ou";
	}
}
