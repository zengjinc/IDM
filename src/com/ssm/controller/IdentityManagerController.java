package com.ssm.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.ssm.pojo.Account;
import com.ssm.pojo.AccountAttribute;
import com.ssm.pojo.Resource;
import com.ssm.pojo.User;
import com.ssm.pojo.to.EntitlementTo;
import com.ssm.service.IAccountAttributeService;
import com.ssm.service.IAccountService;
import com.ssm.service.IEntitlementService;
import com.ssm.service.IResourceService;
import com.ssm.service.IUserService;

@Controller
@RequestMapping("/toidentity")
public class IdentityManagerController {

	private static Logger logger = LoggerFactory.getLogger(IdentityManagerController.class);	
	
	@Autowired
	@Qualifier("userService")
	private IUserService userService;
	
	@Autowired
	private IResourceService resourceService;
	
	@Autowired
	private IAccountService accountService;
	
	@Autowired
	private IEntitlementService entitlementService;
	
	@Autowired
	private IAccountAttributeService accountAttributeService;
	
	@RequestMapping("/user")
	public String toUser(ModelMap modelMap, @RequestParam(required = true, defaultValue = "1") int page, @RequestParam(defaultValue = "5") int limit) throws Exception{	//使用 @Value 从文件从读取 defaultValue，保持全局统一
		logger.debug("to user page");
		PageBounds pageBounds = new PageBounds(page,limit);
		List<User> userList = userService.getUserByExample(null , pageBounds);
		modelMap.put("userList", userList);
		return "identity/user";
	}
	
	@RequestMapping("/account")
	public String toAccount(ModelMap modelMap, @RequestParam(required = true, defaultValue = "1") int page, @RequestParam(defaultValue = "5") int limit) throws Exception{
		logger.debug("to account page");
		PageBounds pageBounds = new PageBounds(page,limit);
		List<User> userList = userService.getUserByExample(null , pageBounds);
		modelMap.put("userList", userList);
		return "identity/account";
	}
	
	@RequestMapping("/privilege")
	public String toPrivilege(ModelMap modelMap, @RequestParam(required = true, defaultValue = "1") int page, @RequestParam(defaultValue = "5") int limit) throws Exception{
		logger.debug("to account page");
		PageBounds pageBounds = new PageBounds(page,limit);
		List<User> userList = userService.getUserByExample(null , pageBounds);
		modelMap.put("userList", userList);
		return "identity/privilege";
	}
	
	@RequestMapping("/userdetail")
	public String toUserDetail(ModelMap modelMap, @RequestParam(required = true,value="useruuid") String userUuid) throws Exception{
		System.out.println(userUuid);
		User user = userService.getUserByPrimaryKey(userUuid);
		modelMap.put("user", user);
		return "identity/userdetail";
	}
	
	@RequestMapping("/accountdetail")
	public String toAccountDetail(ModelMap modelMap, @RequestParam(required = true,value="useraccountuuid") String userUuid,@RequestParam(required = true, defaultValue = "1") int page, 
			@RequestParam(defaultValue = "5") int limit) throws Exception{
		User user = userService.getUserByPrimaryKey(userUuid);
		modelMap.put("user", user);
		PageBounds pageBounds = new PageBounds(page, limit);
		List<EntitlementTo> entitlementList = entitlementService.getUserEntitlement(userUuid,pageBounds);
		modelMap.put("entitlementList", entitlementList);
		return "identity/accountdetail";
	}
	
	@RequestMapping("/privilegedetail")
	public String toPrivilegeDetail(ModelMap modelMap, @RequestParam(required = true,value="userprivilegeuuid") String userUuid) throws Exception{
		User user = userService.getUserByPrimaryKey(userUuid);
		modelMap.put("user", user);
		return "identity/privilegedetail";
	}
	
	@RequestMapping("/enableuser")
	public String enableUser(){
		//获取用户id
		//该用户对应的账号
		/*
		 * 禁用该账号
		 */
		//账号对应的resource
		//将 resource 对象注入jdbc连接器
		//调用连接器禁用账号的方法，传入账号id 或者 tgt_uuid
		return "success";
	}
	
	@RequestMapping("/getnontrustresource")
	@ResponseBody
	public List<Resource> getNonTrustResource() throws Exception{
		List<Resource> allResourceNonTrust = resourceService.getAllResourceNonTrust();
		return allResourceNonTrust;
	}
	
	@RequestMapping("/getaccountbyresuuid")
	@ResponseBody
	public List<Account> getAccountByResUuid(@RequestBody String resUuid) throws Exception{
		System.out.println(resUuid);
		List<Account> accountList = accountService.getAccountsByResUuid(resUuid.replace("\"", ""));
		return accountList;
	}
	
	@RequestMapping("/getacctattrbyresuuid")
	@ResponseBody
	public List<String> getAcctAttrByResUuid(@RequestBody String resUuid) throws Exception{
		List<String> targetNameList = resourceService.getAcctAttrByResUuid(resUuid.replace("\"", ""));
		return targetNameList;
	}
	
