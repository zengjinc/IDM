package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.ssm.mapper.PolicyMapper;
import com.ssm.pojo.Policy;
import com.ssm.pojo.PolicyExample;
import com.ssm.service.IPolicyService;

@Service
public class PolicyService implements IPolicyService {

	@Autowired
	private PolicyMapper policyMapper;
	
	
	@Override
	public int savePolicy(Policy policy) throws Exception{
		return policyMapper.insert(policy);
	}
	
	@Override
	public List<Policy> getEntitlementPolicy(PageBounds pageBounds) throws Exception{
		PolicyExample example = new PolicyExample();
		example.createCriteria().andPolTypeEqualTo("entitlement policy");
		example.setOrderByClause("pol_id");
		return policyMapper.selectByExample(example , pageBounds);
	}
	
	@Override
	public List<Policy> getRoleConflictPolicy(PageBounds pageBounds) throws Exception{
		PolicyExample example = new PolicyExample();
		example.createCriteria().andPolTypeEqualTo("role conflict policy");
		example.setOrderByClause("pol_id");
		return policyMapper.selectByExample(example , pageBounds);
	}
	
	@Override
	public List<Policy> getPolicyByExample(PageBounds pageBounds,PolicyExample example) throws Exception {
		return policyMapper.selectByExample(example, pageBounds);
	}
	
	@Override
	public Policy getPolicyByUuid(String polUuid) throws Exception{
		return policyMapper.selectByPrimaryKey(polUuid);
	}
	
	@Override
	public int updatePolicy(Policy policy) throws Exception{
		return policyMapper.updateByPrimaryKeyWithBLOBs(policy);
	}
	
	@Override
	public int deletePolicy(String policyUuid) throws Exception{
		return policyMapper.deleteByPrimaryKey(policyUuid);
	}
}
