package com.ssm.mapper;

import com.ssm.pojo.OuAttrDef;
import com.ssm.pojo.OuAttrDefExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OuAttrDefMapper {
    int countByExample(OuAttrDefExample example);

    int deleteByExample(OuAttrDefExample example);

    int deleteByPrimaryKey(String ouAttrDefUuid);

    int insert(OuAttrDef record);

    int insertSelective(OuAttrDef record);

    List<OuAttrDef> selectByExample(OuAttrDefExample example);

    OuAttrDef selectByPrimaryKey(String ouAttrDefUuid);

    int updateByExampleSelective(@Param("record") OuAttrDef record, @Param("example") OuAttrDefExample example);

    int updateByExample(@Param("record") OuAttrDef record, @Param("example") OuAttrDefExample example);

    int updateByPrimaryKeySelective(OuAttrDef record);

    int updateByPrimaryKey(OuAttrDef record);
}