package com.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm.pojo.ItroleAttribute;
import com.ssm.pojo.ItroleAttributeExample;
import com.ssm.pojo.ItroleAttributeKey;

public interface ItroleAttributeMapper {
    int countByExample(ItroleAttributeExample example);

    int deleteByExample(ItroleAttributeExample example);

    int deleteByPrimaryKey(ItroleAttributeKey key);

    int insert(ItroleAttribute record);

    int insertSelective(ItroleAttribute record);

    List<ItroleAttribute> selectByExample(ItroleAttributeExample example);

    ItroleAttribute selectByPrimaryKey(ItroleAttributeKey key);

    int updateByExampleSelective(@Param("record") ItroleAttribute record, @Param("example") ItroleAttributeExample example);

    int updateByExample(@Param("record") ItroleAttribute record, @Param("example") ItroleAttributeExample example);

    int updateByPrimaryKeySelective(ItroleAttribute record);

    int updateByPrimaryKey(ItroleAttribute record);
}