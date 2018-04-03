package com.ssm.mapper;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.ssm.pojo.Resource;
import com.ssm.pojo.ResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResourceMapper {
    int countByExample(ResourceExample example);

    int deleteByExample(ResourceExample example);

    int deleteByPrimaryKey(String resUuid);

    int insert(Resource record);

    int insertSelective(Resource record);

    List<Resource> selectByExampleWithBLOBs(ResourceExample example);

    List<Resource> selectByExample(ResourceExample example, PageBounds pageBounds);

    Resource selectByPrimaryKey(String resUuid);

    int updateByExampleSelective(@Param("record") Resource record, @Param("example") ResourceExample example);

    int updateByExampleWithBLOBs(@Param("record") Resource record, @Param("example") ResourceExample example);

    int updateByExample(@Param("record") Resource record, @Param("example") ResourceExample example);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKeyWithBLOBs(Resource record);

    int updateByPrimaryKey(Resource record);
}