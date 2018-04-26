package com.ssm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ssm.mapper.RelUserBizroleMapper;
import com.ssm.pojo.Account;
import com.ssm.pojo.AccountAttribute;
import com.ssm.pojo.BusinessRole;
import com.ssm.pojo.Itrole;
import com.ssm.pojo.RelUserBizrole;
import com.ssm.pojo.RelUserBizroleExample;
import com.ssm.pojo.Resource;
import com.ssm.pojo.ResourceExample;
import com.ssm.pojo.User;
import com.ssm.pojo.UserExample;
import com.ssm.pojo.UserQueryExample;
import com.ssm.pojo.UserQueryExample.Criteria;
import com.ssm.pojo.to.EntitlementTo;
import com.ssm.pojo.to.PrivilegeTo;
import com.ssm.pojo.to.UserQueryTo;
import com.ssm.service.IAccountAttributeService;
import com.ssm.service.IAccountService;
import com.ssm.service.IBusinessRoleService;
import com.ssm.service.IEntitlementService;
import com.ssm.service.IItroleService;
import com.ssm.service.IJavaMailSenderService;
import com.ssm.service.IPrivilegeService;
import com.ssm.service.IResourceService;
import com.ssm.service.IUserBizRoleService;
import com.ssm.service.IUserService;
import com.ssm.utils.CommonUtil;

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
	
	@Autowired
	private IItroleService itroleService;
	
	@Autowired
	private IPrivilegeService privilegeService;
	
	@Autowired
	private IUserBizRoleService userBizRoleService;
	
	@Autowired
	private IJavaMailSenderService mailSenderService;
	
	@Autowired
	private IBusinessRoleService bizRoleService;
	
	@Autowired
	private RelUserBizroleMapper relUserBizRoleMapper;
	
	
	@RequestMapping("/user")
	public String toUser(ModelMap modelMap, @RequestParam(required = true, defaultValue = "1") int page, @RequestParam(defaultValue = "5") int limit) throws Exception{	//使用 @Value 从文件从读取 defaultValue，保持全局统一
		logger.debug("to user page");
		PageBounds pageBounds = new PageBounds(page,limit);
		UserExample example = new UserExample();
		example.setOrderByClause("user_id");
		List<User> userList = userService.getUserByExample(example  , pageBounds);
		modelMap.put("userList", userList);
		return "identity/user";
	}
	
	@RequestMapping("/userquery")
	public String userQuery(ModelMap modelMap, @RequestParam(required = true, defaultValue = "1") int page, @RequestParam(defaultValue = "5") int limit,@ModelAttribute UserQueryTo userQueryTo) throws Exception{
//		if(userQueryTo.getUserId().length() == 0){
//			userQueryTo.setUserId(null);
//		}
//		if(userQueryTo.getUserName().length() == 0){
//			userQueryTo.setUserName(null);
//		}
//		if(userQueryTo.getUserBizRole().length() == 0){
//			userQueryTo.setUserBizRole(null);
//		}
//		if(userQueryTo.getTrustResource().length() == 0){
//			userQueryTo.setTrustResource(null);
//		}
//		if(userQueryTo.getUserStatus().length() == 0){
//			userQueryTo.setUserStatus(null);
//		}
		//		List<User> userList = userService.queryUser(userQueryTo);
		
		UserQueryExample example = new UserQueryExample();
		Criteria criteria = example.createCriteria();
		if(userQueryTo.getUserId().length() > 0){
			criteria.andUserIdEqualTo(userQueryTo.getUserId());
		}
		if(userQueryTo.getUserName().length() > 0){
			criteria.andUserNameLike("%" + userQueryTo.getUserName() + "%");
		}
		if(userQueryTo.getUserStatus().length() > 0){
			criteria.andUserStatusEqualTo(Integer.parseInt(userQueryTo.getUserStatus()));
		}
		if(userQueryTo.getUserBizRole().length() > 0){
			
				RelUserBizroleExample example2 = new RelUserBizroleExample();
				example2.createCriteria().andRelUserBizroleBizroleUuidEqualTo(userQueryTo.getUserBizRole());
				List<RelUserBizrole> list = relUserBizRoleMapper.selectByExample(example2);
				
				List<String> values = new ArrayList<>(list.size());
				
				for(RelUserBizrole r : list){
					values.add(r.getRelUserBizroleUserUuid());
				}
				
				criteria.andUserUuidIn(values);
		}
		if(userQueryTo.getTrustResource().length() > 0){
			
			if(userQueryTo.getTrustResource().equalsIgnoreCase("1")){
				
				ResourceExample example1 = new ResourceExample();
				example1.createCriteria().andResTrustEqualTo(Integer.parseInt(userQueryTo.getTrustResource()));
				List<Resource> resourceList = resourceService.getResourceByExample(example1);
				
				List<String> values = new ArrayList<>(resourceList.size());
				for(Resource res : resourceList){
					values.add(res.getResUuid());
				}
				
				criteria.andUserResUuidIn(values);
			}else{
				
				criteria.andUserResUuidIsNull();
			}
		}
		
		PageBounds pageBounds = new PageBounds(page, limit);
		example.setOrderByClause("user_id");
		List<User> userList = userService.queryUser(example,pageBounds);
		modelMap.put("userList", userList);
		return "identity/user";
	}
	
	
	@RequestMapping("/usercreate")
	public String createUser(){
		
		return "identity/userdetail";
	}
	
	@RequestMapping("/saveuser")
	@ResponseBody
	public String saveUser(@RequestBody String jsonStr){
		try{
			JsonNode rootNode = new ObjectMapper().readTree(jsonStr);
			String userUuid = rootNode.get("userUuid").asText();
			String userId = rootNode.get("userId").asText();
			String userName = rootNode.get("userName").asText();
			String userStatus = rootNode.get("userStatus").asText();
//			String userType = rootNode.get("userType").asText();
			String userEmail = rootNode.get("userEmail").asText();
			String userEmployeeId = rootNode.get("userEmployeeId").asText();
			String userPhoneNumber = rootNode.get("userPhoneNumber").asText();
			
			User user = new User();
			if(userId != ""){user.setUserId(userId);}
			if(userName != ""){user.setUserName(userName);}
			if(userStatus != ""){user.setUserStatus(Integer.parseInt(userStatus));}
//			if(userType != ""){user.setUserType(userType);}
			if(userEmail != ""){user.setUserEmail(userEmail);}
			if(userEmployeeId != ""){user.setUserEmployeeId(userEmployeeId);}
			if(userPhoneNumber != ""){user.setUserPhonenumber(userPhoneNumber);}
			
			int flag = 0;
			if(userUuid != ""){
				user.setUserUuid(userUuid);
				flag = userService.updateUserByPrimaryKey(user);
			}else{
				user.setUserUuid(CommonUtil.generateUUID());
				user.setUserStatus(1);
				flag = userService.addUser(user);
			}
			
			if(flag > 0){
				return "success";
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return e.getMessage();
		}
		return "failure";
	}
	
	
	@RequestMapping("/account")
	public String toAccount(ModelMap modelMap, @RequestParam(required = true, defaultValue = "1") int page, @RequestParam(defaultValue = "5") int limit) throws Exception{
		logger.debug("to account page");
		PageBounds pageBounds = new PageBounds(page,limit);
		UserExample example = new UserExample();
		example.setOrderByClause("user_id");
		List<User> userList = userService.getUserByExample(example  , pageBounds);
		modelMap.put("userList", userList);
		return "identity/account";
	}
	
	@RequestMapping("/privilege")
	public String toPrivilege(ModelMap modelMap, @RequestParam(required = true, defaultValue = "1") int page, @RequestParam(defaultValue = "5") int limit) throws Exception{
		logger.debug("to account page");
		PageBounds pageBounds = new PageBounds(page,limit);
		UserExample example = new UserExample();
		example.setOrderByClause("user_id");
		List<User> userList = userService.getUserByExample(example  , pageBounds);
		modelMap.put("userList", userList);
		return "identity/privilege";
	}
	
	@RequestMapping("/userdetail")
	public String toUserDetail(ModelMap modelMap, @RequestParam(required = true,value="useruuid") String userUuid) throws Exception{
//		System.out.println(userUuid);
//		User user = userService.getUserByPrimaryKey(userUuid);
//		List<BusinessRole> userBizRoleList = userBizRoleService.getUserBizRole(userUuid);
//		
//		StringBuffer sb = new StringBuffer();
//		for(BusinessRole bizRole : userBizRoleList){
//			sb.append(bizRole.getBizRoleId() + "(" + bizRole.getBizRoleName() + ");\n");
//		}
//		modelMap.put("user", user);
//		modelMap.put("userBizRoleList", sb.toString());
		return "identity/userdetail";
	}
	
	@RequestMapping("/getUserInfo")
	@ResponseBody
	public Map<String,Object> getUserInfo(@RequestBody String jsonStr) throws Exception{
		
		String userUuid = new ObjectMapper().readTree(jsonStr).get("userUuid").asText();
		
		User user = userService.getUserByPrimaryKey(userUuid);
		List<BusinessRole> userBizRoleList = userBizRoleService.getUserBizRole(userUuid);
		
		StringBuffer sb = new StringBuffer();
		for(BusinessRole bizRole : userBizRoleList){
			sb.append(bizRole.getBizRoleId() + "(" + bizRole.getBizRoleName() + ");\n");
		}
		
		Map<String,Object> resultMap = new HashMap<>();
		
		resultMap.put("user", user);
		resultMap.put("userBizRoleList", sb.toString());
		
		return resultMap;
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
	public String toPrivilegeDetail(ModelMap modelMap, @RequestParam(required = true,value="userprivilegeuuid") String userUuid,@RequestParam(required = true, defaultValue = "1") int page, @RequestParam(defaultValue = "5") int limit) throws Exception{
		User user = userService.getUserByPrimaryKey(userUuid);
		PageBounds pageBounds = new PageBounds(page, limit);
		List<PrivilegeTo> privilegeToList = privilegeService.getPrivilegeByUserUuid(userUuid,pageBounds);
		
		PageList<PrivilegeTo> pageList = (PageList<PrivilegeTo>) privilegeToList;
		int totalPages = pageList.getPaginator().getTotalPages();
		int currPage = pageList.getPaginator().getPage();
		
		Map<String,Integer> privilegeToListPaginator = new HashMap<>();
		privilegeToListPaginator.put("totalPages", totalPages);
		privilegeToListPaginator.put("page", currPage);
		
		modelMap.put("user", user);
		modelMap.put("privilegeToList", privilegeToList);
		modelMap.put("privilegeToListPaginator", privilegeToListPaginator);
		return "identity/privilegedetail";
	}
	
	@RequestMapping("/enableuser")
	@ResponseBody
	public String enableUser(@RequestBody String jsonStr) throws Exception{
		//获取用户id
		JsonNode rootNode = new ObjectMapper().readTree(jsonStr);
		Iterator<JsonNode> it = rootNode.get("userList").elements();
		while(it.hasNext()){
			//更改用户和账号的状态
			String userUuid = it.next().asText();
			
			User user = userService.getUserByPrimaryKey(userUuid);
			user.setUserStatus(1);
			userService.updateUserByPrimaryKey(user);
			
			Account account = accountService.getAccountByAcctUuid(userUuid);
			account.setAcctStatus(1);
			accountService.updateAccountByPrimaryKey(account);
			
			List<Account> userAccounts = entitlementService.getUserAccounts(userUuid);
			
			//禁用该账号
			for(Account acct : userAccounts){
				entitlementService.enableEntitlement(userUuid, acct.getAcctTgtUuid(), acct.getAcctResUuid());
			}
			
		}
		return "success";
	}
	
	@RequestMapping("/disableuser")
	@ResponseBody
	public String disableUser(@RequestBody String jsonStr) throws Exception{
		//获取用户id
		JsonNode rootNode = new ObjectMapper().readTree(jsonStr);
		Iterator<JsonNode> it = rootNode.get("userList").elements();
		while(it.hasNext()){
			//更改用户和账号的状态
			String userUuid = it.next().asText();
			
			User user = userService.getUserByPrimaryKey(userUuid);
			user.setUserStatus(0);
			userService.updateUserByPrimaryKey(user);
			
			Account account = accountService.getAccountByAcctUuid(userUuid);
			account.setAcctStatus(0);
			accountService.updateAccountByPrimaryKey(account);
			
			List<Account> userAccounts = entitlementService.getUserAccounts(userUuid);
			
			//禁用该账号
			for(Account acct : userAccounts){
				entitlementService.disableEntitlement(userUuid, acct.getAcctTgtUuid(), acct.getAcctResUuid());
			}
			
		}
		return "success";
	}
	
	@RequestMapping("/deleteuser")
	@ResponseBody
	public String deleteUser(@RequestBody String jsonStr) throws Exception{
		//获取用户id
		JsonNode rootNode = new ObjectMapper().readTree(jsonStr);
		Iterator<JsonNode> it = rootNode.get("userList").elements();
		while(it.hasNext()){
			
			//删除目标资源中的授权
			String userUuid = it.next().asText();
			List<Account> userAccounts = entitlementService.getUserAccounts(userUuid);
			
			for(Account acct : userAccounts){
				entitlementService.deleteEntitlement(userUuid, acct.getAcctTgtUuid(), acct.getAcctResUuid());
			}
			
			//删除账号和用户
			accountService.deleteAccount(userUuid);
			userService.deleteUser(userUuid);
			
		}
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
	
	@RequestMapping("/getitrolebyresuuid")
	@ResponseBody
	public Map<String,List<Itrole>> getItroleByResUuid(@RequestBody String jsonStr) throws Exception{
		JsonNode rootNode = new ObjectMapper().readTree(jsonStr);
		String resUuid = rootNode.get("resUuid").asText();
		String acctUuid = rootNode.get("acctUuid").asText();
		return itroleService.getItroleByResourceUuid(resUuid,acctUuid);
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
	
	@RequestMapping("/assignitrole")
	@ResponseBody
	public String privilege(@RequestBody String jsonStr){
		try{
			JsonNode rootNode = new ObjectMapper().readTree(jsonStr);
			String acctUuid = rootNode.get("acctUuid").asText();
			String itroleUuid = rootNode.get("itroleUuid").asText();
			String resUuid = rootNode.get("resUuid").asText();
			if(privilegeService.entitlement(acctUuid, itroleUuid, resUuid) > 0){
				return "success";
			}else{
				return "身份管理系统本地分配权限失败";
			}
		}catch(Exception e){
			return e.getMessage();
		}
	}
	
	@RequestMapping("/unassignitrole")
	@ResponseBody
	public String revokePrivilege(@RequestBody String jsonStr){
		try{
			JsonNode rootNode = new ObjectMapper().readTree(jsonStr);
			String acctUuid = rootNode.get("acctUuid").asText();
			String itroleUuid = rootNode.get("itroleUuid").asText();
			String resUuid = rootNode.get("resUuid").asText();
			if(privilegeService.revokeEntitlement(acctUuid, itroleUuid, resUuid) > 0){
				return "success";
			}else{
				return "身份管理系统本地取消分配权限失败";
			}
		}catch(Exception e){
			return e.getMessage();
		}
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
			String acctTgtUuid = rootNode.get("acctUuid").asText();
			String userUuid = rootNode.get("userUuid").asText();
//			String oldPwd = rootNode.get("oldPwd").asText();
			String newPwd = rootNode.get("newPwd").asText();
			String newPwd2 = rootNode.get("newPwd2").asText();
			if (newPwd != null && newPwd2 != null && newPwd.equals(newPwd2)) {
				if(entitlementService.resetPassword(acctTgtUuid, newPwd, resUuid)){
					//发送修改密码的邮件
					User user = userService.getUserByPrimaryKey(userUuid);
					Resource resource = resourceService.getResourceByPrimarKey(resUuid);
					Account account = accountService.getAccountByAcctTgtUuid(acctTgtUuid);
					mailSenderService.changePasswordEmail(user.getUserEmail(), user.getUserName(), resource.getResName(), account.getAcctLoginId(), newPwd);
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
			String resUuid = rootNode.get("resUuid").asText();
			String acctUuid = rootNode.get("acctUuid").asText();
			JsonNode acctAttrNode = rootNode.get("acctAttr");
			
			Map<String,String> attributesMap = new HashMap<>();
			Iterator<JsonNode> it = acctAttrNode.elements();
			while(it.hasNext()){
				JsonNode tempNode = it.next();
				Iterator<String> fieldNames = tempNode.fieldNames();
				while(fieldNames.hasNext()){
					String key = fieldNames.next();
					String value = tempNode.get(key).asText();
					attributesMap.put(key, value);
				}
			}
			
			if(entitlementService.updataAccountAttribute(acctUuid, attributesMap, resUuid)){
				return "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
		return "failure";
	}
	
	/*
	 * 创建对应资源的账号，并分配给当前账号
	 */
	@RequestMapping("/createaccount")
	@ResponseBody
	public String createAccount(@RequestBody String jsonStr){
		logger.debug(jsonStr);
		try{
			JsonNode rootNode = new ObjectMapper().readTree(jsonStr);
			String userId = rootNode.get("userId").asText();
			String userUuid = rootNode.get("userUuid").asText();
			String resId = rootNode.get("resId").asText();
			String resUuid = rootNode.get("resUuid").asText();
			String acctId = rootNode.get("acctId").asText();
			String acctPwd = rootNode.get("acttPwd").asText();
			String acctPwd2 = rootNode.get("acttPwd2").asText();
			
			Map<String,String> basicAttrsMap = new HashMap<>();
			basicAttrsMap.put("userId", userId);
			basicAttrsMap.put("userUuid", userUuid);
			basicAttrsMap.put("resId", resId);
			basicAttrsMap.put("resUuid", resUuid);
			basicAttrsMap.put("acctId", acctId);
			basicAttrsMap.put("acctPwd", acctPwd);
			basicAttrsMap.put("acctPwd2", acctPwd2);
			
			Map<String,String> acctAttrsMap = new HashMap<>();
			JsonNode acctAttrNode = rootNode.get("acctAttr");
			Iterator<JsonNode> it = acctAttrNode.elements();
			while(it.hasNext()){
				JsonNode next = it.next();
				Iterator<String> fieldNames = next.fieldNames();
				while(fieldNames.hasNext()){
					String key = fieldNames.next();
					String value = next.get(key).asText();
					acctAttrsMap.put(key, value);
				}
			}
		if(accountService.createAccount(basicAttrsMap,acctAttrsMap)){
			return "success";
		}
		}catch(Exception e){
			e.printStackTrace();
			return e.getMessage();
		}
		return "failure";
	}
	
	@RequestMapping("/userbizrole")
	@ResponseBody
	public String userBizRole(@RequestBody String jsonStr){
		try{
			JsonNode rootNode = new ObjectMapper().readTree(jsonStr);
			String userUuid = rootNode.get("userUuid").asText();
			Iterator<JsonNode> it = rootNode.get("bizRoleArr").elements();
			
			List<String> bizRoleList = new ArrayList<>();
			while(it.hasNext()){
				bizRoleList.add(it.next().asText());
			}
			if(userBizRoleService.updateUserBizRole(userUuid, bizRoleList)){
				return "success";
			}
		}catch(Exception e){
			e.printStackTrace();
			return e.getMessage();
		}
		return "failure";
	}
}
