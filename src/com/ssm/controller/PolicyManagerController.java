package com.ssm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/topolicy")
public class PolicyManagerController {

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
		public String toEntitlement(){
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
		public String toRoleConflict(){
			return "policy/roleconflict";
		}
		
		@RequestMapping("/roleconflictdetail")
		public String toRoleConflictDetail(){
			return "policy/roleconflictdetail";
		}
}
