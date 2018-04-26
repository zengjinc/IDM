package com.ssm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.mapper.RelUserBizroleMapper;
import com.ssm.pojo.BusinessRole;
import com.ssm.pojo.RelUserBizrole;
import com.ssm.pojo.RelUserBizroleExample;
import com.ssm.pojo.User;
import com.ssm.service.IBusinessRoleService;
import com.ssm.service.IPolicyService;
import com.ssm.service.IUserBizRoleService;
import com.ssm.service.IUserService;
@Service
public class UserBizRoleService implements IUserBizRoleService {
	
	@Autowired
	private RelUserBizroleMapper userBizRoleMapper;
	
	@Autowired
	private IBusinessRoleService bizRoleService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IPolicyService policyService;
	
	/*
	 * 分配岗位给用户，先删除全部岗位，再重新分配全部
	 */
	@Override
	public boolean updateUserBizRole(String userUuid, List<String> bizRoleList){
		try{
			RelUserBizroleExample example = new RelUserBizroleExample();
			example.createCriteria().andRelUserBizroleUserUuidEqualTo(userUuid);
			userBizRoleMapper.deleteByExample(example);
			
			for(String bizRoleUuid : bizRoleList){
				RelUserBizrole relUserBizrole = new RelUserBizrole();
				relUserBizrole.setRelUserBizroleUserUuid(userUuid);
				relUserBizrole.setRelUserBizroleBizroleUuid(bizRoleUuid);
				userBizRoleMapper.insert(relUserBizrole);
			}
			
			User user = userService.getUserByPrimaryKey(userUuid);
			try {
				policyService.entitlementPolicy(user);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public List<BusinessRole> getUserBizRole(String userUuid) throws Exception{
		RelUserBizroleExample example = new RelUserBizroleExample();
		example.createCriteria().andRelUserBizroleUserUuidEqualTo(userUuid);
		List<RelUserBizrole> userBizRoleList = userBizRoleMapper.selectByExample(example);
		
		List<BusinessRole> bizRoleList = new ArrayList<>();
		for(RelUserBizrole userBizRole : userBizRoleList){
			String bizRoleUuid = userBizRole.getRelUserBizroleBizroleUuid();
			bizRoleList.add(bizRoleService.getBizRole(bizRoleUuid));
		}
		
		return bizRoleList;
	}
	
}
