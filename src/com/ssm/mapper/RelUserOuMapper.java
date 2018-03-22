package com.ssm.mapper;

import com.ssm.pojo.RelUserOu;
import com.ssm.pojo.RelUserOuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RelUserOuMapper {
    int countByExample(RelUserOuExample example);

    int deleteByExample(RelUserOuExample example);

    int deleteByPrimaryKey(String relUserOuUserUuid);

    int insert(RelUserOu record);

    int insertSelective(RelUserOu record);

    List<RelUserOu> selectByExample(RelUserOuExample example);

    RelUserOu selectByPrimaryKey(String relUserOuUserUuid);

    int updateByExampleSelective(@Param("record") RelUserOu record, @Param("example") RelUserOuExample example);

    int updateByExample(@Param("record") RelUserOu record, @Param("example") RelUserOuExample example);

    int updateByPrimaryKeySelective(RelUserOu record);

    int updateByPrimaryKey(RelUserOu record);
}