package com.ssm.mapper;

import com.ssm.pojo.AccessControlRule;
import com.ssm.pojo.AccessControlRuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccessControlRuleMapper {
    int countByExample(AccessControlRuleExample example);

    int deleteByExample(AccessControlRuleExample example);

    int deleteByPrimaryKey(Integer ruleCode);

    int insert(AccessControlRule record);

    int insertSelective(AccessControlRule record);

    List<AccessControlRule> selectByExample(AccessControlRuleExample example);

    AccessControlRule selectByPrimaryKey(Integer ruleCode);

    int updateByExampleSelective(@Param("record") AccessControlRule record, @Param("example") AccessControlRuleExample example);

    int updateByExample(@Param("record") AccessControlRule record, @Param("example") AccessControlRuleExample example);

    int updateByPrimaryKeySelective(AccessControlRule record);

    int updateByPrimaryKey(AccessControlRule record);
}