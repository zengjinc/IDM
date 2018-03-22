package com.ssm.mapper;

import com.ssm.pojo.AccessControlScope;
import com.ssm.pojo.AccessControlScopeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccessControlScopeMapper {
    int countByExample(AccessControlScopeExample example);

    int deleteByExample(AccessControlScopeExample example);

    int deleteByPrimaryKey(Integer scpCode);

    int insert(AccessControlScope record);

    int insertSelective(AccessControlScope record);

    List<AccessControlScope> selectByExample(AccessControlScopeExample example);

    AccessControlScope selectByPrimaryKey(Integer scpCode);

    int updateByExampleSelective(@Param("record") AccessControlScope record, @Param("example") AccessControlScopeExample example);

    int updateByExample(@Param("record") AccessControlScope record, @Param("example") AccessControlScopeExample example);

    int updateByPrimaryKeySelective(AccessControlScope record);

    int updateByPrimaryKey(AccessControlScope record);
}