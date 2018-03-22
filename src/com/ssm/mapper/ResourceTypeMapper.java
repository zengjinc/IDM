package com.ssm.mapper;

import com.ssm.pojo.ResourceType;
import com.ssm.pojo.ResourceTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResourceTypeMapper {
    int countByExample(ResourceTypeExample example);

    int deleteByExample(ResourceTypeExample example);

    int deleteByPrimaryKey(String resTypeUuid);

    int insert(ResourceType record);

    int insertSelective(ResourceType record);

    List<ResourceType> selectByExample(ResourceTypeExample example);

    ResourceType selectByPrimaryKey(String resTypeUuid);

    int updateByExampleSelective(@Param("record") ResourceType record, @Param("example") ResourceTypeExample example);

    int updateByExample(@Param("record") ResourceType record, @Param("example") ResourceTypeExample example);

    int updateByPrimaryKeySelective(ResourceType record);

    int updateByPrimaryKey(ResourceType record);
}