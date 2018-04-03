package com.ssm.mapper;

import com.ssm.pojo.RelUserBizrole;
import com.ssm.pojo.RelUserBizroleExample;
import com.ssm.pojo.RelUserBizroleKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RelUserBizroleMapper {
    int countByExample(RelUserBizroleExample example);

    int deleteByExample(RelUserBizroleExample example);

    int deleteByPrimaryKey(RelUserBizroleKey key);

    int insert(RelUserBizrole record);

    int insertSelective(RelUserBizrole record);

    List<RelUserBizrole> selectByExample(RelUserBizroleExample example);

    RelUserBizrole selectByPrimaryKey(RelUserBizroleKey key);

    int updateByExampleSelective(@Param("record") RelUserBizrole record, @Param("example") RelUserBizroleExample example);

    int updateByExample(@Param("record") RelUserBizrole record, @Param("example") RelUserBizroleExample example);

    int updateByPrimaryKeySelective(RelUserBizrole record);

    int updateByPrimaryKey(RelUserBizrole record);
}