package com.ssm.service;

import java.util.List;

import com.ssm.pojo.AccountAttribute;

public interface IAccountAttributeService {

	List<AccountAttribute> getAcctAttrByAcctUuid(String acctUuid) throws Exception;

}
