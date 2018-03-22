package com.ssm.mapper;

import com.ssm.pojo.UserAttrDef;
import com.ssm.pojo.UserAttrDefExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAttrDefMapper {
    int countByExample(UserAttrDefExample example);

    int deleteByExample(UserAttrDefExample example);

    int deleteByPrimaryKey(String userAttrDefUuid);

    int insert(UserAttrDef record);

    int insertSelective(UserAttrDef record);

    List<UserAttrDef> selectByExample(UserAttrDefExample example);

    UserAttrDef selectByPrimaryKey(String userAttrDefUuid);

    int updateByExampleSelective(@Param("record") UserAttrDef record, @Param("example") UserAttrDefExample example);

    int updateByExample(@Param("record") UserAttrDef record, @Param("example") UserAttrDefExample example);

    int updateByPrimaryKeySelective(UserAttrDef record);

    int updateByPrimaryKey(UserAttrDef record);
}