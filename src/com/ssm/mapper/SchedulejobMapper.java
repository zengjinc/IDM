package com.ssm.mapper;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.ssm.pojo.Schedulejob;
import com.ssm.pojo.SchedulejobExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SchedulejobMapper {
    int countByExample(SchedulejobExample example);

    int deleteByExample(SchedulejobExample example);

    int deleteByPrimaryKey(String scdUuid);

    int insert(Schedulejob record);

    int insertSelective(Schedulejob record);

    List<Schedulejob> selectByExampleWithBLOBs(SchedulejobExample example);
    
    List<Schedulejob> selectByExampleWithBLOBs(SchedulejobExample example, PageBounds pageBounds);

    List<Schedulejob> selectByExample(SchedulejobExample example);
    
    List<Schedulejob> selectByExample(SchedulejobExample example, PageBounds pageBounds);

    Schedulejob selectByPrimaryKey(String scdUuid);

    int updateByExampleSelective(@Param("record") Schedulejob record, @Param("example") SchedulejobExample example);

    int updateByExampleWithBLOBs(@Param("record") Schedulejob record, @Param("example") SchedulejobExample example);

    int updateByExample(@Param("record") Schedulejob record, @Param("example") SchedulejobExample example);

    int updateByPrimaryKeySelective(Schedulejob record);

    int updateByPrimaryKeyWithBLOBs(Schedulejob record);

    int updateByPrimaryKey(Schedulejob record);
}