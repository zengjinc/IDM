package com.ssm.mapper;

import com.ssm.pojo.BusinessRole;
import com.ssm.pojo.BusinessRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BusinessRoleMapper {
    int countByExample(BusinessRoleExample example);

    int deleteByExample(BusinessRoleExample example);

    int deleteByPrimaryKey(String bizRoleUuid);

    int insert(BusinessRole record);

    int insertSelective(BusinessRole record);

    List<BusinessRole> selectByExample(BusinessRoleExample example);

    BusinessRole selectByPrimaryKey(String bizRoleUuid);

    int updateByExampleSelective(@Param("record") BusinessRole record, @Param("example") BusinessRoleExample example);

    int updateByExample(@Param("record") BusinessRole record, @Param("example") BusinessRoleExample example);

    int updateByPrimaryKeySelective(BusinessRole record);

    int updateByPrimaryKey(BusinessRole record);
}