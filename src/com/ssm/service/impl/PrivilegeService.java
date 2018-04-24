package com.ssm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.ssm.connector.IConnector;
import com.ssm.connector.IConnector.IRole;
import com.ssm.mapper.AccountMapper;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ssm.mapper.EntitlementMapper;
import com.ssm.mapper.ItroleMapper;
import com.ssm.mapper.PrivilegeMapper;
import com.ssm.mapper.ResourceMapper;
import com.ssm.pojo.Account;
import com.ssm.pojo.AccountExample;
import com.ssm.pojo.Entitlement;
import com.ssm.pojo.EntitlementExample;
import com.ssm.pojo.Itrole;
import com.ssm.pojo.Privilege;
import com.ssm.pojo.PrivilegeExample;
import com.ssm.pojo.Resource;
import com.ssm.pojo.to.PrivilegeTo;
import com.ssm.service.IConnectorService;
import com.ssm.service.IPrivilegeService;
import com.ssm.utils.CommonUtil;
@Service
public class PrivilegeService implements IPrivilegeService {

	@Autowired
	private IConnectorService connectorService;
	
	@Autowired
	private PrivilegeMapper privilegeMapper;
	
	@Autowired
	private ItroleMapper itroleMapper;
	
	@Autowired
	private EntitlementMapper entitlementMapper;
	
	@Autowired
	private ResourceMapper resourceMapper;
	
	@Autowired
	private AccountMapper acctMapper;
	
	/*
	 * 授权，添加条目到第三方资源，并且在 privilege表中增加条目
	 */
	@Override
	public int entitlement(String acctUuid, String itroleUuid, String resUuid) throws Exception {
		IConnector connector = connectorService.getConnectorByResUuid(resUuid);
		
		Itrole itrole = itroleMapper.selectByPrimaryKey(itroleUuid);
		String itroleTgtUuid = itrole.getItroleTgtRoleUuid();
		
		Account account = acctMapper.selectByPrimaryKey(acctUuid);
		String accountTgtUuid = account.getAcctTgtUuid();
		
		if(((IRole)connector).assignRoles(accountTgtUuid, itroleTgtUuid)){
			Privilege privilege = new Privilege();
			privilege.setPvgAcctUuid(acctUuid);
			privilege.setPvgItroleUuid(itroleUuid);
			privilege.setPvgUuid(CommonUtil.generateUUID());
			return privilegeMapper.insert(privilege);
		}else{
			throw new Exception("第三方系统分配权限失败");
		}
	}

	@Override
	public PageList<PrivilegeTo> getPrivilegeByUserUuid(String userUuid, PageBounds pageBounds) throws Exception {
		EntitlementExample example = new EntitlementExample();
		example.createCriteria().andEtmUserUuidEqualTo(userUuid);
		List<Entitlement> entitlements = entitlementMapper.selectByExample(example,pageBounds);
		PageList pageList = (PageList)entitlements;
		PageList<PrivilegeTo> result = new PageList<>(pageList.getPaginator());
		for(Entitlement e : entitlements){
			PrivilegeTo privilegeTo = new PrivilegeTo();
			
			String acctTgtUuid = e.getEtmAcctUuid();
			
			AccountExample example2 = new AccountExample();
			example2.createCriteria().andAcctTgtUuidEqualTo(acctTgtUuid);
			Account account = acctMapper.selectByExample(example2).get(0);
			Resource resource = resourceMapper.selectByPrimaryKey(account.getAcctResUuid());
			privilegeTo.setAccount(account);
			privilegeTo.setResource(resource);
			
			result.add(privilegeTo);
		}
		return result;
	}

	/*
	 * 取消授权，删除第三方资源授权，并且在 privilege删去该条目
	 */
	@Override
	public int revokeEntitlement(String acctUuid, String itroleUuid, String resUuid) throws Exception {
IConnector connector = connectorService.getConnectorByResUuid(resUuid);
		
		Itrole itrole = itroleMapper.selectByPrimaryKey(itroleUuid);
		String itroleTgtUuid = itrole.getItroleTgtRoleUuid();
		
		Account account = acctMapper.selectByPrimaryKey(acctUuid);
		String accountTgtUuid = account.getAcctTgtUuid();
		
		if(((IRole)connector).unassignRoles(accountTgtUuid, itroleTgtUuid)){
			PrivilegeExample example = new PrivilegeExample();
			example.createCriteria().andPvgAcctUuidEqualTo(acctUuid).andPvgItroleUuidEqualTo(itroleUuid);
			return privilegeMapper.deleteByExample(example);
		}else{
			throw new Exception("第三方系统取消分配权限失败");
		}
	}

	
	
}
