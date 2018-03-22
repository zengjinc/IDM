package com.ssm.mapper;

import com.ssm.pojo.ResourceAttribute;
import com.ssm.pojo.ResourceAttributeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResourceAttributeMapper {
    int countByExample(ResourceAttributeExample example);

    int deleteByExample(ResourceAttributeExample example);

    int deleteByPrimaryKey(String resAttrResUuid);

    int insert(ResourceAttribute record);

    int insertSelective(ResourceAttribute record);

    List<ResourceAttribute> selectByExample(ResourceAttributeExample example);

    ResourceAttribute selectByPrimaryKey(String resAttrResUuid);

    int updateByExampleSelective(@Param("record") ResourceAttribute record, @Param("example") ResourceAttributeExample example);

    int updateByExample(@Param("record") ResourceAttribute record, @Param("example") ResourceAttributeExample example);

    int updateByPrimaryKeySelective(ResourceAttribute record);

    int updateByPrimaryKey(ResourceAttribute record);
}