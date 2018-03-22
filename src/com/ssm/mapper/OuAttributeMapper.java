package com.ssm.mapper;

import com.ssm.pojo.OuAttribute;
import com.ssm.pojo.OuAttributeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OuAttributeMapper {
    int countByExample(OuAttributeExample example);

    int deleteByExample(OuAttributeExample example);

    int deleteByPrimaryKey(String ouAttrUuid);

    int insert(OuAttribute record);

    int insertSelective(OuAttribute record);

    List<OuAttribute> selectByExample(OuAttributeExample example);

    OuAttribute selectByPrimaryKey(String ouAttrUuid);

    int updateByExampleSelective(@Param("record") OuAttribute record, @Param("example") OuAttributeExample example);

    int updateByExample(@Param("record") OuAttribute record, @Param("example") OuAttributeExample example);

    int updateByPrimaryKeySelective(OuAttribute record);

    int updateByPrimaryKey(OuAttribute record);
}