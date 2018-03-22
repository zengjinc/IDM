package com.ssm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/toconfig")
public class ConfigManagerController {

	private static Logger logger = LoggerFactory.getLogger(ConfigManagerController.class);
	
	@RequestMapping("/systemconfig")
	public String toSystemConfig(){
		return "config/systemconfig";
	}
	
	@RequestMapping("/attrtype")
	public String toAttrType(){
		return "config/attrtype";
	}
	
	@RequestMapping("/userattrdef")
	public String toUserAttrDef(){
		return "config/userattrdef";
	}
	
	@RequestMapping("/userattrdefdetail")
	public String toUserAttrDefDetail(){
		return "config/userattrdefdetail";
	}
	
	@RequestMapping("/bizrole")
	public String toBizRole(){
		return "config/bizrole";
	}
	
	@RequestMapping("/bizroledetail")
	public String toBizRoleDetail(){
		return "config/bizroledetail";
	}
	
	@RequestMapping("/platformrole")
	public String toPlatformRole(){
		return "config/platformrole";
	}
}
