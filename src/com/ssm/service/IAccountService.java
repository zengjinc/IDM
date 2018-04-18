package com.ssm.service;

import java.util.List;
import java.util.Map;

import com.ssm.pojo.Account;

public interface IAccountService {

	List<Account> getAccountsByResUuid(String resUuid) throws Exception;
	
	boolean createAccount(Map<String,String> basicAttributesMap, Map<String,String> attributesMap) throws Exception;

	Account getAccountByAcctTgtUuid(String acctTgtUuid) throws Exception;

	Account getAccountByAcctUuid(String userUuid) throws Exception;

	int updateAccountByPrimaryKey(Account account) throws Exception;

	int deleteAccount(String userUuid) throws Exception;

}
