package com.ssm.shedule;

import java.util.Date;
import java.util.List;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ssm.pojo.Schedulejob;
import com.ssm.service.TaskService;
import com.ssm.utils.BeanUtil;

@DisallowConcurrentExecution //只有上一个人任务执行完毕才可以执行下一次任务  
public class QuartzJobFactory implements Job{  
    private static final Logger logger = LoggerFactory.getLogger(QuartzJobFactory.class);
    @Override
    public void execute(JobExecutionContext context){ 
        try{  
        	Schedulejob schedulejob = (Schedulejob)context.getMergedJobDataMap().get("scheduleJob");
            List<Schedulejob> taskChain = (List<Schedulejob>)context.getMergedJobDataMap().get("taskChain");
            logger.info("schedule job " + schedulejob.getScdJobType() + " started.");  
            BaseScheduleJob baseScheduleJob = (BaseScheduleJob)BeanUtil.getBean(schedulejob.getScdJobType());
            baseScheduleJob.setSchedulejob(schedulejob);
            ((TaskService)baseScheduleJob).exec();
            //执行任务链
            if(taskChain != null && taskChain.size() > 0){
            	for(Schedulejob s : taskChain){
            		BaseScheduleJob tempBaseScheduleJob = (BaseScheduleJob)BeanUtil.getBean(s.getScdJobType());
            		tempBaseScheduleJob.setSchedulejob(s);
            		((TaskService)tempBaseScheduleJob).exec();
            	}
            }
            logger.info("schedule job " + schedulejob.getScdJobType() + " ended.");  
        }catch(Exception e){  
            e.printStackTrace();  
        }  
    }  
  
}  
