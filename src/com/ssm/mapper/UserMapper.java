package com.ssm.mapper;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.ssm.pojo.User;
import com.ssm.pojo.UserExample;
import com.ssm.pojo.UserQueryExample;
import com.ssm.pojo.to.UserQueryTo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(String userUuid);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    List<User> selectByExample(UserExample example, PageBounds pageBounds);
    
    User selectByPrimaryKey(String userUuid);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<User> queryUser(UserQueryTo userQueryTo);
    
    List<User> queryUser2(UserQueryExample example,PageBounds pageBounds);
}