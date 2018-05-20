package com.ssm.connector;

import java.util.List;
import java.util.Map;

import com.ssm.pojo.Resource;

public interface IConnector {
		
	/**
	 * Basic connector interface
	 */
	Resource getResource() throws Exception;
	void setResource(Resource resource) throws Exception;
	boolean connect() throws Exception;
	boolean disconnect() throws Exception;
	
	 Map<String, List<String>> findAccount( String identifier) throws Exception;
	void listAccounts() throws Exception;
	 
	String createAccount(Map<String, String> attributesMap) throws Exception;
	int updateAccount(String identifier, Map<String, String> attributesMap) throws Exception;
	boolean enableAccount(String identifier) throws Exception;
	boolean disableAccount(String identifier) throws Exception;
	boolean deleteAccount(String identifier, Map<String, List<String>> attributes) throws Exception;
	
	
	/**
	 * Password interface
	 */
	public interface IPassword {
		boolean verifyPassword(String identifier, StringBuilder password) throws Exception;
		boolean resetPassword(String identifier, StringBuilder password) throws Exception;
	}
	/**
	 * Role provisioning
	 */
	public interface IRole {
		Map<String, List<String>> findRole(String roleIdentifier, String[] attributesToRetrieve) throws Exception;
		List<Map<String, List<String>>> listRoles() throws Exception;
		boolean getAssignedRoles() throws Exception;
		boolean assignRoles(String accountUuid,String itroleUuid) throws Exception;
		boolean unassignRoles(String accountUuid,String itroleUuid) throws Exception;
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
		Map<String, List<String>> getRootOU(String[] attributesToRetrieve) throws Exception;
		List<Map<String, List<String>>> listChildOUs(String ouIdentifier, String[] attributesToRetrieve) throws Exception;
		Map<String, List<String>> findOU(String ouIdentifier, String[] attributesToRetrieve) throws Exception;
	}
	
}