package com.ssm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.connector.IConnector;
import com.ssm.mapper.AccountAttributeMapper;
import com.ssm.mapper.AccountMapper;
import com.ssm.mapper.EntitlementMapper;
import com.ssm.pojo.Account;
import com.ssm.pojo.AccountAttribute;
import com.ssm.pojo.AccountExample;
import com.ssm.pojo.Entitlement;
import com.ssm.pojo.Resource;
import com.ssm.service.IAccountService;
import com.ssm.service.IConnectorService;
import com.ssm.service.IResourceService;
import com.ssm.utils.CommonUtil;
@Service
public class AccountService implements IAccountService{

	private static Logger logger = LoggerFactory.getLogger(AccountService.class);
	
	@Autowired
	private AccountMapper accountMapper;
	
	@Autowired
	private EntitlementMapper entitlementMapper;
	
	@Autowired
	private AccountAttributeMapper accountAttributeMapper;
	
	@Autowired
	private IConnectorService connectorService;
	
	@Autowired
	private IResourceService resourceService;
	
	@Override
	public List<Account> getAccountsByResUuid(String resUuid) throws Exception{
		AccountExample example = new AccountExample();
		example.createCriteria().andAcctResUuidEqualTo(resUuid);
		example.setOrderByClause("acct_login_id");
		List<Account> accountList = accountMapper.selectByExample(example);
		//排除掉已分配的主账号
		List<Entitlement> entitlementList = entitlementMapper.selectByExample(null);
		List<String> assignedAccountList = new ArrayList<>(entitlementList.size());
		for(Entitlement e : entitlementList){
			assignedAccountList.add(e.getEtmAcctUuid());
		}
		Iterator<Account> it = accountList.iterator();
		while(it.hasNext()){
			Account account = it.next();
			if(account.getAcctPrimary() == 1 && assignedAccountList.contains(account.getAcctTgtUuid())){
				it.remove();
			}
		}
		return accountList;
	}
	
	@Override
	public Account getAccountByAcctTgtUuid(String acctTgtUuid) throws Exception{
		AccountExample example = new AccountExample();
		example.createCriteria().andAcctTgtUuidEqualTo(acctTgtUuid);
		List<Account> accountList = accountMapper.selectByExample(example);
		if(accountList.size() > 0){
			return accountList.get(0);
		}
		return null;
	}
	
	@Override
	public Account getAccountByAcctUuid(String userUuid) throws Exception{
		return accountMapper.selectByPrimaryKey(userUuid);
	}
	
	@Override
	public int updateAccountByPrimaryKey(Account account) throws Exception{
		return accountMapper.updateByPrimaryKey(account);
	}
	
	/**
	 * 创建账号：新增项到 account、account_attribute、entitlement和第三方资源 
	 * @throws Exception 
	 */
	@Override
	public boolean createAccount(Map<String,String> basicAttributesMap, Map<String,String> attributesMap) throws Exception {

		String userId = basicAttributesMap.get("userId");
		String userUuid = basicAttributesMap.get("userUuid");
		String resId = basicAttributesMap.get("resId");
		String resUuid = basicAttributesMap.get("resUuid");
		String acctId = basicAttributesMap.get("acctId");
		String acctPwd = basicAttributesMap.get("acctPwd");
		String acctPwd2 = basicAttributesMap.get("acctPwd2");
		
		/*
		 * 封装账号属性到 attributesMap	(acctPwd,resId)	
		 */
		Resource resource = resourceService.getResourceByPrimarKey(resUuid);
		JsonNode rootNode = new ObjectMapper().readTree(resource.getResJsonAttr());
		JsonNode acctJson = rootNode.get("acctJson");
		String pwdCol = acctJson.get("pwd_col").asText();
		String accountIdShowName = acctJson.get("account_id").asText();
		//获取属性定义，保存到map中
		Map<String,String> targetNameMap = new HashMap<>();
		JsonNode acctAttrDef = acctJson.get("acct_attr_def");
		Iterator<JsonNode> iterator = acctAttrDef.getElements();
		while(iterator.hasNext()){
			JsonNode tempNode = iterator.next();
			String targetName = tempNode.get("target_name").getTextValue();
			targetNameMap.put(tempNode.get("show_name").getTextValue(),targetName);
		}
		String accountIdCol = targetNameMap.get(accountIdShowName);
		
		attributesMap.put(pwdCol, acctPwd);
		attributesMap.put(accountIdCol,acctId);
		
		IConnector connector = connectorService.getConnectorByResUuid(resUuid);
		boolean flag = false;
		if(acctPwd.equals(acctPwd2)){
			String accountTgtUuid = connector.createAccount(attributesMap);
			if(accountTgtUuid != null){
				String accountUuid = CommonUtil.generateUUID();
				
				//插入到 account
				Account account = new Account();
				account.setAcctUuid(accountUuid);
				account.setAcctLoginId(acctId);
				account.setAcctTgtUuid(accountTgtUuid);
				account.setAcctResUuid(resUuid);
				account.setAcctPrimary(1);
				account.setAcctStatus(1);
				if(accountMapper.insert(account) > 0){
					flag = true;
				}else{
					flag = false;
					throw new Exception("在身份管理系统中创建账号失败");
				}
				
				//插入到 account_attribute
				for(Entry<String,String> entry : attributesMap.entrySet()){
					AccountAttribute accountAttribute = new AccountAttribute();
					accountAttribute.setAcctAttrAcctUuid(accountUuid);
					accountAttribute.setAcctAttrKey(entry.getKey());
					accountAttribute.setAcctAttrVal(entry.getValue());
					if(accountAttributeMapper.insert(accountAttribute) > 0){
						flag = true;
					}else{
						flag = false;
						throw new Exception("在身份管理系统中创建账号详情时失败");
					}
				}
				
				//插入到 entitlement
				Entitlement entitlement = new Entitlement();
				entitlement.setEtmUserUuid(userUuid);
				entitlement.setEtmAcctUuid(accountTgtUuid);
				entitlement.setEtmStatus(1);
				if(entitlementMapper.insert(entitlement) > 0){
					flag = true;
				}else{
					flag = false;
					throw new Exception("在身份管理系统中授权时失败");
				}
				
				if(flag){
					return true;
				}
			}else{
				throw new Exception("第三方资源创建账号失败");
			}
		}else{
			throw new Exception("两次输入密码不一致");
		}
		
		return false;
	}

	@Override
	public int deleteAccount(String userUuid) throws Exception{
		return accountMapper.deleteByPrimaryKey(userUuid);
	}
}
