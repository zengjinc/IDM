package com.ssm.connector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
import com.ssm.pojo.AccountAttributeExample;
import com.ssm.pojo.AccountExample;
import com.ssm.pojo.Itrole;
import com.ssm.pojo.ItroleAttribute;
import com.ssm.pojo.ItroleAttributeExample;
import com.ssm.pojo.ItroleExample;
import com.ssm.pojo.Resource;
import com.ssm.utils.CommonUtil;

import bsh.Interpreter;

public class JDBCConnector implements IConnector,IConnector.IPassword, IConnector.IRole, IConnector.IOrganizationUnit{
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
	
	@Override
	public Resource getResource() {
		return resource;
	}
	
	@Override
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
	public void listAccounts() {
		String acctTable = acctJson.get("user_table").asText();
		String resourceUuid = this.getResource().getResUuid();
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
		
		StringBuffer sql = new StringBuffer("select ");
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
				logger.debug("execute sql : " + sql.toString());
				PreparedStatement prepareStatement = connection.prepareStatement(sql.toString());
				ResultSet resultSet = prepareStatement.executeQuery();
				List<String> accountUuidList = new ArrayList<>();
				/*
				 * 新增或更新账号
				 */
				while(resultSet.next()){
					String accountUuid = targetNameMap.get(acctJson.get("account_uuid").asText());
					String accountId = targetNameMap.get(acctJson.get("account_id").asText());
					String tgt_uuid = resultSet.getString(accountUuid);
					accountUuidList.add(tgt_uuid);
					/*
					 * 判断回收的账号是否已存在数据库
					 */
					AccountExample example = new AccountExample();
					example.createCriteria().andAcctTgtUuidEqualTo(tgt_uuid).andAcctResUuidEqualTo(resourceUuid);
					Account oldAccount = null;
					try{
						oldAccount = acctMapper.selectByExample(example).get(0);
					}catch(Exception e){
						oldAccount = null;
					}
					String	oldAcctUuid = null;
					if(oldAccount != null){
						oldAcctUuid = oldAccount.getAcctUuid();
					}
					
					String acctUuid = CommonUtil.generateUUID();	//生成一个新的uuid，用来保存新的账号，account表和account_attribute表公用
					/*
					 * 插入account_attribute表格中的数据
					 */
					Account account = new Account();
					AccountAttribute acctAttr = new AccountAttribute();
					if(oldAcctUuid != null){
						acctAttr.setAcctAttrAcctUuid(oldAcctUuid);
					}else{
						acctAttr.setAcctAttrAcctUuid(acctUuid);
					}
					for(String s : targetNameList){
						String value = resultSet.getString(s);
						acctAttr.setAcctAttrKey(s);
						acctAttr.setAcctAttrVal(value);
						if(oldAcctUuid != null){
							acctAttrMapper.updateByPrimaryKey(acctAttr);
						}else{
							acctAttrMapper.insert(acctAttr);
						}
						
						/*
						 * account表中的uuid和id
						 */
						if(s.equals(accountUuid)){
							account.setAcctTgtUuid(resultSet.getString(s));
						}
						
						if(s.equals(accountId)){
							account.setAcctLoginId(resultSet.getString(s));
						}
						
					}
					/*
					 * 插入account表格的数据
					 */
					if(oldAcctUuid != null){
						account.setAcctUuid(oldAcctUuid);
					}else{
						account.setAcctUuid(acctUuid);
					}
					account.setAcctResUuid(resourceUuid);
					account.setAcctPrimary(1);
					account.setAcctStatus(1);
					account.setAcctLastReconTime(new Date());
					if(oldAcctUuid != null){
						acctMapper.updateByPrimaryKey(account);
					}else{
						acctMapper.insert(account);
					}
				}
				
				/*
				 *	删除第三方资源中已删除的账号
				 */
				AccountExample example = new AccountExample();
				example.createCriteria().andAcctResUuidEqualTo(resourceUuid);
				List<Account> accountList = acctMapper.selectByExample(example);
				List<String> accountTgtUuidList = new ArrayList<>(accountList.size());
				for(Account acct : accountList){
					accountTgtUuidList.add(acct.getAcctTgtUuid());
				}
				accountTgtUuidList.removeAll(accountUuidList);	//得到需要删除的 tgt_uuid 列表
				
				if(accountTgtUuidList.size() > 0){
					example.clear();
					example.createCriteria().andAcctResUuidEqualTo(resourceUuid).andAcctTgtUuidIn(accountTgtUuidList);
					List<Account> needToDeleteAccount = acctMapper.selectByExample(example);
//				acctMapper.deleteByExample(example);
					for(Account acct : needToDeleteAccount){
						/*
						 * 删除 account_attribute 表中的数据
						 */
						AccountAttributeExample example1 = new AccountAttributeExample();
						example1.createCriteria().andAcctAttrAcctUuidEqualTo(acct.getAcctUuid());
						acctAttrMapper.deleteByExample(example1);
						/*
						 * 删除 account 表中的数据
						 */
						acctMapper.deleteByPrimaryKey(acct.getAcctUuid());
					}
				}
				
				disconnect();		//释放连接资源
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * 创建账号，返回该账号的 uuid
	 * uuid生成类型：static : 利用提供的脚本，由 idm 生成
	 * 			   sql : 只支持 sql 查询语句，返回 uuid，如果是存储过程，可以考虑写相同规则的脚本，在 idm 中生成
	 * 			   auto : 在插入过程中不提供uuid。
	 */
	@Override
	public String createAccount(Map<String, String> attributesMap) {
		//insert into account(acct_uuid,acct_id,acct_status) value('acctuuid5','account_5',1);
		String userTable = acctJson.get("user_table").asText();
		String acctUuid = acctJson.get("account_uuid").asText();
		String uuidgenerType = acctJson.get("user_uuidgener_sel").asText();
		String uuidgenerScript = acctJson.get("uuidgener_text").asText();
		
		String pwdCol = acctJson.get("pwd_col").asText();
		String passwordEncodingScript = acctJson.get("pwd_encoding_text").asText();
		
		//获取属性定义，保存到map中
		Map<String,String> targetNameMap = new HashMap<>();
		JsonNode acctAttrDef = acctJson.get("acct_attr_def");
		Iterator<JsonNode> iterator = acctAttrDef.getElements();
		while(iterator.hasNext()){
			JsonNode tempNode = iterator.next();
			String targetName = tempNode.get("target_name").getTextValue();
			targetNameMap.put(tempNode.get("show_name").getTextValue(),targetName);
		}
		
		String acctStatus = targetNameMap.get(acctJson.get("account_status").asText());
		String acctStatusEnable = acctJson.get("account_status_enable").asText();
		
		attributesMap.put(acctStatus, acctStatusEnable);
		
		String generateUuid = null;
		if(uuidgenerType.equalsIgnoreCase("static")){
			generateUuid = generateUuid(uuidgenerScript);
		}
		if(uuidgenerType.equalsIgnoreCase("sql")){
			generateUuid = generateUuidBySQL(uuidgenerScript);
		}
		
		StringBuffer colSb = new StringBuffer(" (");
		StringBuffer valSb = new StringBuffer(" (");
		for(Entry<String,String> entry : attributesMap.entrySet()){
			if(entry.getKey().equalsIgnoreCase(pwdCol)){
				String encodePassword = encodePassword(passwordEncodingScript, entry.getValue().toCharArray());
				colSb.append(entry.getKey() + ",");
				valSb.append("'" + encodePassword + "',");
			}else{
				colSb.append(entry.getKey() + ",");
				valSb.append("'" + entry.getValue() + "',");
			}
		}
		
		if(generateUuid != null && !generateUuid.equals("")){
			colSb.append(targetNameMap.get(acctUuid) + ")");
			valSb.append("'" + generateUuid + "')");
		}else{
			colSb.deleteCharAt(colSb.lastIndexOf(","));
			colSb.append(")");
			valSb.deleteCharAt(valSb.lastIndexOf(","));
			valSb.append(")");
		}
		
		StringBuffer sql = new StringBuffer("insert into " + userTable + colSb.toString() +  " values " + valSb.toString());
		
		//连接更新
		try{
			if(connect()){
				logger.debug("execute sql : " + sql);
				if(generateUuid != null && !generateUuid.equals("")){
					PreparedStatement prepareStatement = connection.prepareStatement(sql.toString());
					int updateLine = prepareStatement.executeUpdate();
					if(updateLine > 0){
						return generateUuid;
					}
				}else{
					PreparedStatement prepareStatement = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
					prepareStatement.executeUpdate();
					ResultSet resultSet = prepareStatement.getGeneratedKeys();
					if(resultSet.next()){
						return resultSet.getString(1);
					}
				}
			}
		}catch(Exception e){
			logger.debug(e.getMessage());
			return null;
		}finally {
			disconnect();
		}
		
		return null;
	}

	@Override
	public int updateAccount(String identifier, Map<String, String> attributesMap) {
		//update user set xxx = 'xxx',xxx = 'xxx' where xxx='xxx';
		String userTable = acctJson.get("user_table").asText();
		String acctUuid = acctJson.get("account_uuid").asText();
		
		//获取属性定义，保存到map中
		Map<String,String> targetNameMap = new HashMap<>();
		JsonNode acctAttrDef = acctJson.get("acct_attr_def");
		Iterator<JsonNode> iterator = acctAttrDef.getElements();
		while(iterator.hasNext()){
			JsonNode tempNode = iterator.next();
			String targetName = tempNode.get("target_name").getTextValue();
			targetNameMap.put(tempNode.get("show_name").getTextValue(),targetName);
		}
		
		StringBuffer sql = new StringBuffer("update " + userTable + " set ");
		for(Entry<String,String> entry : attributesMap.entrySet()){
			sql.append(entry.getKey() + "='"+ entry.getValue() +"',");
		}
		String tempAcctUuid = targetNameMap.get(acctUuid);
		sql.append(tempAcctUuid + "=" + tempAcctUuid + " where " + tempAcctUuid + "='" + identifier + "'");
		
		//连接更新
				try{
					if(connect()){
						logger.debug("execute sql : " + sql);
						PreparedStatement prepareStatement = connection.prepareStatement(sql.toString());
						return prepareStatement.executeUpdate();
					}
				}catch(Exception e){
					return 0;
				}finally {
					disconnect();
				}
		return 0;
	}

	@Override
	public boolean enableAccount(String identifier) {
		//拼接语句	update user set status='' where user_uuid = ?
		String userTable = acctJson.get("user_table").asText();
		String acctStatus = acctJson.get("account_status").asText();
		String acctStatusEnable = acctJson.get("account_status_enable").asText();
		String acctUuid = acctJson.get("account_uuid").asText();
		//获取属性定义，保存到map中
		Map<String,String> targetNameMap = new HashMap<>();
		JsonNode acctAttrDef = acctJson.get("acct_attr_def");
		Iterator<JsonNode> iterator = acctAttrDef.getElements();
		while(iterator.hasNext()){
			JsonNode tempNode = iterator.next();
			String targetName = tempNode.get("target_name").getTextValue();
			targetNameMap.put(tempNode.get("show_name").getTextValue(),targetName);
		}
		
		String sql = new StringBuffer("update " + userTable + " set " + targetNameMap.get(acctStatus) + " = '"+acctStatusEnable+"' where " + targetNameMap.get(acctUuid) + " = '" + identifier + "'").toString();
		//连接更新
		try{
			if(connect()){
				logger.debug("execute sql : " + sql);
				PreparedStatement prepareStatement = connection.prepareStatement(sql);
				int updateLine = prepareStatement.executeUpdate();
				if(updateLine > 0){
					return true;
				}
			}
		}catch(Exception e){
			return false;
		}finally {
			disconnect();
		}
		return false;
	}

	@Override
	public boolean disableAccount(String identifier) {
		//拼接语句	update user set status='' where user_uuid = ?
		String userTable = acctJson.get("user_table").asText();
		String acctStatus = acctJson.get("account_status").asText();
		String acctStatusDisable = acctJson.get("account_status_disable").asText();
		String acctUuid = acctJson.get("account_uuid").asText();
		//获取属性定义，保存到map中
		Map<String,String> targetNameMap = new HashMap<>();
		JsonNode acctAttrDef = acctJson.get("acct_attr_def");
		Iterator<JsonNode> iterator = acctAttrDef.getElements();
		while(iterator.hasNext()){
			JsonNode tempNode = iterator.next();
			String targetName = tempNode.get("target_name").getTextValue();
			targetNameMap.put(tempNode.get("show_name").getTextValue(),targetName);
		}
		
		String sql = new StringBuffer("update " + userTable + " set " + targetNameMap.get(acctStatus) + " = '"+acctStatusDisable+"' where " + targetNameMap.get(acctUuid) + " = '" + identifier + "'").toString();
		//连接更新
		try{
			if(connect()){
				logger.debug("execute sql : " + sql);
				PreparedStatement prepareStatement = connection.prepareStatement(sql);
				int updateLine = prepareStatement.executeUpdate();
				if(updateLine > 0){
					return true;
				}
			}
		}catch(Exception e){
			return false;
		}finally {
			disconnect();
		}
		return false;
	}

	@Override
	public boolean deleteAccount(String identifier, Map<String, List<String>> attributes) {
		return false;
	}
	
	/**
	 * IConnector.IPassword
	 */
	@Override
	public boolean verifyPassword(String identifier, StringBuilder password) {
		//密码加密
		String passwordEncodingScript = acctJson.get("pwd_encoding_text").asText();
		String encodePassword = encodePassword(passwordEncodingScript, password.toString().toCharArray());
		//拼接sql语句	
		String userTable = acctJson.get("user_table").asText();
		String userPwdCol = acctJson.get("pwd_col").asText();
		String acctUuid = acctJson.get("account_uuid").asText();
		//获取属性定义，保存到map中
		Map<String,String> targetNameMap = new HashMap<>();
		JsonNode acctAttrDef = acctJson.get("acct_attr_def");
		Iterator<JsonNode> iterator = acctAttrDef.getElements();
		while(iterator.hasNext()){
			JsonNode tempNode = iterator.next();
			String targetName = tempNode.get("target_name").getTextValue();
			targetNameMap.put(tempNode.get("show_name").getTextValue(),targetName);
		}
		
		//select * from user_table where user_uuid = ? and user_pwd = ?
		String sql = new StringBuffer(
				"select * from " + userTable + " where " + targetNameMap.get(acctUuid) + " = '" + identifier + "' and " + userPwdCol + " = '" + encodePassword + "'").toString();
		
		//连接更新
		try{
			if(connect()){
				logger.debug("execute sql : " + sql);
				PreparedStatement prepareStatement = connection.prepareStatement(sql);
				ResultSet resultSet = prepareStatement.executeQuery();
				
				if(resultSet.next()){
					return true;
				}
			}
		}catch(Exception e){
			return false;
		}finally {
			disconnect();
		}
		return false;
	}
	
	/*
	 * 重设密码：更新对应 identifier 的密码。利用密码加密脚本将对 password 进行加密 
	 */
	@Override
	public boolean resetPassword(String identifier, StringBuilder password) {
		//密码加密
		String passwordEncodingScript = acctJson.get("pwd_encoding_text").asText();
		String encodePassword = encodePassword(passwordEncodingScript, password.toString().toCharArray());
		//拼接sql语句	
		String userTable = acctJson.get("user_table").asText();
		String userPwdCol = acctJson.get("pwd_col").asText();
		String acctUuid = acctJson.get("account_uuid").asText();
		//获取属性定义，保存到map中
		Map<String,String> targetNameMap = new HashMap<>();
		JsonNode acctAttrDef = acctJson.get("acct_attr_def");
		Iterator<JsonNode> iterator = acctAttrDef.getElements();
		while(iterator.hasNext()){
			JsonNode tempNode = iterator.next();
			String targetName = tempNode.get("target_name").getTextValue();
			targetNameMap.put(tempNode.get("show_name").getTextValue(),targetName);
		}
		//update user_table set user_pwd = ? where user_uuid = ?
		String sql = new StringBuffer("update " + userTable + " set " + userPwdCol + " = '" + encodePassword + "' where " + targetNameMap.get(acctUuid) + " = '" + identifier + "'" ).toString();
		
		//连接更新
		try{
			if(connect()){
				logger.debug("execute sql : " + sql);
				PreparedStatement prepareStatement = connection.prepareStatement(sql);
				int updateLine = prepareStatement.executeUpdate();
				if(updateLine > 0){
					return true;
				}
			}
		}catch(Exception e){
			return false;
		}finally {
			disconnect();
		}
		return false;
	}

	/**
	 * IConnector.IRole
	 */
	@Override
	public Map<String, List<String>> findRole(String roleIdentifier, String[] attributesToRetrieve) {
		return null;
	}

	@Override
	public List<Map<String, List<String>>> listRoles() {
		String resourceUuid = this.getResource().getResUuid();
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
		
		StringBuffer sql = new StringBuffer("select ");
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
				List<String> roleUuidList = new ArrayList<>();	//存放回收回来的角色的uuid(tgt_uuid)
				/*
				 * 新增或更新角色
				 */
				while(resultSet.next()){
					String roleUuid = targetNameMap.get(roleJson.get("role_uuid").asText());
//					String roleId = targetNameMap.get(roleJson.get("role_id").asText());
//					String roleName = targetNameMap.get(roleJson.get("role_name").asText());
					String tgt_uuid = resultSet.getString(roleUuid);
					roleUuidList.add(tgt_uuid);
					/*
					 * 判断回收的角色是否已存在数据库
					 */
					ItroleExample example = new ItroleExample();
					example.createCriteria().andItroleResUuidEqualTo(resourceUuid).andItroleTgtRoleUuidEqualTo(tgt_uuid);
					Itrole itRole = null;
					try{
						itRole = itroleMapper.selectByExample(example).get(0);
					}catch(Exception e){
						itRole = null;
					}
					String oldRoleUuid = null;
					if(itRole != null){
						oldRoleUuid = itRole.getItroleUuid();
					}
					String generatRoleUuid = CommonUtil.generateUUID();	//角色uuid，role表和role_attribute表公用
					/*
					 * 插入role_attribute表格中的数据
					 */
					Itrole itrole = new Itrole();
					ItroleAttribute roleAttr = new ItroleAttribute();
					if(oldRoleUuid != null){
						roleAttr.setItroleAttrItroleUuid(oldRoleUuid);
					}else{
						roleAttr.setItroleAttrItroleUuid(generatRoleUuid);
					}
					for(String s : targetNameMap.keySet()){
						String value = resultSet.getString(targetNameMap.get(s));
						roleAttr.setItroleAttrItroleKey(targetNameMap.get(s));
						roleAttr.setItroleAttrItroleVal(value);
						if(oldRoleUuid != null){
							itroleAttrMapper.updateByPrimaryKey(roleAttr);
						}else{
							itroleAttrMapper.insert(roleAttr);
						}
						
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
					 * 插入itrole表格的数据
					 */
					if(oldRoleUuid != null){
						itrole.setItroleUuid(oldRoleUuid);
					}else{
						itrole.setItroleUuid(generatRoleUuid);
					}
					itrole.setItroleDesc(null);
					itrole.setItroleResUuid(resourceUuid);
					if(oldRoleUuid != null){
						itroleMapper.updateByPrimaryKey(itrole);
					}else{
						itroleMapper.insert(itrole);
					}
					
				}
				/*
				 * 删除第三方资源中已删除的角色
				 * 查询数据库中现有的角色，得到对应的 tgt_uuid 列表
				 */
				ItroleExample example = new ItroleExample();
				example.createCriteria().andItroleResUuidEqualTo(resourceUuid);
				List<Itrole> itroleList = itroleMapper.selectByExample(example);
				List<String> itroleTgtUuidList = new ArrayList<>(itroleList.size());
				for(Itrole itrole : itroleList){
					itroleTgtUuidList.add(itrole.getItroleTgtRoleUuid());
				}
				itroleTgtUuidList.removeAll(roleUuidList);	//进行差运算
				/*
				 * 删除 role 和 role_attribute 表格中的数据
				 */
				if(itroleTgtUuidList.size() > 0){
					example.clear();
					example.createCriteria().andItroleResUuidEqualTo(resourceUuid).andItroleTgtRoleUuidIn(itroleTgtUuidList);
					List<Itrole> needToDeleteRole = itroleMapper.selectByExample(example);
					for(Itrole itrole : needToDeleteRole){
						itroleMapper.deleteByPrimaryKey(itrole.getItroleUuid());
						
						ItroleAttributeExample example1 = new ItroleAttributeExample();
						example1.createCriteria().andItroleAttrItroleUuidEqualTo(itrole.getItroleUuid());
						itroleAttrMapper.deleteByExample(example1);
					}
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				disconnect();	//释放连接资源
			}
		}
		
		
		
		return null;
	}

	@Override
	public List<Map<String, List<String>>> getAssignedRoles(String accountIdentifier, List<String> roleIdentifierResults) {
		return null;
	}

	@Override
	public boolean assignRoles(String accountUuid,String itroleUuid) {
		//insert into xxx (xxx,xxx) values ();
		String roleRelTable = roleJson.get("role_rel_tablename").asText();
		String roleRelTableUuid = roleJson.get("role_rel_uuid").asText();
		String roleCol = roleJson.get("role_col").asText();
		String userCol = roleJson.get("role_user_col").asText();
		
		StringBuffer sql = new StringBuffer();
		if(roleRelTableUuid != null && !roleRelTableUuid.equals("")){
			String generateUuid = null;
			String uuidGenerateType = roleJson.get("role_uuidgener_sel").asText();
			String uuidGenerateScript = roleJson.get("role_uuidgener_text").asText();
			if(uuidGenerateType.equalsIgnoreCase("static")){
				generateUuid = generateUuid(uuidGenerateScript);
			}
			if(uuidGenerateType.equalsIgnoreCase("sql")){
				generateUuid = generateUuidBySQL(uuidGenerateScript);
			}
			sql.append("insert into " + roleRelTable + " (" + roleRelTableUuid + "," + roleCol + "," + userCol + ") values ('" + generateUuid + "','" + itroleUuid + "','" + accountUuid + "')");
		}else{
			sql.append("insert into " + roleRelTable + " (" + roleCol + "," + userCol + ") values ('" + itroleUuid + "','" + accountUuid + "')");
		}
		
		//连接更新
		try{
			if(connect()){
				logger.debug("execute sql : " + sql.toString());
				PreparedStatement prepareStatement = connection.prepareStatement(sql.toString());
				int updateLine = prepareStatement.executeUpdate();
				if(updateLine > 0){
					return true;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally {
			disconnect();
		}
		
		return false;
	}

	@Override
	public boolean unassignRoles(String accountUuid,String itroleUuid) {
		//delete from xxx where xxx = xxx and xxx = xxx;
		String roleRelTable = roleJson.get("role_rel_tablename").asText();
		String roleCol = roleJson.get("role_col").asText();
		String userCol = roleJson.get("role_user_col").asText();
		
		String sql = new StringBuffer("delete from " + roleRelTable + " where " + userCol + "='" + accountUuid + "' and " + roleCol + "='" + itroleUuid + "'").toString();
		
		//连接更新
		try{
			if(connect()){
				logger.debug("execute sql : " + sql.toString());
				PreparedStatement prepareStatement = connection.prepareStatement(sql.toString());
				int updateLine = prepareStatement.executeUpdate();
				if(updateLine > 0){
					return true;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally {
			disconnect();
		}
		return false;
	}

	/**
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

	private String encodePassword(String passwordEncodingScript, char[] password) {

		logger.info("Encode Password.");

		if (passwordEncodingScript != null && !passwordEncodingScript.trim().isEmpty()) {

			logger.info("Password encoding.");
			logger.debug("Script : " + passwordEncodingScript);

			try {

				Interpreter beanShell = new Interpreter();

				beanShell.set("logger", logger);
//				beanShell.set("salt", salt);
				beanShell.set("password", new String(password));

				Object result = beanShell.eval(passwordEncodingScript);

				if (result != null) {
					return result.toString();

				} else {
					logger.debug("Not able to execute encode bean script.");
					return null;
				}

			} catch (Exception e) {
				logger.debug(e.getMessage());
				return null;
			}
		}
		
		return new String(password);
	}
	
	public String generateUuid(String generateUuidScript){
		
		logger.info("Generate UUID.");

		if (generateUuidScript != null && !generateUuidScript.trim().isEmpty()) {

			logger.debug("Script : " + generateUuidScript);

			try {

				Interpreter beanShell = new Interpreter();

				Object result = beanShell.eval(generateUuidScript);

				if (result != null) {
					return result.toString();

				} else {
					logger.debug("Not able to execute generate bean script.");
					return null;
				}

			} catch (Exception e) {
				logger.debug(e.getMessage());
				return null;
			}
		}
		
		return null;
	}
	
	public String generateUuidBySQL(String generateUuidScript){
		logger.info("Generate UUID.");
		
		if (generateUuidScript != null && !generateUuidScript.trim().isEmpty()) {

			logger.debug("Script : " + generateUuidScript);
			
			try{
				if(connect()){
					PreparedStatement prepareStatement = connection.prepareStatement(generateUuidScript);
					ResultSet resultSet = prepareStatement.executeQuery();
					
					if(resultSet.next()){
						return resultSet.getString(1);
					}
				}
			}catch(Exception e){
				return null;
			}finally {
				disconnect();
			}
		}
		
		return null;
	}
	
}
