package com.ssm.mapper;

import com.ssm.pojo.PolicyAttribute;
import com.ssm.pojo.PolicyAttributeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PolicyAttributeMapper {
    int countByExample(PolicyAttributeExample example);

    int deleteByExample(PolicyAttributeExample example);

    int deleteByPrimaryKey(String polAttrPolUuid);

    int insert(PolicyAttribute record);

    int insertSelective(PolicyAttribute record);

    List<PolicyAttribute> selectByExample(PolicyAttributeExample example);

    PolicyAttribute selectByPrimaryKey(String polAttrPolUuid);

    int updateByExampleSelective(@Param("record") PolicyAttribute record, @Param("example") PolicyAttributeExample example);

    int updateByExample(@Param("record") PolicyAttribute record, @Param("example") PolicyAttributeExample example);

    int updateByPrimaryKeySelective(PolicyAttribute record);

    int updateByPrimaryKey(PolicyAttribute record);
}