package com.ssm.mapper;

import com.ssm.pojo.ItroleAttribute;
import com.ssm.pojo.ItroleAttributeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItroleAttributeMapper {
    int countByExample(ItroleAttributeExample example);

    int deleteByExample(ItroleAttributeExample example);

    int deleteByPrimaryKey(String itroleAttrItroleUuid);

    int insert(ItroleAttribute record);

    int insertSelective(ItroleAttribute record);

    List<ItroleAttribute> selectByExample(ItroleAttributeExample example);

    ItroleAttribute selectByPrimaryKey(String itroleAttrItroleUuid);

    int updateByExampleSelective(@Param("record") ItroleAttribute record, @Param("example") ItroleAttributeExample example);

    int updateByExample(@Param("record") ItroleAttribute record, @Param("example") ItroleAttributeExample example);

    int updateByPrimaryKeySelective(ItroleAttribute record);

    int updateByPrimaryKey(ItroleAttribute record);
}