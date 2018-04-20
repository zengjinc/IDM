package com.ssm.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.ResourceUtils;
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
import com.ssm.utils.properties.ConfigEmailUtil;

@Controller
@RequestMapping("/toconfig")
public class ConfigManagerController {
	
	@Autowired
	private IBusinessRoleService bizRoleService;
	
	 @Autowired
    private JavaMailSender javaMailSender;
	
	private static Logger logger = LoggerFactory.getLogger(ConfigManagerController.class);
	
	@RequestMapping("/systemconfig")
	public String toSystemConfig(ModelMap modelMap){
		String host = ConfigEmailUtil.getInstance().getValueByKey("host");
		String port = ConfigEmailUtil.getInstance().getValueByKey("port");
		String username = ConfigEmailUtil.getInstance().getValueByKey("username");
		String password = ConfigEmailUtil.getInstance().getValueByKey("password");
		String auth = ConfigEmailUtil.getInstance().getValueByKey("mail.smtp.auth");
		String ssl = ConfigEmailUtil.getInstance().getValueByKey("mail.smtp.ssl.enable");
		String startTls = ConfigEmailUtil.getInstance().getValueByKey("mail.smtp.starttls.enable");
		
		modelMap.put("host", host);
		modelMap.put("port", port);
		modelMap.put("username", username);
		modelMap.put("password", password);
		modelMap.put("auth", auth);
		modelMap.put("ssl", ssl);
		modelMap.put("startTls", startTls);
		return "config/systemconfig";
	}
	
	@RequestMapping("/gettemplate")
	@ResponseBody
	public String getTemplate(@RequestBody String jsonStr){
		BufferedInputStream bis = null;
		try{
			JsonNode rootNode = new ObjectMapper().readTree(jsonStr);
			String templateFlag = rootNode.get("template").asText();
			String templatePath = getVmTemplateBytemplateFlag(templateFlag);
			
			bis = new BufferedInputStream(new FileInputStream(new File(templatePath)));
			
			StringBuffer templateBody = new StringBuffer();
			byte[] buffer = new byte[1024];
			int flag = 0;
			while ((flag = bis.read(buffer)) != -1) {
				templateBody.append(new String(buffer, 0, flag));
			}
           
           return templateBody.toString();
		}catch(Exception e){
			e.printStackTrace();
			return e.getMessage();
		}finally{
			if(bis != null){
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	@RequestMapping("/savetemplate")
	@ResponseBody
	public String saveTemplate(@RequestBody String jsonStr){
		BufferedOutputStream bos = null;
		try{
			JsonNode rootNode = new ObjectMapper().readTree(jsonStr);
			String templateFlag = rootNode.get("template").asText();
			String templateBody = rootNode.get("templateBody").asText();
			
			String templatePath = getVmTemplateBytemplateFlag(templateFlag);
			
			bos = new BufferedOutputStream(new FileOutputStream(new File(templatePath)));
            bos.write(templateBody.getBytes(),0,templateBody.getBytes().length);
            bos.flush();
           
           return "success";
		}catch(Exception e){
			e.printStackTrace();
			return e.getMessage();
		}finally{
			if(bos != null){
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@RequestMapping("/saveemail")
	@ResponseBody
	public String saveEmail(@RequestBody String jsonStr){
		FileOutputStream oFile = null;
		try{
			String t=Thread.currentThread().getContextClassLoader().getResource("").getPath(); 
			 int num=t.indexOf(".metadata");
			 String path=t.substring(1,num).replace('/', '\\')+"idm\\config\\config.properties";
			
			JsonNode rootNode = new ObjectMapper().readTree(jsonStr);
			String host = rootNode.get("host").asText();
			String port = rootNode.get("port").asText();
			String ssl = rootNode.get("ssl").asText();
			String starttls = rootNode.get("starttls").asText();
			String auth = rootNode.get("auth").asText();
			String username = rootNode.get("username").asText();
			String pwd = rootNode.get("pwd").asText();
			
			//保存属性
			Properties prop = new Properties();
			oFile = new FileOutputStream(path);
			prop.setProperty("host", host);
			prop.setProperty("port", port);
			prop.setProperty("mail.smtp.ssl.enable", ssl);
			prop.setProperty("mail.smtp.starttls.enable", starttls);
			prop.setProperty("mail.smtp.auth", auth);
			prop.setProperty("username", username);
			prop.setProperty("password", pwd);
			prop.store(oFile, null);
			oFile.flush();
			
			return "success";
		}catch(Exception e){
			e.printStackTrace();
			return e.getMessage();
		}finally{
			if(oFile != null){
				try {
					oFile.close();
				} catch (IOException e) {
					e.printStackTrace();
					return e.getMessage();
				}
			}
		}
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
			example.setOrderByClause("biz_role_id");
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
	
	
	public String getVmTemplateBytemplateFlag(String templateFlag){
		String templatePath = null;
		
		if(templateFlag.equalsIgnoreCase("etm_finish")){
			templatePath = "temp/etm_finish.vm";
		}
		if(templateFlag.equalsIgnoreCase("etm_cancel")){
			templatePath = "temp/etm_cancel.vm";
		}
		if(templateFlag.equalsIgnoreCase("etm_enable")){
			templatePath = "temp/etm_enable.vm";
		}
		if(templateFlag.equalsIgnoreCase("etm_disable")){
			templatePath = "temp/etm_disable.vm";
		}
		if(templateFlag.equalsIgnoreCase("change_password")){
			templatePath = "temp/change_password.vm";
		}
		
		return templatePath;
	}
}
