package com.ssm.mapper;

import com.ssm.pojo.AccessControlRole;
import com.ssm.pojo.AccessControlRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccessControlRoleMapper {
    int countByExample(AccessControlRoleExample example);

    int deleteByExample(AccessControlRoleExample example);

    int deleteByPrimaryKey(Integer roleCode);

    int insert(AccessControlRole record);

    int insertSelective(AccessControlRole record);

    List<AccessControlRole> selectByExample(AccessControlRoleExample example);

    AccessControlRole selectByPrimaryKey(Integer roleCode);

    int updateByExampleSelective(@Param("record") AccessControlRole record, @Param("example") AccessControlRoleExample example);

    int updateByExample(@Param("record") AccessControlRole record, @Param("example") AccessControlRoleExample example);

    int updateByPrimaryKeySelective(AccessControlRole record);

    int updateByPrimaryKey(AccessControlRole record);
}