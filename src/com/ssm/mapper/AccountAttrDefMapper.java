package com.ssm.mapper;

import com.ssm.pojo.AccountAttrDef;
import com.ssm.pojo.AccountAttrDefExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccountAttrDefMapper {
    int countByExample(AccountAttrDefExample example);

    int deleteByExample(AccountAttrDefExample example);

    int deleteByPrimaryKey(String acctAttrDefKey);

    int insert(AccountAttrDef record);

    int insertSelective(AccountAttrDef record);

    List<AccountAttrDef> selectByExample(AccountAttrDefExample example);

    AccountAttrDef selectByPrimaryKey(String acctAttrDefKey);

    int updateByExampleSelective(@Param("record") AccountAttrDef record, @Param("example") AccountAttrDefExample example);

    int updateByExample(@Param("record") AccountAttrDef record, @Param("example") AccountAttrDefExample example);

    int updateByPrimaryKeySelective(AccountAttrDef record);

    int updateByPrimaryKey(AccountAttrDef record);
}