package com.ssm.mapper;

import com.ssm.pojo.AccessControlPerm;
import com.ssm.pojo.AccessControlPermExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccessControlPermMapper {
    int countByExample(AccessControlPermExample example);

    int deleteByExample(AccessControlPermExample example);

    int deleteByPrimaryKey(Integer roleCode);

    int insert(AccessControlPerm record);

    int insertSelective(AccessControlPerm record);

    List<AccessControlPerm> selectByExample(AccessControlPermExample example);

    AccessControlPerm selectByPrimaryKey(Integer roleCode);

    int updateByExampleSelective(@Param("record") AccessControlPerm record, @Param("example") AccessControlPermExample example);

    int updateByExample(@Param("record") AccessControlPerm record, @Param("example") AccessControlPermExample example);

    int updateByPrimaryKeySelective(AccessControlPerm record);

    int updateByPrimaryKey(AccessControlPerm record);
}