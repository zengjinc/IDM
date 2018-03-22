package com.ssm.mapper;

import com.ssm.pojo.Itrole;
import com.ssm.pojo.ItroleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItroleMapper {
    int countByExample(ItroleExample example);

    int deleteByExample(ItroleExample example);

    int deleteByPrimaryKey(String itroleUuid);

    int insert(Itrole record);

    int insertSelective(Itrole record);

    List<Itrole> selectByExample(ItroleExample example);

    Itrole selectByPrimaryKey(String itroleUuid);

    int updateByExampleSelective(@Param("record") Itrole record, @Param("example") ItroleExample example);

    int updateByExample(@Param("record") Itrole record, @Param("example") ItroleExample example);

    int updateByPrimaryKeySelective(Itrole record);

    int updateByPrimaryKey(Itrole record);
}