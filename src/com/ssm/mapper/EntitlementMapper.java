package com.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.ssm.pojo.Entitlement;
import com.ssm.pojo.EntitlementExample;
import com.ssm.pojo.EntitlementKey;
import com.ssm.pojo.to.EntitlementTo;

public interface EntitlementMapper {
    int countByExample(EntitlementExample example);

    int deleteByExample(EntitlementExample example);

    int deleteByPrimaryKey(EntitlementKey key);

    int insert(Entitlement record);

    int insertSelective(Entitlement record);

    List<Entitlement> selectByExample(EntitlementExample example);
    
    List<EntitlementTo> getEntitlementByUserUuid(String userUuid,PageBounds pageBounds);

    Entitlement selectByPrimaryKey(EntitlementKey key);

    int updateByExampleSelective(@Param("record") Entitlement record, @Param("example") EntitlementExample example);

    int updateByExample(@Param("record") Entitlement record, @Param("example") EntitlementExample example);

    int updateByPrimaryKeySelective(Entitlement record);

    int updateByPrimaryKey(Entitlement record);
}