package com.ssm.service;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.ssm.pojo.to.EntitlementTo;

public interface IEntitlementService {

	int entitlement(String userUuid, String acctUuid,String resUuid) throws Exception;

	List<EntitlementTo> getUserEntitlement(String userUuid, PageBounds pageBounds) throws Exception;

	int disableEntitlement(String userUuid, String acctUuid,String resUuid) throws Exception;
	
	int enableEntitlement(String userUuid, String acctUuid,String resUuid) throws Exception;

	int deleteEntitlement(String userUuid, String acctUuid, String resUuid) throws Exception;
	
	boolean verifyPassword(String acctUuid,String password, String resUuid) throws Exception;
	
	boolean resetPassword(String acctUuid,String password, String resUuid) throws Exception;

}
