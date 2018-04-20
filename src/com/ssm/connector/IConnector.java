package com.ssm.connector;

import java.util.List;
import java.util.Map;

import com.ssm.pojo.Resource;

public interface IConnector {
		
	/**
	 * Basic connector interface
	 */
	Resource getResource();
	void setResource(Resource resource);
	boolean connect();
	boolean disconnect();
	
	 Map<String, List<String>> findAccount( String identifier);
	void listAccounts();
	 
	String createAccount(Map<String, String> attributesMap);
	int updateAccount(String identifier, Map<String, String> attributesMap);
	boolean enableAccount(String identifier);
	boolean disableAccount(String identifier);
	boolean deleteAccount(String identifier, Map<String, List<String>> attributes);
	
	
	/**
	 * Password interface
	 */
	public interface IPassword {
		boolean verifyPassword(String identifier, StringBuilder password);
		boolean resetPassword(String identifier, StringBuilder password);
	}
	/**
	 * Role provisioning
	 */
	public interface IRole {
		Map<String, List<String>> findRole(String roleIdentifier, String[] attributesToRetrieve);
		List<Map<String, List<String>>> listRoles();
		List<Map<String, List<String>>> getAssignedRoles(String accountIdentifier, List<String> roleIdentifierResults);
		boolean assignRoles(String accountUuid,String itroleUuid);
		boolean unassignRoles(String accountUuid,String itroleUuid);
	}
	/**
	 * Role scope
	 */
//	public interface IRoleScope {
//		Map<String, AttributeDefinition>[] getRoleScopeDefinitions(IContext ctx, String[] roleIdentifiers);
//		ResultCode getAssignedScopes(IContext ctx, String accountIdentifier, String[] roleIdentifiers, RoleScopeValueMap result);
//		RoleScopeResultMap updateAssignedRoleScopes(IContext ctx, String accountIdentifier, RoleScopeValueMap toAdd, RoleScopeValueMap toRemove);
//	}
	/**
	 * OU
	 */
	public interface IOrganizationUnit {
		Map<String, List<String>> getRootOU(String[] attributesToRetrieve);
		List<Map<String, List<String>>> listChildOUs(String ouIdentifier, String[] attributesToRetrieve);
		Map<String, List<String>> findOU(String ouIdentifier, String[] attributesToRetrieve);
	}
	
}