package com.ssm.service;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.ssm.pojo.Policy;
import com.ssm.pojo.PolicyExample;
import com.ssm.pojo.User;

public interface IPolicyService {

	int savePolicy(Policy policy) throws Exception;

	List<Policy> getEntitlementPolicy(PageBounds pageBounds) throws Exception;

	List<Policy> getPolicyByExample(PageBounds pageBounds, PolicyExample example) throws Exception;

	Policy getPolicyByUuid(String polUuid) throws Exception;

	int updatePolicy(Policy policy) throws Exception;

	int deletePolicy(String policyUuid) throws Exception;

	List<Policy> getRoleConflictPolicy(PageBounds pageBounds) throws Exception;

	void entitlementPolicy(User user) throws Exception;

	boolean roleConflictPolicy(String acctUuid, String itroleUuid) throws Exception;

	boolean deletePolicyByResource(String resUuid) throws Exception;

}
