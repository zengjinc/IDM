package com.ssm.service;

import java.util.List;

import com.ssm.pojo.Account;

public interface IAccountService {

	List<Account> getAccountsByResUuid(String resUuid) throws Exception;

}
