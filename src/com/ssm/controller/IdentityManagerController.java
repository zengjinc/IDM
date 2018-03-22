package com.ssm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/toidentity")
public class IdentityManagerController {

	private static Logger logger = LoggerFactory.getLogger(IdentityManagerController.class);	
	
	@RequestMapping("/user")
	public String toUser(){
		logger.debug("to user page");
		return "identity/user";
	}
	
	@RequestMapping("/account")
	public String toAccount(){
		logger.debug("to account page");
		return "identity/account";
	}
	
	@RequestMapping("/privilege")
	public String toPrivilege(){
		logger.debug("to account page");
		return "identity/privilege";
	}
	
	@RequestMapping("/userdetail")
	public String toUserDetail(){
		return "identity/userdetail";
	}
}