	@RequestMapping("/entitlement")
	@ResponseBody
	public String entitlement(@RequestBody String jsonStr) throws Exception{
		try{
			ObjectMapper mapper = new ObjectMapper();
			JsonNode rootNode = mapper.readTree(jsonStr);
			String userUuid = rootNode.get("userUuid").asText();
			String acctUuid = rootNode.get("acctUuid").asText();
			String resUuid = rootNode.get("resUuid").asText();
			int result = entitlementService.entitlement(userUuid, acctUuid,resUuid);
			if(result <= 0){
				return "failure";
			}
		}catch(Exception e){
			return e.getMessage();
		}
		return "success";
	}
	
	@RequestMapping("/disableentitlement")
	@ResponseBody
	public String disableEntitlement(@RequestBody String jsonStr){
		try{
			ObjectMapper mapper = new ObjectMapper();
			JsonNode rootNode = mapper.readTree(jsonStr);
			String userUuid = rootNode.get("userUuid").asText();
			JsonNode acctMsgNode = rootNode.get("acctMsg");
			Iterator<JsonNode> it = acctMsgNode.elements();
			while(it.hasNext()){
				JsonNode tempNode = it.next();
				String acctUuid = tempNode.get("tgtuuid").asText();
				String resUuid = tempNode.get("resuuid").asText();
				entitlementService.disableEntitlement(userUuid, acctUuid,resUuid);
			}
		}catch(Exception e){
			return e.getMessage();
		}
		return "success";
	}
	
	@RequestMapping("/enableentitlement")
	@ResponseBody
	public String enableEntitlement(@RequestBody String jsonStr){
		try{
			ObjectMapper mapper = new ObjectMapper();
			JsonNode rootNode = mapper.readTree(jsonStr);
			String userUuid = rootNode.get("userUuid").asText();
			JsonNode acctMsgNode = rootNode.get("acctMsg");
			Iterator<JsonNode> it = acctMsgNode.elements();
			while(it.hasNext()){
				JsonNode tempNode = it.next();
				String acctUuid = tempNode.get("tgtuuid").asText();
				String resUuid = tempNode.get("resuuid").asText();
				entitlementService.enableEntitlement(userUuid, acctUuid,resUuid);
			}
		}catch(Exception e){
			return e.getMessage();
		}
		return "success";
	}
	
	@RequestMapping("/deleteentitlement")
	@ResponseBody
	public String deleteEntitlement(@RequestBody String jsonStr){
		try{
			ObjectMapper mapper = new ObjectMapper();
			JsonNode rootNode = mapper.readTree(jsonStr);
			String userUuid = rootNode.get("userUuid").asText();
			JsonNode acctMsgNode = rootNode.get("acctMsg");
			Iterator<JsonNode> it = acctMsgNode.elements();
			while(it.hasNext()){
				JsonNode tempNode = it.next();
				String acctUuid = tempNode.get("tgtuuid").asText();
				String resUuid = tempNode.get("resuuid").asText();
				entitlementService.deleteEntitlement(userUuid, acctUuid,resUuid);
			}
		}catch(Exception e){
			return e.getMessage();
		}
		return "success";
	}
	
	@RequestMapping("/getacctattrbyacctuuid")
	@ResponseBody
	public List<AccountAttribute> getAcctAttrByAcctUuid(@RequestBody String acctUuid) throws Exception{
		return accountAttributeService.getAcctAttrByAcctUuid(acctUuid.replace("\"", ""));
	}
	
	@RequestMapping("/resetpassword")
	@ResponseBody
	public String resetPassword(@RequestBody String jsonStr){
		try {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode rootNode = mapper.readTree(jsonStr);
			String resUuid = rootNode.get("resUuid").asText();
			String acctUuid = rootNode.get("acctUuid").asText();
			String userUuid = rootNode.get("userUuid").asText();
			String oldPwd = rootNode.get("oldPwd").asText();
			String newPwd = rootNode.get("newPwd").asText();
			String newPwd2 = rootNode.get("newPwd2").asText();
			if (oldPwd != null && newPwd != null && newPwd2 != null && newPwd.equals(newPwd2)
					&& entitlementService.verifyPassword(acctUuid, oldPwd, resUuid)) {
				if(entitlementService.resetPassword(acctUuid, newPwd, resUuid)){
					return "success";
				}
			}
		} catch (Exception e) {
			return e.getMessage();
		}
		return "failure";
	}
	
	@RequestMapping("/updateaccountattribute")
	@ResponseBody
	public String updateAccountAttribute(@RequestBody String jsonStr){
		try {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode rootNode = mapper.readTree(jsonStr);
			/*
			 *	*************************************未完待续********************************************* 
			 */
			logger.debug("test : " + rootNode);
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
		return "failure";
	}
	
}
