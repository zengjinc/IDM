package com.ssm.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.ssm.pojo.BusinessRole;
import com.ssm.pojo.BusinessRoleExample;
import com.ssm.pojo.BusinessRoleExample.Criteria;
import com.ssm.service.IBusinessRoleService;
import com.ssm.utils.CommonUtil;

@Controller
@RequestMapping("/toconfig")
public class ConfigManagerController {
	
	@Autowired
	private IBusinessRoleService bizRoleService;

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
	public String toBizRole(ModelMap modelMap, @ModelAttribute BusinessRole bizRole,@RequestParam(required = true, defaultValue = "1") int page, @RequestParam(defaultValue = "5") int limit) throws Exception{
		PageBounds pageBounds = new PageBounds(page, limit);
		
		String bizRoleId = bizRole.getBizRoleId();
		String bizRoleName = bizRole.getBizRoleName();
		if((bizRoleId != null && bizRoleId.length() > 0) || (bizRoleName != null && bizRoleName.length() > 0)){
			BusinessRoleExample example = new BusinessRoleExample();
			Criteria criteria = example.createCriteria();
			
			if(bizRoleId != null && bizRoleId.length() > 0){
				criteria.andBizRoleIdEqualTo(bizRoleId);
			}
			
			if(bizRoleName != null && bizRoleName.length() > 0){
				criteria.andBizRoleNameLike("%" + bizRoleName + "%");
			}
			
			List<BusinessRole> bizRoleList = bizRoleService.getBizRoleByExample(example , pageBounds);
			modelMap.put("bizRoleList", bizRoleList);
		}else{
			List<BusinessRole> bizRoleList = bizRoleService.getAllBizRole(pageBounds);
			modelMap.put("bizRoleList", bizRoleList);
		}
		return "config/bizrole";
	}
	
	@RequestMapping("/listallbizrole")
	@ResponseBody
	public List<BusinessRole> listAllBizRole() throws Exception{
		return bizRoleService.listAllBizRole();
	}
	
	@RequestMapping("/bizroledetail")
	public String toBizRoleDetail(){
		return "config/bizroledetail";
	}
	
	@RequestMapping("/platformrole")
	public String toPlatformRole(){
		return "config/platformrole";
	}
	
	@RequestMapping("/savebizrole")
	@ResponseBody
	public String saveBizRole(@RequestBody String jsonStr){
		try{
			JsonNode rootNode = new ObjectMapper().readTree(jsonStr);
			String bizRoleUuid = rootNode.get("bizRoleUuid").asText();
			String bizRoleId = rootNode.get("bizRoleId").asText();
			String bizRoleName = rootNode.get("bizRoleName").asText();
			String bizRoleDesc = rootNode.get("bizRoleDesc").asText();
			
			BusinessRole bizRole = new BusinessRole();
			bizRole.setBizRoleId(bizRoleId);
			bizRole.setBizRoleName(bizRoleName);
			bizRole.setBizRoleDesc(bizRoleDesc);
			
			if(bizRoleUuid != null && bizRoleUuid != "" && bizRoleUuid != "null"){
				bizRole.setBizRoleUuid(bizRoleUuid);
				if(bizRoleService.updateBizeRole(bizRole) > 0){
					return "success";
				}
			}else{
				bizRole.setBizRoleUuid(CommonUtil.generateUUID());
				if(bizRoleService.addBizRole(bizRole) > 0){
					return "success";
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			return e.getMessage();
		}
		
		return "failure";
	}
	
	@RequestMapping("/getbizrole")
	@ResponseBody
	public BusinessRole getBizRole(@RequestBody String jsonStr){
		try{
			JsonNode rootNode = new ObjectMapper().readTree(jsonStr);
			String bizRoleUuid = rootNode.get("bizRoleUuid").asText();
			return bizRoleService.getBizRole(bizRoleUuid);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping("/delbizrole")
	public String delBozRole(@RequestParam(value="bizroleuuid")String bizRoleUuid) throws Exception{
		bizRoleService.deleteBizRole(bizRoleUuid);
		return "redirect:bizrole.action";
	}
	
}
