package com.ssm.mapper;

import com.ssm.pojo.Policy;
import com.ssm.pojo.PolicyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PolicyMapper {
    int countByExample(PolicyExample example);

    int deleteByExample(PolicyExample example);

    int deleteByPrimaryKey(String polUuid);

    int insert(Policy record);

    int insertSelective(Policy record);

    List<Policy> selectByExample(PolicyExample example);

    Policy selectByPrimaryKey(String polUuid);

    int updateByExampleSelective(@Param("record") Policy record, @Param("example") PolicyExample example);

    int updateByExample(@Param("record") Policy record, @Param("example") PolicyExample example);

    int updateByPrimaryKeySelective(Policy record);

    int updateByPrimaryKey(Policy record);
}