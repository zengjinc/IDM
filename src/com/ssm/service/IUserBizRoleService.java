package com.ssm.service;

import java.util.List;

import com.ssm.pojo.BusinessRole;

public interface IUserBizRoleService {

	boolean updateUserBizRole(String userUuid, List<String> bizRoleList) throws Exception;

	List<BusinessRole> getUserBizRole(String userUuid) throws Exception;

	boolean deleteByBizrole(String bizRoleUuid) throws Exception;

}
