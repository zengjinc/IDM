package com.ssm.connector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ssm.pojo.Resource;

public class JDBCConnector implements IConnector,IConnector.IPassword, IConnector.IRole, IConnector.IOrganizationUnit, IConnector.ILockAccount{
	private static Logger logger = LoggerFactory.getLogger(JDBCConnector.class);
	Resource resource;
	
	private Connection connection;
	
	JsonNode configJson;
	JsonNode acctJson;
	JsonNode roleJson;
	JsonNode ouJson;
	
	public Resource getResource() {
		return resource;
	}
	
	public void setResource(Resource resource) {
		this.resource = resource;
		if(this.getResource() != null){
			ObjectMapper mapper = new ObjectMapper();
			try {
				JsonNode rootNode = mapper.readTree(this.getResource().getResJsonAttr());
				configJson = rootNode.get("configJson");
				acctJson = rootNode.get("acctJson");
				roleJson = rootNode.get("roleJson");
				ouJson = rootNode.get("ouJson");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public boolean connect() {
		if(configJson != null){
			String jdbcDrive = configJson.get("jdbc_drive").asText();
			String jdbcUrl = configJson.get("jdbc_url").asText();
			String jdbcUserName = configJson.get("jdbc_username").asText();
			String jdbcPwd = configJson.get("jdbc_pwd").asText();
			try {
				Class.forName(jdbcDrive);
				connection = DriverManager.getConnection(jdbcUrl, jdbcUserName, jdbcPwd);
				return true;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean disconnect() {
		if(connection != null){
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	@Override
	public Map<String, List<String>> findAccount(String identifier) {
		
		return null;
	}

	@Override
	public List<Map<String, List<String>>> listAccounts(Condition[] conditions, String[] attributesToRetrieve) {
		
		return null;
	}

	@Override
	public int createAccount(StringBuilder password, Map<String, List<String>> attributes) {
		return 0;
	}

	@Override
	public int updateAccount(String identifier, Map<String, List<String>> attributes) {
		return 0;
	}

	@Override
	public boolean enableAccount(String identifier, Map<String, List<String>> attributes) {
		return false;
	}

	@Override
	public boolean disableAccount(String identifier, Map<String, List<String>> attributes) {
		return false;
	}

	@Override
	public boolean deleteAccount(String identifier, Map<String, List<String>> attributes) {
		return false;
	}
	
	/*
	 * IConnector.IPassword
	 */
	@Override
	public boolean verifyPassword(String identifier, StringBuilder password, Map<String, List<String>> attributes) {
		return false;
	}

	@Override
	public boolean resetPassword(String identifier, StringBuilder password, Map<String, List<String>> attributes) {
		return false;
	}

	/*
	 * IConnector.IRole
	 */
	@Override
	public Map<String, List<String>> findRole(String roleIdentifier, String[] attributesToRetrieve) {
		return null;
	}

	@Override
	public List<Map<String, List<String>>> listRoles(String[] attributesToRetrieve) {
		return null;
	}

	@Override
	public List<Map<String, List<String>>> getAssignedRoles(String accountIdentifier, List<String> roleIdentifierResults) {
		return null;
	}

	@Override
	public boolean assignRoles(String accountIdentifier, String[] roleIdentifiers, Map<String, List<String>>[] attributes) {
		return false;
	}

	@Override
	public boolean unassignRoles(String accountIdentifier, String[] roleIdentifiers, Map<String, List<String>>[] attributes) {
		return false;
	}

	/*
	 * IConnector.IOrganizationUnit
	 */
	@Override
	public Map<String, List<String>> getRootOU(String[] attributesToRetrieve) {
		return null;
	}

	@Override
	public List<Map<String, List<String>>> listChildOUs(String ouIdentifier, String[] attributesToRetrieve) {
		return null;
	}

	@Override
	public Map<String, List<String>> findOU(String ouIdentifier, String[] attributesToRetrieve) {
		return null;
	}

	/*
	 * IConnector.ILockAccount
	 */
	@Override
	public boolean lockAccount(String identifier, Map<String, List<String>> attributes) {
		return false;
	}

	@Override
	public boolean unlockAccount(String identifier, Map<String, List<String>> attributes) {
		return false;
	}
	
}
