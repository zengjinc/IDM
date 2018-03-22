package com.ssm.mapper;

import com.ssm.pojo.AccessControlObj;
import com.ssm.pojo.AccessControlObjExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccessControlObjMapper {
    int countByExample(AccessControlObjExample example);

    int deleteByExample(AccessControlObjExample example);

    int deleteByPrimaryKey(Integer objCode);

    int insert(AccessControlObj record);

    int insertSelective(AccessControlObj record);

    List<AccessControlObj> selectByExample(AccessControlObjExample example);

    AccessControlObj selectByPrimaryKey(Integer objCode);

    int updateByExampleSelective(@Param("record") AccessControlObj record, @Param("example") AccessControlObjExample example);

    int updateByExample(@Param("record") AccessControlObj record, @Param("example") AccessControlObjExample example);

    int updateByPrimaryKeySelective(AccessControlObj record);

    int updateByPrimaryKey(AccessControlObj record);
}