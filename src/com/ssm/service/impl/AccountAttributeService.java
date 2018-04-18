package com.ssm.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssm.mapper.AccountAttributeMapper;
import com.ssm.mapper.AccountMapper;
import com.ssm.mapper.ResourceMapper;
import com.ssm.pojo.Account;
import com.ssm.pojo.AccountAttribute;
import com.ssm.pojo.AccountAttributeExample;
import com.ssm.pojo.AccountExample;
import com.ssm.pojo.Resource;
import com.ssm.service.IAccountAttributeService;
@Service
public class AccountAttributeService implements IAccountAttributeService {

	@Autowired
	private AccountAttributeMapper acctAttrMapper;
	
	@Autowired
	private AccountMapper acctMapper;
	
	@Autowired ResourceMapper resourceMapper;
	
	@Override
	public List<AccountAttribute> getAcctAttrByAcctUuid(String acctUuid){
		AccountExample example1 = new AccountExample();
		example1.createCriteria().andAcctTgtUuidEqualTo(acctUuid);
		Account account = acctMapper.selectByExample(example1).get(0);
		AccountAttributeExample example = new AccountAttributeExample();
		example.createCriteria().andAcctAttrAcctUuidEqualTo(account.getAcctUuid());
		return acctAttrMapper.selectByExample(example);
	}

	@Override
	public boolean updataAccountAttribute(String resUuid,String acctUuid, Map<String, String> attributesMap) throws Exception {
		//获取账号在数据库中对应的uuid
		AccountExample example1 = new AccountExample();
		example1.createCriteria().andAcctTgtUuidEqualTo(acctUuid).andAcctResUuidEqualTo(resUuid);
		Account account = acctMapper.selectByExample(example1).get(0);
		String accountUuid = account.getAcctUuid();
		
		//获取属性定义，保存到map中
		Resource resource = resourceMapper.selectByPrimaryKey(resUuid);
		JsonNode rootNode = new ObjectMapper().readTree(resource.getResJsonAttr());
		JsonNode acctJson = rootNode.get("acctJson");
		String acctId = acctJson.get("account_id").asText();	//account 表中的 acct_login_id
		Map<String,String> targetNameMap = new HashMap<>();
		JsonNode acctAttrDef = acctJson.get("acct_attr_def");
		Iterator<JsonNode> iterator = acctAttrDef.elements();
		while(iterator.hasNext()){
			JsonNode tempNode = iterator.next();
			String targetName = tempNode.get("target_name").asText();
			targetNameMap.put(tempNode.get("show_name").asText(),targetName);
		}
		
		AccountAttributeExample example = new AccountAttributeExample();
		example.createCriteria().andAcctAttrAcctUuidEqualTo(accountUuid);
		List<AccountAttribute> records = acctAttrMapper.selectByExample(example);
		for(AccountAttribute record : records){
			String acctAttrKey = record.getAcctAttrKey();
			if(attributesMap.containsKey(acctAttrKey)){
				if(acctAttrKey.equals(targetNameMap.get(acctId))){
					account.setAcctLoginId(attributesMap.get(acctAttrKey));
					acctMapper.updateByPrimaryKey(account);
				}
				record.setAcctAttrVal(attributesMap.get(acctAttrKey));
				acctAttrMapper.updateByPrimaryKey(record);
			}
		}
		return false;
	}
}
