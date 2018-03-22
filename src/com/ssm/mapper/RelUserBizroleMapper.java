package com.ssm.mapper;

import com.ssm.pojo.RelUserBizrole;
import com.ssm.pojo.RelUserBizroleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RelUserBizroleMapper {
    int countByExample(RelUserBizroleExample example);

    int deleteByExample(RelUserBizroleExample example);

    int deleteByPrimaryKey(String relUserBizroleUserUuid);

    int insert(RelUserBizrole record);

    int insertSelective(RelUserBizrole record);

    List<RelUserBizrole> selectByExample(RelUserBizroleExample example);

    RelUserBizrole selectByPrimaryKey(String relUserBizroleUserUuid);

    int updateByExampleSelective(@Param("record") RelUserBizrole record, @Param("example") RelUserBizroleExample example);

    int updateByExample(@Param("record") RelUserBizrole record, @Param("example") RelUserBizroleExample example);

    int updateByPrimaryKeySelective(RelUserBizrole record);

    int updateByPrimaryKey(RelUserBizrole record);
}