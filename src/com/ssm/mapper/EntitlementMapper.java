package com.ssm.mapper;

import com.ssm.pojo.Entitlement;
import com.ssm.pojo.EntitlementExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EntitlementMapper {
    int countByExample(EntitlementExample example);

    int deleteByExample(EntitlementExample example);

    int deleteByPrimaryKey(String etmUserUuid);

    int insert(Entitlement record);

    int insertSelective(Entitlement record);

    List<Entitlement> selectByExample(EntitlementExample example);

    Entitlement selectByPrimaryKey(String etmUserUuid);

    int updateByExampleSelective(@Param("record") Entitlement record, @Param("example") EntitlementExample example);

    int updateByExample(@Param("record") Entitlement record, @Param("example") EntitlementExample example);

    int updateByPrimaryKeySelective(Entitlement record);

    int updateByPrimaryKey(Entitlement record);
}