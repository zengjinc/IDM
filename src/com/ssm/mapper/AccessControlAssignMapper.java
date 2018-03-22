package com.ssm.mapper;

import com.ssm.pojo.AccessControlAssign;
import com.ssm.pojo.AccessControlAssignExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccessControlAssignMapper {
    int countByExample(AccessControlAssignExample example);

    int deleteByExample(AccessControlAssignExample example);

    int deleteByPrimaryKey(String assgUserUuid);

    int insert(AccessControlAssign record);

    int insertSelective(AccessControlAssign record);

    List<AccessControlAssign> selectByExample(AccessControlAssignExample example);

    AccessControlAssign selectByPrimaryKey(String assgUserUuid);

    int updateByExampleSelective(@Param("record") AccessControlAssign record, @Param("example") AccessControlAssignExample example);

    int updateByExample(@Param("record") AccessControlAssign record, @Param("example") AccessControlAssignExample example);

    int updateByPrimaryKeySelective(AccessControlAssign record);

    int updateByPrimaryKey(AccessControlAssign record);
}