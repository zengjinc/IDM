package com.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm.pojo.AccessControlAct;
import com.ssm.pojo.AccessControlActExample;

public interface AccessControlActMapper {
    int countByExample(AccessControlActExample example);

    int deleteByExample(AccessControlActExample example);

    int deleteByPrimaryKey(Integer actCode);

    int insert(AccessControlAct record);

    int insertSelective(AccessControlAct record);

    List<AccessControlAct> selectByExample(AccessControlActExample example);

    AccessControlAct selectByPrimaryKey(Integer actCode);

    int updateByExampleSelective(@Param("record") AccessControlAct record, @Param("example") AccessControlActExample example);

    int updateByExample(@Param("record") AccessControlAct record, @Param("example") AccessControlActExample example);

    int updateByPrimaryKeySelective(AccessControlAct record);

    int updateByPrimaryKey(AccessControlAct record);
}