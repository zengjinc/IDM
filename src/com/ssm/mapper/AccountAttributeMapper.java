package com.ssm.mapper;

import com.ssm.pojo.AccountAttribute;
import com.ssm.pojo.AccountAttributeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccountAttributeMapper {
    int countByExample(AccountAttributeExample example);

    int deleteByExample(AccountAttributeExample example);

    int deleteByPrimaryKey(String acctAttrAcctUuid);

    int insert(AccountAttribute record);

    int insertSelective(AccountAttribute record);

    List<AccountAttribute> selectByExample(AccountAttributeExample example);

    AccountAttribute selectByPrimaryKey(String acctAttrAcctUuid);

    int updateByExampleSelective(@Param("record") AccountAttribute record, @Param("example") AccountAttributeExample example);

    int updateByExample(@Param("record") AccountAttribute record, @Param("example") AccountAttributeExample example);

    int updateByPrimaryKeySelective(AccountAttribute record);

    int updateByPrimaryKey(AccountAttribute record);
}