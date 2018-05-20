package com.ssm.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.ssm.mapper.ItroleMapper;
import com.ssm.mapper.PolicyMapper;
import com.ssm.pojo.Account;
import com.ssm.pojo.BusinessRole;
import com.ssm.pojo.Itrole;
import com.ssm.pojo.Policy;
import com.ssm.pojo.PolicyExample;
import com.ssm.pojo.Resource;
import com.ssm.pojo.User;
import com.ssm.service.IAccountService;
import com.ssm.service.IEntitlementService;
import com.ssm.service.IItroleService;
import com.ssm.service.IPolicyService;
import com.ssm.service.IPrivilegeService;
import com.ssm.service.IResourceService;
import com.ssm.service.IUserBizRoleService;
import com.ssm.utils.CommonUtil;

@Service
public class PolicyService implements IPolicyService {

	@Autowired
	private PolicyMapper policyMapper;
	
	@Autowired
	private IUserBizRoleService userBizRoleService;
	
	@Autowired
	private IAccountService accountService;
	
	@Autowired
	private IEntitlementService entitlementService;
	
	@Autowired
	private IResourceService resourceService;
	
	@Autowired
	private IPrivilegeService privilegeService;
	
	@Autowired
	private IItroleService itroleService;
	
	@Override
	public int savePolicy(Policy policy) throws Exception{
		return policyMapper.insert(policy);
	}
	
	
	@Override
	public boolean deletePolicyByResource(String resUuid) throws Exception{
		//授权策略，包含该资源就删除
		List<Policy> entitlementPolicyList = getEntitlementPolicy(new PageBounds());
		
		for(Policy policy : entitlementPolicyList){
			
			Iterator<JsonNode> iterator = new ObjectMapper().readTree(policy.getPolJsonStr()).getElements();
			
			while(iterator.hasNext()){
				
				JsonNode node = iterator.next();
				
				String entitlementStr = node.get("entitlement").asText();
				
				String[] entitlementArr = entitlementStr.split(";");
				
				for(String s : entitlementArr){
					
					if(s != null && s.length() > 0){
						
						if(s.indexOf("-->") >= 0){
							
							if(s.split("-->")[0].equals(resUuid)){
								//删除policy
								try {
									deletePolicy(policy.getPolUuid());
								} catch (Exception e) {
									e.printStackTrace();
									return false;
								}
							}
							
						}else{
							
							if(s.equals(resUuid)){
								//删除policy
								try {
									deletePolicy(policy.getPolUuid());
								} catch (Exception e) {
									e.printStackTrace();
									return false;
								}
							}
						}
					}
				}
			}
			
		}
		//角色冲突策略，包含该资源的对象就删除
		List<Policy> roleConflictPolicyList = getRoleConflictPolicy(new PageBounds());
		
		for(Policy policy : roleConflictPolicyList){
			
			Iterator<JsonNode> iterator = new ObjectMapper().readTree(policy.getPolJsonStr()).getElements();
			
			while(iterator.hasNext()){
				
				JsonNode node = iterator.next();
				
				String itrolesStr = node.get("itroles").asText();
				
				String[] itrolesArr = itrolesStr.split(",");
				
				for(String s : itrolesArr){
					
					Itrole itrole = itroleService.getItroleByItroleUuid(s);
					
					if(itrole.getItroleResUuid().equals(resUuid)){
						//删除policy
						try {
							deletePolicy(policy.getPolUuid());
						} catch (Exception e) {
							e.printStackTrace();
							return false;
						}
					}
				}
			}
		}
		
		return true;
	}
	
	@Override
	public List<Policy> getEntitlementPolicy(PageBounds pageBounds) throws Exception{
		PolicyExample example = new PolicyExample();
		example.createCriteria().andPolTypeEqualTo("entitlement policy");
		example.setOrderByClause("pol_id");
		return policyMapper.selectByExampleWithBLOBs(example , pageBounds);
	}
	
