package com.ssm.service;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.ssm.pojo.Account;
import com.ssm.pojo.Itrole;
import com.ssm.pojo.to.PrivilegeTo;

public interface IPrivilegeService {
	
	int entitlement(String acctUuid, String itroleUuid, String resUuid) throws Exception;
	
	int revokeEntitlement(String acctUuid, String itroleUuid, String resUuid) throws Exception;
	
	List<PrivilegeTo> getPrivilegeByUserUuid(String userUuid, PageBounds pageBounds) throws Exception;

	void revokeAccountPrivilege(Account account) throws Exception;

	List<Itrole> getPrivilegeByAcctUuid(String acctUuid) throws Exception;
}
