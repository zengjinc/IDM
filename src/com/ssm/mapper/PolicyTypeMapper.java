package com.ssm.mapper;

import com.ssm.pojo.PolicyType;
import com.ssm.pojo.PolicyTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PolicyTypeMapper {
    int countByExample(PolicyTypeExample example);

    int deleteByExample(PolicyTypeExample example);

    int deleteByPrimaryKey(String polTypeUuid);

    int insert(PolicyType record);

    int insertSelective(PolicyType record);

    List<PolicyType> selectByExample(PolicyTypeExample example);

    PolicyType selectByPrimaryKey(String polTypeUuid);

    int updateByExampleSelective(@Param("record") PolicyType record, @Param("example") PolicyTypeExample example);

    int updateByExample(@Param("record") PolicyType record, @Param("example") PolicyTypeExample example);

    int updateByPrimaryKeySelective(PolicyType record);

    int updateByPrimaryKey(PolicyType record);
}