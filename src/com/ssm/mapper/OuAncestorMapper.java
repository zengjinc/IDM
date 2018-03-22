package com.ssm.mapper;

import com.ssm.pojo.OuAncestor;
import com.ssm.pojo.OuAncestorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OuAncestorMapper {
    int countByExample(OuAncestorExample example);

    int deleteByExample(OuAncestorExample example);

    int deleteByPrimaryKey(String ouDescendent);

    int insert(OuAncestor record);

    int insertSelective(OuAncestor record);

    List<OuAncestor> selectByExample(OuAncestorExample example);

    OuAncestor selectByPrimaryKey(String ouDescendent);

    int updateByExampleSelective(@Param("record") OuAncestor record, @Param("example") OuAncestorExample example);

    int updateByExample(@Param("record") OuAncestor record, @Param("example") OuAncestorExample example);

    int updateByPrimaryKeySelective(OuAncestor record);

    int updateByPrimaryKey(OuAncestor record);
}