	@Override
	public List<Policy> getRoleConflictPolicy(PageBounds pageBounds) throws Exception{
		PolicyExample example = new PolicyExample();
		example.createCriteria().andPolTypeEqualTo("role conflict policy");
		example.setOrderByClause("pol_id");
		return policyMapper.selectByExampleWithBLOBs(example , pageBounds);
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
	
	/*
	 * 角色冲突策略
	 * 失败返回 false，并抛出异常，说明错误原因
	 */
	@Override
	public boolean roleConflictPolicy(String acctUuid, String itroleUuid) throws Exception{
		
		//获取全部角色冲突策略
		List<Policy> roleConflictPolicyList = getRoleConflictPolicy(new PageBounds());
		
		for(Policy policy : roleConflictPolicyList){
			
			JsonNode rootNode = new ObjectMapper().readTree(policy.getPolJsonStr());
			
			Iterator<JsonNode> it = rootNode.getElements();
			
			while(it.hasNext()){
				
				JsonNode node = it.next();
				
				int maxNum = node.get("maxNum").asInt();
				
				String itroles = node.get("itroles").asText();
				
				if(itroles.indexOf(",") >= 0){
					
					List<String> itroleList = Arrays.asList(itroles.split(","));
					
					//匹配待分配角色，检测到该角色就进行冲突校验
					if(itroleList.contains(itroleUuid)){
						
						//获取账号已分配角色
						List<Itrole> acctPrivilegeList = privilegeService.getPrivilegeByAcctUuid(acctUuid);
						
						//转化为字符串
						List<String> acctItrolesList = new ArrayList<>(acctPrivilegeList.size());
						
						for(Itrole itrole : acctPrivilegeList){
							
							acctItrolesList.add(itrole.getItroleUuid());
						}
						
						//将呆分配角色添加到角色列表中
						acctItrolesList.add(itroleUuid);
						
						//求集合交集，如果大于可分配数，则为冲突
						acctItrolesList.retainAll(itroleList);
						
						if(acctItrolesList.size() > maxNum){
							
							StringBuffer result = new StringBuffer();
							for(String s : itroleList){
								
								Itrole itrole = itroleService.getItroleByItroleUuid(s);
								
								if(result.length() > 0){
									
									result.append("," + itrole.getItroleId());
								}else{
									
									result.append(itrole.getItroleId());
								}
								
							}
							result.append(" 最大允许分配数为 ： " + maxNum);
							
							throw new Exception(result.toString());
						}
					}
				}
			}
		}
		
		return true;
	}
	
	@Override
	public void entitlementPolicy(User user) throws Exception{
		//删除用户通过策略获得的权限,再重新授权
		entitlementService.revokePolicyEntitlement(user);
		
		List<BusinessRole> userBizRoleList = userBizRoleService.getUserBizRole(user.getUserUuid());
		
		//转化为 policy 中保存的字符串样式
		StringBuffer userBizRoleString = new StringBuffer();
		for(BusinessRole bizRole : userBizRoleList){
			if(userBizRoleString.length() > 0){
				
				userBizRoleString.append("," + bizRole.getBizRoleUuid());
			}else{
				
				userBizRoleString.append(bizRole.getBizRoleUuid());
			}
		}
		
		//获取全部授权策略
		List<Policy> etmPolicyList = getEntitlementPolicy(new PageBounds());
		
		//获取策略中对应的岗位
		for(Policy policy : etmPolicyList){
			//匹配到相同的岗位，进行授权和撤销其他的授权
			JsonNode rootNode = new ObjectMapper().readTree(policy.getPolJsonStr());
			
			Iterator<JsonNode> it = rootNode.getElements();
			
			while(it.hasNext()){
				
				JsonNode node = it.next();
				
				String bizRole = node.get("bizRole").asText();
				
				//匹配用户岗位，相同则进行授权
				if(bizRole.equals(userBizRoleString.toString())){
					
					String entitlement = node.get("entitlement").asText();	//b9fce523af834989a97acdd2c991787c-->3debf1be7b9940ceb62d149561afd267;b9fce523af834989a97acdd2c991787c-->3debf1be7b9940ceb62d149561afd267,107e80b2c938466ea3cb16e20ec47e86;
					
					String[] entitlements = entitlement.split(";");	//b9fce523af834989a97acdd2c991787c-->3debf1be7b9940ceb62d149561afd267	b9fce523af834989a97acdd2c991787c-->3debf1be7b9940ceb62d149561afd267,107e80b2c938466ea3cb16e20ec47e86
					
					for(String etm : entitlements){	//b9fce523af834989a97acdd2c991787c-->3debf1be7b9940ceb62d149561afd267
						
						if(etm.length() > 0){
							
							if(etm.indexOf("-->") >= 0){
								//分配账号和角色
								String[] resAndRoles = etm.split("-->");
								
								String res = resAndRoles[0];
								
								//分配账号
								if(assignAccount(user, res, policy.getPolUuid())){
									
									String roles = resAndRoles[1];
									
									if(roles.indexOf(",") >= 0){
										String[] splitRoles = roles.split(",");
										
										for(String r : splitRoles){
											//分配角色
											Account account = accountService.getAccountByLoginId(user.getUserId());
											privilegeService.entitlement(account.getAcctUuid(), r, etm);
										}
										
									}else{
										//分配角色
										Account account = accountService.getAccountByLoginId(user.getUserId());
										privilegeService.entitlement(account.getAcctUuid(), roles, etm);
									}
								}
								
								
							}else{	//b9fce523af834989a97acdd2c991787c
								//分配账号
								assignAccount(user, etm, policy.getPolUuid());
							}
						}
					}
				}
				
			}
			
			
			
		}
	}
	
	/*
	 * 创建账号，如果创建失败，表示账号已存在，调用授权方法（entitlement），将该账号授权给对应的用户
	 */
	public boolean assignAccount(User user,String resUuid,String policyUuid) throws Exception{
		System.out.println("-----------------------分配账号-----------------------");
		Map<String, String> basicAttributesMap = new HashMap<>();
		
		String randomPwd = CommonUtil.getRandomString(12);
		
		Resource resource = resourceService.getResourceByPrimarKey(resUuid);
		
		basicAttributesMap.put("userUuid", user.getUserUuid());
		basicAttributesMap.put("userId", user.getUserId());
		basicAttributesMap.put("resUuid", resUuid);
		basicAttributesMap.put("resId", resource.getResId());
		basicAttributesMap.put("acctId", user.getUserId());
		basicAttributesMap.put("acctPwd", randomPwd);
		basicAttributesMap.put("acctPwd2", randomPwd);
		
		
		Map<String, String> attributesMap = new HashMap<>();
		try{
			return accountService.createAccountByPolicy(basicAttributesMap, attributesMap,policyUuid);
		}catch(Exception e){
			
			if("第三方资源创建账号失败".equalsIgnoreCase(e.getMessage())){
				try {
					Account account = accountService.getAccountByLoginId(user.getUserId());
					if(entitlementService.entitlementByPolicy(user.getUserUuid(), account.getAcctTgtUuid(), resUuid, policyUuid) > 0){
						return true;
					}
				} catch (Exception e1) {
					throw e1;
				}
			}
		}
		
		return false;
		//删除原本通过 policy 的授权
//		entitlementService.revokePolicyEntitlement(policyUuid);
	}
}
