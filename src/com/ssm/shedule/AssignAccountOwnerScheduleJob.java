package com.ssm.shedule;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssm.pojo.Resource;
import com.ssm.service.IEntitlementService;
import com.ssm.service.IResourceService;
import com.ssm.service.TaskService;
import com.ssm.service.impl.SchedulejobService;
import com.ssm.utils.BeanUtil;

@Component
public class AssignAccountOwnerScheduleJob extends BaseScheduleJob implements TaskService{

	private Logger logger = LoggerFactory.getLogger(AssignAccountOwnerScheduleJob.class);
	
	@Autowired
	public IResourceService resourceService;
	
	@Autowired
	public IEntitlementService entitlementService;
	
	@Override
	public void exec() {
		try{
			/*
			 * 获取计划任务对应的 resourceId
			 */
			String resourceId = null;
			JsonNode node = new ObjectMapper().readTree(this.getSchedulejob().getScdJsonAttr());
			resourceId = node.get("attrJson").get("resource_uuid_sel").asText();
			
			logger.debug("test schedule : scd_id --> " + this.getSchedulejob().getScdId() + ", resourceid --> " +resourceId);
			
			/*
			 * 根据 resourceId 获取对应的 resource
			 */
			Resource resource = resourceService.getResourceByResId(resourceId);
			
			JsonNode rootNode = new ObjectMapper().readTree(resource.getResJsonAttr());
			JsonNode acctJson = rootNode.get("acctJson");
			
			/*
			 * 获取账号架构中的用户属性映射
			 */
			Map<String,String> acctAttrMappingMap = new HashMap<>();
			Iterator<JsonNode> acctAttrMappingIterator = acctJson.get("acct_attr_mapping").elements();
			while(acctAttrMappingIterator.hasNext()){
				JsonNode acctAttrMapping = acctAttrMappingIterator.next();
				String key = acctAttrMapping.get("acct_attr").asText();
				String value = acctAttrMapping.get("user_attr").asText();
				acctAttrMappingMap.put(key, value);
			}
			
			/*
			 * 获取属性定义，保存到map中
			 */
			Map<String,String> targetNameMap = new HashMap<>();	//targetName -> showName
			JsonNode acctAttrDef = acctJson.get("acct_attr_def");
			Iterator<JsonNode> iterator = acctAttrDef.elements();
			while(iterator.hasNext()){
				JsonNode tempNode = iterator.next();
				String targetName = tempNode.get("target_name").asText();
				targetNameMap.put(targetName,tempNode.get("show_name").asText());
			}
			
			/*
			 * 获取账号属性（对应保存在数据库中的字段）
			 */
			Map<String,String> acctAttrMap = new HashMap<>();
			acctAttrMap.put("account_uuid", acctJson.get("account_uuid").asText());
			acctAttrMap.put("account_id", acctJson.get("account_id").asText());
			acctAttrMap.put("account_status", acctJson.get("account_status").asText());
			acctAttrMap.put("account_createtime", acctJson.get("account_createtime").asText());
			acctAttrMap.put("account_modifytime", acctJson.get("account_modifytime").asText());
			acctAttrMap.put("account_ou_uuid", acctJson.get("account_ou_uuid").asText());
			
			/*
			 * 获取账号拥有者分配规则
			 */
			Map<String,String> ruleMap = new HashMap<>();
			Iterator<JsonNode> assignAccountIterator = acctJson.get("acct_assign_rule").elements();
			while(assignAccountIterator.hasNext()){
				String rule = assignAccountIterator.next().asText();
				if(acctAttrMappingMap.containsKey(rule)){
					
					String showName = targetNameMap.get(rule);
					String acctAttr = null;
					for(Entry<String,String> entry : acctAttrMap.entrySet()){
						String value = entry.getValue();
						if(value.equals(showName)){
							acctAttr = entry.getKey();
						}
					}
					String key = null;
					if("account_uuid".equals(acctAttr)){
						key = "acctUuid";
					}
					if("account_id".equals(acctAttr)){
						key = "acctLoginId";
					}
					if("account_status".equals(acctAttr)){
						key = "acctStatus";
					}
					if("account_createtime".equals(acctAttr)){
						key = "acctCreatetime";
					}
					if("account_modifytime".equals(acctAttr)){
						key = "acctModifiedtime";
					}
					if("account_ou_uuid".equals(acctAttr)){
						key = "";
					}
					
					String value = null;
					String userAttr = acctAttrMappingMap.get(rule);
					if("user_id".equals(userAttr)){
						value = "userId";
					}
					if("user_name".equals(userAttr)){
						value = "userName";
					}
					if("user_status".equals(userAttr)){
						value = "userStatus";
					}
					if("user_email".equals(userAttr)){
						value = "userEmail";
					}
					if("user_employee_id".equals(userAttr)){
						value = "userEmployeeId";
					}
					if("user_phonenumber".equals(userAttr)){
						value = "userPhonenumber";
					}
					
					ruleMap.put(key, value);
				}
			}
			
			/*
			 * 根据账号分配规则自动分配账号
			 */
			entitlementService.assignAccountOwner(resourceId,ruleMap);
			
			/*
			 * 更新定时任务（如果是的话）下一次执行时间
			 */
			SchedulejobService schedulejobService = (SchedulejobService)BeanUtil.getBean("schedulejobService");
			schedulejobService.updateSchedulejobTime(this.getSchedulejob());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
