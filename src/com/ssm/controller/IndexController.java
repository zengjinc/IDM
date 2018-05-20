package com.ssm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.mapper.UserMapper;
import com.ssm.pojo.User;

@Controller
public class IndexController {
	
	private static Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping("/toidentity")
	public String toIdentity(){
		User user = userMapper.selectByPrimaryKey("idmadmin");
		logger.debug(user.toString());
//		return "identity/user";
		return "redirect:/toidentity/user.action";
	}
	
	@RequestMapping("/toou")
	public String toOu(){
		return "redirect:/toou/ou.action";
	}
	
	@RequestMapping("/toresource")
	public String toResource(){
		return "redirect:/toresource/resource.action";
	}
	
	@RequestMapping("/topolicy")
	public String toPolicy(){
		return "redirect:/topolicy/entitlement.action";
	}
	
	@RequestMapping("/totask")
	public String toTask(){
		return "redirect:/totask/task.action";
	}
	
	@RequestMapping("/toconfig")
	public String toConfig(){
		return "redirect:/toconfig/systemconfig.action";
	}
	
	
}
