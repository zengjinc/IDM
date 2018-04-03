package com.ssm.connector;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public interface IConnector {
		
	
	
	/**
	 * Basic connector interface
	 */
//	ConfigurationAttributeDefinition[] getConfiguration();
	boolean connect();
	boolean disconnect();
	
//	Schema getAccountSchema();
	
	 Map<String, List<String>> findAccount( String identifier);
	 List<Map<String, List<String>>> listAccounts(Condition[] conditions, String[] attributesToRetrieve );
	/**
	 * 
	 * @param ctx
	 * @param password Some connectors need to reset password when creating account; if so, connector should clear the password buffer to 0 length
	 *   so that UIM knows the password has been reset; otherwise leave the password unchanged. 
	 * @param attributes Input/output
	 *   Connector should also return any generated attributes eg. unique UUID etc in this map
	 * @return
	 */
	int createAccount(StringBuilder password, Map<String, List<String>> attributes);
	int updateAccount(String identifier, Map<String, List<String>> attributes);
	boolean enableAccount(String identifier, Map<String, List<String>> attributes);
	boolean disableAccount(String identifier, Map<String, List<String>> attributes);
	boolean deleteAccount(String identifier, Map<String, List<String>> attributes);
	
	
	/**
	 * Password interface
	 */
	public interface IPassword {
		boolean verifyPassword(String identifier, StringBuilder password, Map<String, List<String>> attributes);
		boolean resetPassword(String identifier, StringBuilder password, Map<String, List<String>> attributes);
	}
	/**
	 * Role provisioning
	 */
	public interface IRole {
//		Schema getRoleSchema();
		Map<String, List<String>> findRole(String roleIdentifier, String[] attributesToRetrieve);
		List<Map<String, List<String>>> listRoles(String[] attributesToRetrieve);
		List<Map<String, List<String>>> getAssignedRoles(String accountIdentifier, List<String> roleIdentifierResults);
		boolean assignRoles(String accountIdentifier, String[] roleIdentifiers, Map<String,List<String>>[] attributes);
		boolean unassignRoles(String accountIdentifier, String[] roleIdentifiers, Map<String,List<String>>[] attributes);
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
//		Schema getOUSchema();
		Map<String, List<String>> getRootOU(String[] attributesToRetrieve);
		List<Map<String, List<String>>> listChildOUs(String ouIdentifier, String[] attributesToRetrieve);
		Map<String, List<String>> findOU(String ouIdentifier, String[] attributesToRetrieve);
	}
	/**
	 * 
	 */
	public interface ILockAccount {
		boolean lockAccount(String identifier, Map<String, List<String>> attributes);
		boolean unlockAccount(String identifier, Map<String, List<String>> attributes);
	}
}