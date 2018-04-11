package com.ssm.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.mapper.AccountAttributeMapper;
import com.ssm.mapper.AccountMapper;
import com.ssm.mapper.EntitlementMapper;
import com.ssm.pojo.Account;
import com.ssm.pojo.AccountExample;
import com.ssm.pojo.Entitlement;
import com.ssm.service.IAccountService;
@Service
public class AccountService implements IAccountService{

	private static Logger logger = LoggerFactory.getLogger(AccountService.class);
	
	@Autowired
	private AccountMapper accountMapper;
	
	@Autowired
	private EntitlementMapper entitlementMapper;
	
	@Autowired
	private AccountAttributeMapper accountAttributeMapper;
	
	@Override
	public List<Account> getAccountsByResUuid(String resUuid){
		AccountExample example = new AccountExample();
		example.createCriteria().andAcctResUuidEqualTo(resUuid);
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
}
