package com.ssm.service.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.ssm.connector.IConnector;
import com.ssm.connector.IConnector.IPassword;
import com.ssm.mapper.EntitlementMapper;
import com.ssm.pojo.Account;
import com.ssm.pojo.Entitlement;
import com.ssm.pojo.EntitlementExample;
import com.ssm.pojo.EntitlementKey;
import com.ssm.pojo.Resource;
import com.ssm.pojo.User;
import com.ssm.pojo.to.EntitlementTo;
import com.ssm.service.IAccountAttributeService;
import com.ssm.service.IAccountService;
import com.ssm.service.IConnectorService;
import com.ssm.service.IEntitlementService;
import com.ssm.service.IJavaMailSenderService;
import com.ssm.service.IResourceService;
import com.ssm.service.IUserService;
import com.ssm.utils.CommonUtil;

@Service
public class EntitlementService implements IEntitlementService {
	
	@Autowired
	private EntitlementMapper entitlementMapper;
	
	@Autowired
	private IResourceService resourceService;
	
	@Autowired
	private IAccountAttributeService acctAttrService;
	
	@Autowired
	private IAccountService acctService;
	
	@Autowired
	private IConnectorService connectorService;
	
	@Autowired
	private IJavaMailSenderService mailSenderService;
	
	@Autowired
	private IUserService userService;
	
