package com.ssm.connector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssm.mapper.AccountAttributeMapper;
import com.ssm.mapper.AccountMapper;
import com.ssm.mapper.ItroleAttributeMapper;
import com.ssm.mapper.ItroleMapper;
import com.ssm.pojo.Account;
import com.ssm.pojo.AccountAttribute;
import com.ssm.pojo.Itrole;
import com.ssm.pojo.ItroleAttribute;
import com.ssm.pojo.Resource;
import com.ssm.utils.CommonUtil;

public class JDBCConnector implements IConnector,IConnector.IPassword, IConnector.IRole, IConnector.IOrganizationUnit, IConnector.ILockAccount{
	private static Logger logger = LoggerFactory.getLogger(JDBCConnector.class);
	Resource resource;
	
	private Connection connection;
	
	JsonNode configJson;
	JsonNode acctJson;
	JsonNode roleJson;
	JsonNode ouJson;
	
	@Autowired
	private AccountAttributeMapper acctAttrMapper;
	
	@Autowired
	private AccountMapper acctMapper;
	
	@Autowired
	private ItroleAttributeMapper itroleAttrMapper;
	
	@Autowired
	private ItroleMapper itroleMapper;
	
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
					return false;
				} catch (SQLException e) {
					e.printStackTrace();
					return false;
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
				return false;
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
		String acctTable = acctJson.get("user_table").asText();
		
		Map<String,String> targetNameMap = new HashMap<>();
		List<String> targetNameList = new ArrayList<>();
		JsonNode acctAttrDef = acctJson.get("acct_attr_def");
		Iterator<JsonNode> iterator = acctAttrDef.getElements();
		while(iterator.hasNext()){
			JsonNode tempNode = iterator.next();
			String targetName = tempNode.get("target_name").getTextValue();
			targetNameMap.put(tempNode.get("show_name").getTextValue(),targetName);
			targetNameList.add(targetName);
		}
		
		StringBuffer sql = new StringBuffer("select ");	//select 1,2,3 from table where status = 1
		int size = targetNameList.size();
		for (int i = 0; i < size; i++) {
			if(i != size - 1){
				sql.append(targetNameList.get(i) + ",");
			}else{
				sql.append(targetNameList.get(i));
			}
		}
		if(acctTable != null && acctTable != ""){
			sql.append(" from " + acctTable + " where 1 = 1");
		}else{
			throw new RuntimeException("user_table is null");
		}
		
		String acctStatus = acctJson.get("account_status").asText();
		String acctStatusEnable = acctJson.get("account_status_enable").asText();
		
		if(acctStatus != null && acctStatus != ""){
			sql.append(" and " + targetNameMap.get(acctStatus) + "='" + acctStatusEnable + "'");
		}
		
		try {
			if(connect()){
				PreparedStatement prepareStatement = connection.prepareStatement(sql.toString());
				ResultSet resultSet = prepareStatement.executeQuery();
				while(resultSet.next()){
//					resultSet.getString(columnLabel);
					String acctUuid = CommonUtil.generateUUID();	//账号的uuid，account表和account_attribute表公用
					/*
					 * 插入account_attribute表格中的数据
					 */
					Account account = new Account();
					AccountAttribute acctAttr = new AccountAttribute();
					acctAttr.setAcctAttrAcctUuid(acctUuid);
					for(String s : targetNameList){
						String value = resultSet.getString(s);
						acctAttr.setAcctAttrKey(s);
						acctAttr.setAcctAttrVal(value);
						acctAttrMapper.insert(acctAttr);
						
						//account表中的uuid和id
						if(s.equals(targetNameMap.get(acctJson.get("account_uuid").asText()))){
							account.setAcctTgtUuid(resultSet.getString(s));
						}
						
						if(s.equals(targetNameMap.get(acctJson.get("account_id").asText()))){
							account.setAcctLoginId(resultSet.getString(s));
						}
						
					}
					/*
					 * 插入account表格的数据
					 */
					account.setAcctUuid(acctUuid);
					account.setAcctResUuid(this.getResource().getResUuid());
					account.setAcctPrimary(1);
					account.setAcctStatus(1);
					account.setAcctLastReconTime(new Date());
					acctMapper.insert(account);
					
				}
				//释放连接资源
				disconnect();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
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
		String roleTable = roleJson.get("role_tablename").asText();
		//获取属性定义，保存到map中
		Map<String,String> targetNameMap = new HashMap<>();
		JsonNode acctAttrDef = roleJson.get("role_attr_def");
		Iterator<JsonNode> iterator = acctAttrDef.getElements();
		while(iterator.hasNext()){
			JsonNode tempNode = iterator.next();
			String targetName = tempNode.get("target_name").getTextValue();
			targetNameMap.put(tempNode.get("show_name").getTextValue(),targetName);
		}
		
		StringBuffer sql = new StringBuffer("select ");	//select 1,2,3 from table where status = 1
		int size = targetNameMap.keySet().size();
		for(String s : targetNameMap.keySet()){
			if(--size != 0){
				sql.append(targetNameMap.get(s) + ",");
			}else{
				sql.append(targetNameMap.get(s));
			}
		}
		
		if(roleTable != null && roleTable != ""){
			sql.append(" from " + roleTable);
		}else{
			throw new RuntimeException("role_table is null");
		}
		
		if(connect()){
			PreparedStatement prepareStatement;
			try {
				prepareStatement = connection.prepareStatement(sql.toString());
				ResultSet resultSet = prepareStatement.executeQuery();
				
				while(resultSet.next()){
					String roleUuid = CommonUtil.generateUUID();	//角色uuid，role表和role_attribute表公用
					/*
					 * 插入role_attribute表格中的数据
					 */
//					Account account = new Account();
					Itrole itrole = new Itrole();
					ItroleAttribute roleAttr = new ItroleAttribute();
					roleAttr.setItroleAttrItroleUuid(roleUuid);
					for(String s : targetNameMap.keySet()){
						String value = resultSet.getString(targetNameMap.get(s));
						roleAttr.setItroleAttrItroleKey(targetNameMap.get(s));
						roleAttr.setItroleAttrItroleVal(value);
						itroleAttrMapper.insert(roleAttr);
						
						//account表中的uuid和id
						if(s.equals(roleJson.get("role_uuid").asText())){
							itrole.setItroleTgtRoleUuid(resultSet.getString(targetNameMap.get(s)));
						}
						
						if(s.equals(roleJson.get("role_id").asText())){
							itrole.setItroleId(resultSet.getString(targetNameMap.get(s)));
						}
						
						if(s.equals(roleJson.get("role_name").asText())){
							itrole.setItroleName(resultSet.getString(targetNameMap.get(s)));
						}
					}
					/*
					 * 插入account表格的数据
					 */
					itrole.setItroleUuid(roleUuid);
					itrole.setItroleDesc(null);
					itrole.setItroleResUuid(this.getResource().getResUuid());
					itroleMapper.insert(itrole);
					
				}
				//释放连接资源
				disconnect();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
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
