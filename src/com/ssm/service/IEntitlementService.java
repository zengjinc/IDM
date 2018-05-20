package com.ssm.service;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.ssm.pojo.Account;
import com.ssm.pojo.User;
import com.ssm.pojo.to.EntitlementTo;

public interface IEntitlementService {

	int entitlement(String userUuid, String acctTgtUuid,String resUuid) throws Exception;

	List<EntitlementTo> getUserEntitlement(String userUuid, PageBounds pageBounds) throws Exception;

	int disableEntitlement(String userUuid, String acctTgtUuid,String resUuid) throws Exception;
	
	int enableEntitlement(String userUuid, String acctTgtUuid,String resUuid) throws Exception;

	int deleteEntitlement(String userUuid, String acctTgtUuid, String resUuid) throws Exception;
	
	boolean verifyPassword(String acctTgtUuid,String password, String resUuid) throws Exception;
	
	boolean resetPassword(String acctTgtUuid,String password, String resUuid) throws Exception;

	public boolean updataAccountAttribute(String acctTgtUuid,Map<String,String> attributesMap,String resUuid) throws Exception;

	List<Account> getUserAccounts(String userUuid) throws Exception;

	void assignAccountOwner(String resId,Map<String, String> assignRule) throws Exception;

	int entitlementByPolicy(String userUuid, String acctTgtUuid, String resUuid, String policyUuid) throws Exception;

	void revokePolicyEntitlement(User user) throws Exception;

	boolean deleEntitlementByAccountTgtUuid(String acctTgtUuid) throws Exception;
}
