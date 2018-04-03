package com.ssm.mapper;

import com.ssm.pojo.RelUserOuExample;
import com.ssm.pojo.RelUserOuKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RelUserOuMapper {
    int countByExample(RelUserOuExample example);

    int deleteByExample(RelUserOuExample example);

    int deleteByPrimaryKey(RelUserOuKey key);

    int insert(RelUserOuKey record);

    int insertSelective(RelUserOuKey record);

    List<RelUserOuKey> selectByExample(RelUserOuExample example);

    int updateByExampleSelective(@Param("record") RelUserOuKey record, @Param("example") RelUserOuExample example);

    int updateByExample(@Param("record") RelUserOuKey record, @Param("example") RelUserOuExample example);
}