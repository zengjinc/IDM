package com.ssm.service.impl;

import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.ssm.connector.IConnector;
import com.ssm.connector.IConnector.IPassword;
import com.ssm.mapper.EntitlementMapper;
import com.ssm.pojo.Entitlement;
import com.ssm.pojo.EntitlementKey;
import com.ssm.pojo.Resource;
import com.ssm.pojo.to.EntitlementTo;
import com.ssm.service.IEntitlementService;
import com.ssm.service.IResourceService;
import com.ssm.utils.BeanUtil;
import com.ssm.utils.CommonUtil;

@Service
public class EntitlementService implements IEntitlementService {
	
	@Autowired
	private EntitlementMapper entitlementMapper;
	
	@Autowired
	private IResourceService resourceService;
	
	
	/*
	 * 授权，到目标资源更改新密码（默认密码），新增entitlement表记录，并发送给用户
	 */
	@Override
	public int entitlement(String userUuid, String acctUuid,String resUuid) throws Exception{
//		Resource resource = resourceService.getResourceByPrimarKey(resUuid);
//		IConnector connector = (IConnector)BeanUtil.getBean("jdbcConnector");
//		connector.setResource(resource);
		int insertSelective = 0;
		if(resetPassword(acctUuid, "password", resUuid)){
			Entitlement record = new Entitlement();
			record.setEtmUserUuid(userUuid);
			record.setEtmAcctUuid(acctUuid);
			record.setEtmStatus(1);
			insertSelective  = entitlementMapper.insertSelective(record);
		}
		
		return insertSelective;
	}
	
	@Override
	public List<EntitlementTo> getUserEntitlement(String userUuid, PageBounds pageBounds){
		List<EntitlementTo> entitlementList = entitlementMapper.getEntitlementByUserUuid(userUuid,pageBounds);
		ListIterator<EntitlementTo> it = entitlementList.listIterator();
		while(it.hasNext()){
			EntitlementTo e = it.next();
			EntitlementKey key = new EntitlementKey();
			key.setEtmAcctUuid(e.getAcctTgtUuid());
			key.setEtmUserUuid(userUuid);
			Entitlement record = entitlementMapper.selectByPrimaryKey(key);
			e.setAcctStatus(record.getEtmStatus());
			it.set(e);
		}
		return entitlementList;
	}
	

	/*
	 * 禁用授权，到目标资源中修改账号的状态，将 entitlement 表中的状态改为 0。
	 */
	@Override
	public int disableEntitlement(String userUuid, String acctUuid,String resUuid) throws Exception {	
		
		Resource resource = resourceService.getResourceByPrimarKey(resUuid);
		IConnector connector = (IConnector)BeanUtil.getBean("jdbcConnector");
		connector.setResource(resource);
		int updateNum = 0;
		if(connector.disableAccount(acctUuid)){
			EntitlementKey key = new EntitlementKey();
			key.setEtmUserUuid(userUuid);
			key.setEtmAcctUuid(acctUuid);
			Entitlement entitlement = entitlementMapper.selectByPrimaryKey(key);
			if(entitlement.getEtmStatus() != 0){
				entitlement.setEtmStatus(0);
				updateNum = entitlementMapper.updateByPrimaryKey(entitlement);
			}else{
				updateNum = 1;
			}
		}
		
		return updateNum;
	}

	/*
	 * 激活授权，到目标资源中修改账号的状态，将 entitlement 表中的状态改为 1。
	 */
	@Override
	public int enableEntitlement(String userUuid, String acctUuid, String resUuid) throws Exception {
		Resource resource = resourceService.getResourceByPrimarKey(resUuid);
		IConnector connector = (IConnector)BeanUtil.getBean("jdbcConnector");
		connector.setResource(resource);
		int updateNum = 0;
		if(connector.enableAccount(acctUuid)){
			EntitlementKey key = new EntitlementKey();
			key.setEtmUserUuid(userUuid);
			key.setEtmAcctUuid(acctUuid);
			Entitlement entitlement = entitlementMapper.selectByPrimaryKey(key);
			if(entitlement.getEtmStatus() != 1){
				entitlement.setEtmStatus(1);
				updateNum = entitlementMapper.updateByPrimaryKey(entitlement);
			}else{
				updateNum = 1;
			}
		}
		return updateNum;
	}
	
	/*
	 * 删除授权，到目标资源中更改账号密码(随机密码)，删除授权表中的记录
	 */
	@Override
	public int deleteEntitlement(String userUuid, String acctUuid, String resUuid) throws Exception{
//		Resource resource = resourceService.getResourceByPrimarKey(resUuid);
//		IConnector connector = (IConnector)BeanUtil.getBean("jdbcConnector");
//		connector.setResource(resource);
		if(resetPassword(acctUuid, CommonUtil.getRandomString(12), resUuid)){
			EntitlementKey key = new EntitlementKey();
			key.setEtmAcctUuid(acctUuid);
			key.setEtmUserUuid(userUuid);
			return entitlementMapper.deleteByPrimaryKey(key);
		}
		return 0;
	}

	@Override
	public boolean verifyPassword(String acctUuid, String password, String resUuid) throws Exception {
		Resource resource = resourceService.getResourceByPrimarKey(resUuid);
		IConnector connector = (IConnector)BeanUtil.getBean("jdbcConnector");
		connector.setResource(resource);
		return ((IPassword)connector).verifyPassword(acctUuid, new StringBuilder(password));
	}

	@Override
	public boolean resetPassword(String acctUuid, String password, String resUuid) throws Exception {
		Resource resource = resourceService.getResourceByPrimarKey(resUuid);
		IConnector connector = (IConnector)BeanUtil.getBean("jdbcConnector");
		connector.setResource(resource);
		return ((IPassword)connector).resetPassword(acctUuid, new StringBuilder(password));
	}
	
	
}
