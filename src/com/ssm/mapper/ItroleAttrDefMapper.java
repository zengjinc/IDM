package com.ssm.mapper;

import com.ssm.pojo.ItroleAttrDef;
import com.ssm.pojo.ItroleAttrDefExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItroleAttrDefMapper {
    int countByExample(ItroleAttrDefExample example);

    int deleteByExample(ItroleAttrDefExample example);

    int deleteByPrimaryKey(String itroleAttrDefKey);

    int insert(ItroleAttrDef record);

    int insertSelective(ItroleAttrDef record);

    List<ItroleAttrDef> selectByExample(ItroleAttrDefExample example);

    ItroleAttrDef selectByPrimaryKey(String itroleAttrDefKey);

    int updateByExampleSelective(@Param("record") ItroleAttrDef record, @Param("example") ItroleAttrDefExample example);

    int updateByExample(@Param("record") ItroleAttrDef record, @Param("example") ItroleAttrDefExample example);

    int updateByPrimaryKeySelective(ItroleAttrDef record);

    int updateByPrimaryKey(ItroleAttrDef record);
}