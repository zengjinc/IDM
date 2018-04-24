package com.ssm.service;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.ssm.pojo.BusinessRole;
import com.ssm.pojo.BusinessRoleExample;

public interface IBusinessRoleService {

	int addBizRole(BusinessRole bizRole) throws Exception;

	List<BusinessRole> getAllBizRole(PageBounds pageBounds) throws Exception;

	BusinessRole getBizRole(String bizRoleUuid) throws Exception;

	int updateBizeRole(BusinessRole bizRole) throws Exception;

	int deleteBizRole(String bizRoleUuid) throws Exception;

	List<BusinessRole> getBizRoleByExample(BusinessRoleExample example, PageBounds pageBounds) throws Exception;

	List<BusinessRole> listAllBizRole() throws Exception;

}
