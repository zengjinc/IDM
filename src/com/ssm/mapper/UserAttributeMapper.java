package com.ssm.mapper;

import com.ssm.pojo.UserAttribute;
import com.ssm.pojo.UserAttributeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAttributeMapper {
    int countByExample(UserAttributeExample example);

    int deleteByExample(UserAttributeExample example);

    int deleteByPrimaryKey(String userAttrUuid);

    int insert(UserAttribute record);

    int insertSelective(UserAttribute record);

    List<UserAttribute> selectByExample(UserAttributeExample example);

    UserAttribute selectByPrimaryKey(String userAttrUuid);

    int updateByExampleSelective(@Param("record") UserAttribute record, @Param("example") UserAttributeExample example);

    int updateByExample(@Param("record") UserAttribute record, @Param("example") UserAttributeExample example);

    int updateByPrimaryKeySelective(UserAttribute record);

    int updateByPrimaryKey(UserAttribute record);
}