	/*
	 * 授权，到目标资源更改新密码（默认密码），新增entitlement表记录，并发送给用户
	 */
	@Override
	public int entitlement(String userUuid, String acctTgtUuid,String resUuid) throws Exception{
		int insertSelective = 0;
		String randomPwd = CommonUtil.getRandomString(12);
		if(resetPassword(acctTgtUuid, randomPwd, resUuid)){
			Entitlement record = new Entitlement();
			record.setEtmUserUuid(userUuid);
			record.setEtmAcctUuid(acctTgtUuid);
			record.setEtmStatus(1);
			insertSelective  = entitlementMapper.insertSelective(record);
		}
		
		if(insertSelective > 0){	//发送邮件
			User user = userService.getUserByPrimaryKey(userUuid);
			Resource resource = resourceService.getResourceByPrimarKey(resUuid);
			Account account = acctService.getAccountByAcctTgtUuid(acctTgtUuid);
			mailSenderService.entitlementFinishEmail(user.getUserEmail(), user.getUserName(), resource.getResName(), account.getAcctLoginId(), randomPwd);
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
	
	@Override
	public List<Account> getUserAccounts(String userUuid) throws Exception{
		EntitlementExample example = new EntitlementExample();
		example.createCriteria().andEtmUserUuidEqualTo(userUuid);
		List<Entitlement> userEntitlementList = entitlementMapper.selectByExample(example);
		
		List<Account> userAccounts = new ArrayList<>();
		for(Entitlement e : userEntitlementList){
			userAccounts.add(acctService.getAccountByAcctTgtUuid(e.getEtmAcctUuid()));
		}
		
		return userAccounts;
	}
	

	/*
	 * 禁用授权，到目标资源中修改账号的状态，将 entitlement 表中的状态改为 0。
	 */
	@Override
	public int disableEntitlement(String userUuid, String acctTgtUuid,String resUuid) throws Exception {	
		IConnector connector = connectorService.getConnectorByResUuid(resUuid);
		int updateNum = 0;
		if(connector.disableAccount(acctTgtUuid)){
			EntitlementKey key = new EntitlementKey();
			key.setEtmUserUuid(userUuid);
			key.setEtmAcctUuid(acctTgtUuid);
			Entitlement entitlement = entitlementMapper.selectByPrimaryKey(key);
			if(entitlement.getEtmStatus() != 0){
				entitlement.setEtmStatus(0);
				updateNum = entitlementMapper.updateByPrimaryKey(entitlement);
			}else{
				updateNum = 1;
			}
		}
		
		if(updateNum > 0){
			User user = userService.getUserByPrimaryKey(userUuid);
			Resource resource = resourceService.getResourceByPrimarKey(resUuid);
			Account account = acctService.getAccountByAcctTgtUuid(acctTgtUuid);
			mailSenderService.entitlementDisableEmail(user.getUserEmail(), user.getUserName(), resource.getResName(), account.getAcctLoginId());
		}
		
		return updateNum;
	}

	/*
	 * 激活授权，到目标资源中修改账号的状态，将 entitlement 表中的状态改为 1。
	 */
	@Override
	public int enableEntitlement(String userUuid, String acctTgtUuid, String resUuid) throws Exception {
		IConnector connector = connectorService.getConnectorByResUuid(resUuid);
		int updateNum = 0;
		if(connector.enableAccount(acctTgtUuid)){
			EntitlementKey key = new EntitlementKey();
			key.setEtmUserUuid(userUuid);
			key.setEtmAcctUuid(acctTgtUuid);
			Entitlement entitlement = entitlementMapper.selectByPrimaryKey(key);
			if(entitlement.getEtmStatus() != 1){
				entitlement.setEtmStatus(1);
				updateNum = entitlementMapper.updateByPrimaryKey(entitlement);
			}else{
				updateNum = 1;
			}
		}
		
		if(updateNum > 0){
			User user = userService.getUserByPrimaryKey(userUuid);
			Resource resource = resourceService.getResourceByPrimarKey(resUuid);
			Account account = acctService.getAccountByAcctTgtUuid(acctTgtUuid);
			mailSenderService.entitlementEnableEmail(user.getUserEmail(), user.getUserName(), resource.getResName(), account.getAcctLoginId());
		}
		
		return updateNum;
	}
	
	/*
	 * 删除授权，到目标资源中更改账号密码(随机密码)，删除授权表中的记录
	 */
	@Override
	public int deleteEntitlement(String userUuid, String acctTgtUuid, String resUuid) throws Exception{
		int deleteNum = 0;
		if(resetPassword(acctTgtUuid, CommonUtil.getRandomString(12), resUuid)){
			EntitlementKey key = new EntitlementKey();
			key.setEtmAcctUuid(acctTgtUuid);
			key.setEtmUserUuid(userUuid);
			deleteNum = entitlementMapper.deleteByPrimaryKey(key);
		}
		
		if(deleteNum > 0){
			User user = userService.getUserByPrimaryKey(userUuid);
			Resource resource = resourceService.getResourceByPrimarKey(resUuid);
			Account account = acctService.getAccountByAcctTgtUuid(acctTgtUuid);
			mailSenderService.entitlementCancelEmail(user.getUserEmail(), user.getUserName(), resource.getResName(), account.getAcctLoginId());
		}
		
		return deleteNum;
	}
	
	@Override
	public boolean updataAccountAttribute(String acctTgtUuid,Map<String,String> attributesMap,String resUuid) throws Exception{
		IConnector connector = connectorService.getConnectorByResUuid(resUuid);
		
		if(connector.updateAccount(acctTgtUuid, attributesMap) > 0){
			//更新本地账号表中的属性
			acctAttrService.updataAccountAttribute(resUuid,acctTgtUuid, attributesMap);
			return true;
		}
		
		return false;
	}
	

	@Override
	public boolean verifyPassword(String acctTgtUuid, String password, String resUuid) throws Exception {
		IConnector connector = connectorService.getConnectorByResUuid(resUuid);
		return ((IPassword)connector).verifyPassword(acctTgtUuid, new StringBuilder(password));
	}

	@Override
	public boolean resetPassword(String acctTgtUuid, String password, String resUuid) throws Exception {
		IConnector connector = connectorService.getConnectorByResUuid(resUuid);
		boolean flag = ((IPassword)connector).resetPassword(acctTgtUuid, new StringBuilder(password));
		return flag;
	}
	
//	public IConnector getConnectorByResUuid(String resUuid) throws Exception{
//		Resource resource = resourceService.getResourceByPrimarKey(resUuid);
//		IConnector connector = (IConnector)BeanUtil.getBean("jdbcConnector");
//		connector.setResource(resource);
//		return connector;
//	}
	
	@Override
	public void assignAccountOwner(String resId,Map<String,String> assignRule) throws Exception{
		/*
		 * 获取对应资源的所有账号
		 */
		Resource resource = resourceService.getResourceByResId(resId);
		String resUuid = resource.getResUuid();
		List<Account> accountList = acctService.getAccountsByResUuid(resUuid);
		
		/*
		 * 获取所有用户
		 */
		List<User> userList = userService.getUserByExample(null);
		
		
		/*
		 * 如果符合条件，分配账号
		 */
		Map<Account,List<String>> acctMap = new HashMap<>();
		for (Account acct : accountList) {
			
			List<String> acctFieldValList = new ArrayList<>();
			
			for (String key : assignRule.keySet()) {

				Field field = acct.getClass().getDeclaredField(key);
				field.setAccessible(true);
				String acctFieldVal = (String) field.get(acct);
				
				acctFieldValList.add(acctFieldVal);
			}
			
			acctMap.put(acct, acctFieldValList);

		}
		
		Map<User,List<String>> userMap = new HashMap<>();
		for (User user : userList) {
			
			List<String> userFieldValList = new ArrayList<>();
			
			for (String key : assignRule.keySet()) {

				Field field = user.getClass().getDeclaredField(assignRule.get(key));
				field.setAccessible(true);
				String userFieldVal = (String) field.get(user);
				
				userFieldValList.add(userFieldVal);
			}
			
			userMap.put(user, userFieldValList);

		}
		
		for(Account acct : acctMap.keySet()){
			
			List<String> acctFieldVal = acctMap.get(acct);	//账户的属性列表
			
			for(User user : userMap.keySet()){
				
				boolean assignFlag = false;
				
				List<String> userFieldValList = userMap.get(user);	//用户对应的属性列表
				
				for(int i = 0; i < acctFieldVal.size(); i++){
					
					if(acctFieldVal.get(i).equals(userFieldValList.get(i))){
						
						assignFlag = true;
					}else{
						
						assignFlag = false;
						break;
					}
					
				}
				
				if(assignFlag){	//分配账户
					entitlement(user.getUserUuid(), acct.getAcctTgtUuid(), resUuid);
				}
			}
			
		}
	}
	
}
