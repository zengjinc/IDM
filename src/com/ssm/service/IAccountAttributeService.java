package com.ssm.service;

import java.util.List;
import java.util.Map;

import com.ssm.pojo.AccountAttribute;

public interface IAccountAttributeService {

	List<AccountAttribute> getAcctAttrByAcctUuid(String acctUuid) throws Exception;

	boolean updataAccountAttribute(String resUuid,String acctUuid,Map<String,String> attributesMap) throws Exception;
}
