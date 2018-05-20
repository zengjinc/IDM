package com.ssm.shedule;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssm.mapper.AccountAttributeMapper;
import com.ssm.mapper.AccountMapper;
import com.ssm.mapper.ResourceMapper;
import com.ssm.mapper.UserMapper;
import com.ssm.pojo.Account;
import com.ssm.pojo.AccountAttribute;
import com.ssm.pojo.AccountAttributeExample;
import com.ssm.pojo.AccountExample;
import com.ssm.pojo.Resource;
import com.ssm.pojo.ResourceExample;
import com.ssm.pojo.User;
import com.ssm.pojo.UserExample;
import com.ssm.service.TaskService;
import com.ssm.service.impl.SchedulejobService;
import com.ssm.utils.BeanUtil;

public class UserSynchronisedScheduleJob extends BaseScheduleJob implements TaskService{

	private static Logger logger = LoggerFactory.getLogger(UserSynchronisedScheduleJob.class);
	
	@Autowired
	private AccountMapper acctMapper;
	
	@Autowired
	private AccountAttributeMapper acctAttrMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private ResourceMapper resourceMapper;
	
	@Override
	public void exec() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		String resourceId = null;
		String resourceUuid = null;
		Resource resource = null;
		JsonNode acctJson = null;
		JsonNode attrMappingJson = null;
		try {
			JsonNode node = mapper.readTree(this.getSchedulejob().getScdJsonAttr());
			JsonNode attrJson = node.get("attrJson");
			resourceId = attrJson.get("resource_uuid_sel").asText();
			ResourceExample resourceExample = new ResourceExample();
			resourceExample.createCriteria().andResIdEqualTo(resourceId);
			try{
				resource = resourceMapper.selectByExampleWithBLOBs(resourceExample).get(0);
				resourceUuid = resource.getResUuid();
				ObjectMapper mapper2 = new ObjectMapper();
				JsonNode tempRootNode = mapper2.readTree(resource.getResJsonAttr());
				acctJson = tempRootNode.get("acctJson");
				attrMappingJson = acctJson.get("acct_attr_mapping");
				
			}catch(Exception e){
//				resourceUuid = null;
				System.out.println("error");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.debug("test schedule : scd_id --> " + this.getSchedulejob().getScdId() + ", resourceid --> " +resourceId);
		
		//获取 resourceId 回收的所有账号
		AccountExample example = new AccountExample();
		example.createCriteria().andAcctResUuidEqualTo(resourceUuid);
		List<Account> accountList = acctMapper.selectByExample(example);
		List<String> accountUuidList = new ArrayList<>(accountList.size());
		for(Account account : accountList){
			accountUuidList.add(account.getAcctUuid());
		}
		/*
		 * 新增或更新账号
		 */
		for(Account account : accountList){
			String acctUuid = account.getAcctUuid();
			/*
			 * 根据uuid查询用户
			 */
			boolean flag = false;	//用来判断更新还是新增
			User user = userMapper.selectByPrimaryKey(acctUuid);
			if(user == null){	//新增
				flag = true;
				user = new User();
//				String generateUUID = CommonUtil.generateUUID();
				user.setUserUuid(account.getAcctUuid());
				user.setUserPwd("password");
				user.setUserStatus(1);
				user.setUserResUuid(resourceUuid);
			}
			/*
			 * 获取映射属性，保存到用户信息中
			 */
			Iterator<JsonNode> iterator = attrMappingJson.getElements();
			while(iterator.hasNext()){
				JsonNode tempNode = iterator.next();
				String userAttr = tempNode.get("user_attr").asText();
				String acctAttr = tempNode.get("acct_attr").asText();
				/*
				 * 获取对应  acctAttr 所对应的值
				 */
				AccountAttributeExample example1 = new AccountAttributeExample();
				example1.createCriteria().andAcctAttrAcctUuidEqualTo(account.getAcctUuid()).andAcctAttrKeyEqualTo(acctAttr);
				AccountAttribute accountAttribute = null;
				try{
					accountAttribute = acctAttrMapper.selectByExample(example1).get(0);
				}catch(Exception e){
					accountAttribute = null;
				}
				if(accountAttribute != null){
					if(userAttr.equals("user_id")){
						user.setUserId(accountAttribute.getAcctAttrVal());
					}
					if(userAttr.equals("user_name")){
						user.setUserName(accountAttribute.getAcctAttrVal());
					}
					if(userAttr.equals("user_ou")){
						//ou	暂不实现
					}
					if(userAttr.equals("user_status")){
						//转换属性
						if(resource != null){
							ObjectMapper mapper1 = new ObjectMapper();
							String enable = acctJson.get("account_status_enable").asText();
							if(accountAttribute.getAcctAttrVal().equals(enable)){
								user.setUserStatus(1);
							}else{
								user.setUserStatus(0);
							}
						}
					}
					if(userAttr.equals("user_type")){
						user.setUserType(accountAttribute.getAcctAttrVal());
					}
					if(userAttr.equals("user_email")){
						user.setUserEmail(accountAttribute.getAcctAttrVal());
					}
					if(userAttr.equals("user_employee_id")){
						user.setUserEmployeeId(accountAttribute.getAcctAttrVal());
					}
					if(userAttr.equals("user_phonenumber")){
						user.setUserPhonenumber(accountAttribute.getAcctAttrVal());
					}
				}
			}
			if(flag){	//新增
				userMapper.insert(user);
			}else{	//更新
				userMapper.updateByPrimaryKey(user);
			}
		}
		/*
		 * 删除失效（已删除）的账号对应的用户
		 */
		//根据resourceid 查询用户
		UserExample userExample = new UserExample();
		userExample.createCriteria().andUserResUuidEqualTo(resourceUuid);
		List<User> needToDeleteUserList = userMapper.selectByExample(userExample);
		//获取用户的 uuid 列表
		List<String> needToDeleteUserUuidList = new ArrayList<>(needToDeleteUserList.size());
		for(User user : needToDeleteUserList){
			needToDeleteUserUuidList.add(user.getUserUuid());
		}
		//求差集
		needToDeleteUserUuidList.removeAll(accountUuidList);
		//删除	user user_attribute
		for(String userUuid : needToDeleteUserUuidList){
			userMapper.deleteByPrimaryKey(userUuid);
		}
		
		
		SchedulejobService schedulejobService = (SchedulejobService)BeanUtil.getBean("schedulejobService");
		schedulejobService.updateSchedulejobTime(this.getSchedulejob());
	}
	
}
