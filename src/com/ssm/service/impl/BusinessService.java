package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.ssm.mapper.BusinessRoleMapper;
import com.ssm.pojo.BusinessRole;
import com.ssm.pojo.BusinessRoleExample;
import com.ssm.service.IBusinessRoleService;
@Service
public class BusinessService implements IBusinessRoleService {

	@Autowired
	private BusinessRoleMapper bizRoleMapper;
	
	@Override
	public int addBizRole(BusinessRole bizRole) throws Exception{
		int insert = 0;
		try{
			insert = bizRoleMapper.insert(bizRole);
		}catch(Exception e){
			throw e;
		}
		return insert;
	}
	
	@Override
	public List<BusinessRole> getAllBizRole(PageBounds pageBounds) throws Exception{
		BusinessRoleExample example = new BusinessRoleExample();
		example.setOrderByClause("biz_role_id");
		return bizRoleMapper.selectByExample(example , pageBounds);
	}
	
	@Override
	public List<BusinessRole> listAllBizRole() throws Exception{
		return bizRoleMapper.selectByExample(null);
	}
	
	@Override
	public BusinessRole getBizRole(String bizRoleUuid) throws Exception{
		return bizRoleMapper.selectByPrimaryKey(bizRoleUuid);
	}
	
	@Override
	public List<BusinessRole> getBizRoleByExample(BusinessRoleExample example,PageBounds pageBounds) throws Exception{
		return bizRoleMapper.selectByExample(example, pageBounds);
	}
	
	@Override
	public int updateBizeRole(BusinessRole bizRole) throws Exception{
		return bizRoleMapper.updateByPrimaryKey(bizRole);
	}
	
	@Override
	public int deleteBizRole(String bizRoleUuid) throws Exception{
		return bizRoleMapper.deleteByPrimaryKey(bizRoleUuid);
	}
	
}
