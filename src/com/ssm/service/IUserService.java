package com.ssm.service;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.ssm.pojo.User;
import com.ssm.pojo.UserExample;
import com.ssm.pojo.UserQueryExample;
import com.ssm.pojo.to.UserQueryTo;

public interface IUserService {

	void deleteUser(String userUuid) throws Exception;

	User getUserByPrimaryKey(String userUuid) throws Exception;
	
	List<User> getUserByExample(UserExample example) throws Exception;

	List<User> getUserByExample(UserExample example, PageBounds pageBounds) throws Exception;
	
	int addUser(User record) throws Exception;

	int addUserSelective(User record) throws Exception;

	int removeUserByExample(UserExample example) throws Exception;

	int removeUserByPrimaryKey(String userUuid) throws Exception;

	int updateUserByExample(User record, UserExample example) throws Exception;

	int updateUserByExampleSelective(User record, UserExample example) throws Exception;

	int updateUserByPrimaryKey(User record) throws Exception;

	int updateUserByPrimaryKeySelective(User record) throws Exception;

	int countUserByExample(UserExample example) throws Exception;

	List<User> queryUser(UserQueryTo userQueryTo) throws Exception;

	List<User> queryUser(UserQueryExample example,PageBounds pageBounds) throws Exception;
}
