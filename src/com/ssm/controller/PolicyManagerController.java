package com.ssm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.ssm.pojo.BusinessRole;
import com.ssm.pojo.Itrole;
import com.ssm.pojo.Policy;
import com.ssm.pojo.PolicyExample;
import com.ssm.pojo.PolicyExample.Criteria;
import com.ssm.pojo.Resource;
import com.ssm.service.IBusinessRoleService;
import com.ssm.service.IItroleService;
import com.ssm.service.IPolicyService;
import com.ssm.service.IResourceService;
import com.ssm.utils.CommonUtil;

@Controller
@RequestMapping("/topolicy")
public class PolicyManagerController {
	
		@Autowired
		private IResourceService resourceService;
		
		@Autowired
		private IItroleService itroleService;
		
		@Autowired
		private IPolicyService policyService;
		
		@Autowired
		private IBusinessRoleService bizroleService;

		private static Logger logger = LoggerFactory.getLogger(PolicyManagerController.class);
		
		@RequestMapping("/bizroleassign")
		public String toBizRoleAssign(){
			return "policy/bizroleassign";
		}
		
		@RequestMapping("/bizroleassigndetail")
		public String toBizRoleAssignDetail(){
			return "policy/bizroleassigndetail";
		}
		
		@RequestMapping("/entitlement")
		public String toEntitlement(ModelMap modelMap, @RequestParam(required = true, defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit,@ModelAttribute Policy policy) throws Exception{
			String polId = policy.getPolId();
			String polName = policy.getPolName();
			
			PageBounds pageBounds = new PageBounds(page, limit);
			
			if(polId == null && polName == null){
				
				List<Policy> etmPolicyList = policyService.getEntitlementPolicy(pageBounds);
				
				modelMap.put("etmPolicyList", etmPolicyList);
			}else{
				
				PolicyExample example = new PolicyExample();
				Criteria criteria = example.createCriteria();
				
				if(polId.length() > 0){
					criteria.andPolIdEqualTo(polId);
				}
				
				if(polName.length() > 0){
					criteria.andPolNameLike("%" + polName + "%");
				}
				
				example.setOrderByClause("pol_id");
				
				List<Policy> etmPolicyList = policyService.getPolicyByExample(pageBounds, example);
				
				modelMap.put("etmPolicyList", etmPolicyList);
			}
			
			return "policy/entitlement";
		}
		
		@RequestMapping("/entitlementdetail")
		public String toEntitlementDetail(){
			return "policy/entitlementdetail";
		}
		
		@RequestMapping("/eventnotification")
		public String toEventNotification(){
			return "policy/eventnotification";
		}
		
		@RequestMapping("/roleconflict")
		public String toRoleConflict(ModelMap modelMap, @RequestParam(required = true, defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit,@ModelAttribute Policy policy) throws Exception{
			String polId = policy.getPolId();
			String polName = policy.getPolName();
			
			PageBounds pageBounds = new PageBounds(page, limit);
			
			if(polId == null && polName == null){
				
				List<Policy> roleconflictPolicyList = policyService.getRoleConflictPolicy(pageBounds);
				
				modelMap.put("roleconflictPolicyList", roleconflictPolicyList);
			}else{
				
				PolicyExample example = new PolicyExample();
				Criteria criteria = example.createCriteria();
				
				if(polId.length() > 0){
					criteria.andPolIdEqualTo(polId);
				}
				
				if(polName.length() > 0){
					criteria.andPolNameLike("%" + polName + "%");
				}
				
				example.setOrderByClause("pol_id");
				
				List<Policy> roleconflictPolicyList = policyService.getPolicyByExample(pageBounds, example);
				
				modelMap.put("roleconflictPolicyList", roleconflictPolicyList);
			}
			
			return "policy/roleconflict";
		}
		
		@RequestMapping("/roleconflictdetail")
		public String toRoleConflictDetail(){
			return "policy/roleconflictdetail";
		}
		
		@RequestMapping("/getresourcebyresuuid")
		@ResponseBody
		public List<Resource> getResourceByResUuid(@RequestBody String jsonStr) throws Exception{
			JsonNode node = new ObjectMapper().readTree(jsonStr);
			Iterator<JsonNode> it = node.getElements();
			
			List<Resource> result = new ArrayList<>();
			while(it.hasNext()){
				
				String resUuid = it.next().asText();
				
				result.add(resourceService.getResourceByPrimarKey(resUuid));
			}
			return result;
		}
		
		@RequestMapping("/getitrolebyresuuid")
		@ResponseBody
		public List<Itrole> getItroleByResUuid(@RequestBody String jsonStr) throws Exception{	//{"resUuid":"b9fce523af834989a97acdd2c991787c","roleArr":["1","2"]}
			JsonNode rootNode = new ObjectMapper().readTree(jsonStr);
			
			String resUuid = rootNode.get("resUuid").asText();
			
			Iterator<JsonNode> it = rootNode.get("roleArr").getElements();
			
			List<String> selectedRole = new ArrayList<>();
			while(it.hasNext()){
				
				selectedRole.add(it.next().asText());
				
			}
			
			List<Itrole> itroleList = itroleService.getItroleByResUuid(resUuid);
			
			Iterator<Itrole> it2 = itroleList.iterator();
			
			while(it2.hasNext()){
				
				if(selectedRole.contains(it2.next().getItroleId())){
					
					it2.remove();
					
				}
			}
			
			return itroleList;
		}
		
		@RequestMapping("/getitrolebyresuuid2")
		@ResponseBody
		public List<Itrole> getItroleByResUuid2(@RequestBody String jsonStr) throws Exception{
			
			String resUuid = new ObjectMapper().readTree(jsonStr).asText();
			
			return itroleService.getItroleByResUuid(resUuid);
		}
		
		@RequestMapping("/saveetmpolicy")
		@ResponseBody
		public String saveEtmPolicy(@RequestBody String jsonStr){	//"etmPolUuid":null
			try{
				JsonNode rootNode = new ObjectMapper().readTree(jsonStr);
				
				String etmPolUuid = rootNode.get("etmPolUuid").asText();
				String policyId = rootNode.get("etmPolId").asText();
				String policyName = rootNode.get("etmPolName").asText();
				String policyDesc = rootNode.get("etmPolDesc").asText();
				String policyJsonStr = rootNode.get("etmArr").toString();
				
				Policy policy = new Policy();
				policy.setPolUuid(CommonUtil.generateUUID());
				policy.setPolType("entitlement policy");
				policy.setPolId(policyId);
				policy.setPolName(policyName);
				policy.setPolDesc(policyDesc);
				policy.setPolJsonStr(policyJsonStr);
				
				
				int num;
				if(etmPolUuid != null && !etmPolUuid.equals("null")){
					policy.setPolUuid(etmPolUuid);
					num = policyService.updatePolicy(policy);
				}else{
					num = policyService.savePolicy(policy);
				}
				
				if(num > 0){
					return "success";
				}
			}catch(Exception e){
				e.printStackTrace();
				return e.getMessage();
			}
			return "failure";
		}
		
		@RequestMapping("/saveroleconflictpolicy")
		@ResponseBody
		public String saveRoleConflictPolicy(@RequestBody String josnStr){
			try{
//				{"policyUuid" : policyUuid,"policyId" : policyId, "policyName" : policyName, 
//				"policyDesc" : policyDesc, "polArr" : polArr};
				JsonNode rootNode = new ObjectMapper().readTree(josnStr);
				
				String policyUuid = rootNode.get("policyUuid").asText();
				String policyId = rootNode.get("policyId").asText();
				String policyName = rootNode.get("policyName").asText();
				String policyDesc = rootNode.get("policyDesc").asText();
				String policyJsonStr = rootNode.get("polArr").toString();
				
				Policy policy = new Policy();
				
				policy.setPolId(policyId);
				policy.setPolName(policyName);
				policy.setPolDesc(policyDesc);
				policy.setPolJsonStr(policyJsonStr);
				policy.setPolType("role conflict policy");
				
				int num;
				if(policyUuid != null && !policyUuid.equals("null")){
					policy.setPolUuid(policyUuid);
					num = policyService.updatePolicy(policy);
				}else{
					policy.setPolUuid(CommonUtil.generateUUID());
					num = policyService.savePolicy(policy);
				}
				
				if(num > 0){
					return "success";
				}
			}catch(Exception e){
				e.printStackTrace();
				return e.getMessage();
			}
			
			return "failure";
		}
		
		@RequestMapping("/deletmpolicy")
		public String delEtmPolicy(@RequestParam(value="etmlpouuid")String etmPolUuid) throws Exception{
			
			policyService.deletePolicy(etmPolUuid);
			
			return "redirect:entitlement.action";
		}
		
		@RequestMapping("/delroleconflictpolicy")
		public String delRoleConflictPolicy(@RequestParam(value="policyuuid")String policyuuid) throws Exception{
			
			policyService.deletePolicy(policyuuid);
			
			return "redirect:roleconflict.action";
		}
		
		@RequestMapping("/getpolicybyuuid")
		@ResponseBody
		public Policy getPolicyByUuid(@RequestBody String jsonStr) throws Exception{
			JsonNode node = new ObjectMapper().readTree(jsonStr);
			
			String etmPolUuid = node.get("etmPolUuid").asText();
			
			return policyService.getPolicyByUuid(etmPolUuid);
		}
		
		@RequestMapping("/getRole")
		@ResponseBody
		public List<Itrole> getRole(@RequestBody String jsonStr) throws Exception{
			List<Itrole> roleList = new ArrayList<>();
	
			JsonNode node = new ObjectMapper().readTree(jsonStr);
			
			if(node.isContainerNode()){
				
				Iterator<JsonNode> it = node.getElements();
				
				while(it.hasNext()){
					String itroleUuid = it.next().asText();
					if(itroleUuid.length() > 0)
						roleList.add(itroleService.getItroleByItroleUuid(itroleUuid));
				}
			}else{
				
				roleList.add(itroleService.getItroleByItroleUuid(node.asText()));
			}
			return roleList;
		}
		
		@RequestMapping("/getResource")
		@ResponseBody
		public Resource getResource(@RequestBody String jsonStr) throws Exception{
			String resUuid = new ObjectMapper().readTree(jsonStr).get("resUuid").asText();
			
			return resourceService.getResourceByPrimarKey(resUuid);
		}
		
		@RequestMapping("/getBizrole")
		@ResponseBody
		public List<BusinessRole> getBizrole(@RequestBody String jsonStr) throws Exception{
			List<BusinessRole> bizroleList = new ArrayList<>();
			
			JsonNode node = new ObjectMapper().readTree(jsonStr);
			
			if(node.isContainerNode()){
				
				Iterator<JsonNode> it = node.getElements();
				
				while(it.hasNext()){
					String bizroleUuid = it.next().asText();
					
					if(bizroleUuid.length() > 0){
						bizroleList.add(bizroleService.getBizRole(bizroleUuid));
					}
				}
			}else{
				
				bizroleList.add(bizroleService.getBizRole(node.asText()));
			}
			
			return bizroleList;
		}
		
}
