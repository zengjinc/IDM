package com.ssm.pojo;

import com.ssm.pojo.SchedulejobAttribute;
import com.ssm.pojo.SchedulejobAttributeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SchedulejobAttributeMapper {
    int countByExample(SchedulejobAttributeExample example);

    int deleteByExample(SchedulejobAttributeExample example);

    int deleteByPrimaryKey(String scdAttrScdUuid);

    int insert(SchedulejobAttribute record);

    int insertSelective(SchedulejobAttribute record);

    List<SchedulejobAttribute> selectByExample(SchedulejobAttributeExample example);

    SchedulejobAttribute selectByPrimaryKey(String scdAttrScdUuid);

    int updateByExampleSelective(@Param("record") SchedulejobAttribute record, @Param("example") SchedulejobAttributeExample example);

    int updateByExample(@Param("record") SchedulejobAttribute record, @Param("example") SchedulejobAttributeExample example);

    int updateByPrimaryKeySelective(SchedulejobAttribute record);

    int updateByPrimaryKey(SchedulejobAttribute record);
}