package com.ssm.mapper;

import com.ssm.pojo.Ou;
import com.ssm.pojo.OuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OuMapper {
    int countByExample(OuExample example);

    int deleteByExample(OuExample example);

    int deleteByPrimaryKey(String ouUuid);

    int insert(Ou record);

    int insertSelective(Ou record);

    List<Ou> selectByExample(OuExample example);

    Ou selectByPrimaryKey(String ouUuid);

    int updateByExampleSelective(@Param("record") Ou record, @Param("example") OuExample example);

    int updateByExample(@Param("record") Ou record, @Param("example") OuExample example);

    int updateByPrimaryKeySelective(Ou record);

    int updateByPrimaryKey(Ou record);
}