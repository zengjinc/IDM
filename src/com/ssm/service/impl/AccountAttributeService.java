package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.mapper.AccountAttributeMapper;
import com.ssm.mapper.AccountMapper;
import com.ssm.pojo.Account;
import com.ssm.pojo.AccountAttribute;
import com.ssm.pojo.AccountAttributeExample;
import com.ssm.pojo.AccountExample;
import com.ssm.service.IAccountAttributeService;
@Service
public class AccountAttributeService implements IAccountAttributeService {

	@Autowired
	private AccountAttributeMapper acctAttrMapper;
	
	@Autowired
	private AccountMapper acctMapper;
	
	@Override
	public List<AccountAttribute> getAcctAttrByAcctUuid(String acctUuid){
		AccountExample example1 = new AccountExample();
		example1.createCriteria().andAcctTgtUuidEqualTo(acctUuid);
		Account account = acctMapper.selectByExample(example1).get(0);
		AccountAttributeExample example = new AccountAttributeExample();
		example.createCriteria().andAcctAttrAcctUuidEqualTo(account.getAcctUuid());
		return acctAttrMapper.selectByExample(example);
	}
}
