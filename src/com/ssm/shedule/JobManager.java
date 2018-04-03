package com.ssm.shedule;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssm.mapper.SchedulejobMapper;
import com.ssm.pojo.Schedulejob;
import com.ssm.pojo.SchedulejobExample;
import com.ssm.utils.BeanUtil;

public class JobManager {
    private static final Logger logger = LoggerFactory.getLogger(JobManager.class);
    @Autowired
    private SchedulejobMapper schedulejobMapper;
    
    private static SchedulerFactoryBean schedulerFactoryBean;  
    private static Scheduler scheduler;  
    static{  
        schedulerFactoryBean = (SchedulerFactoryBean) BeanUtil.getBeanByClass(SchedulerFactoryBean.class);  
        scheduler = schedulerFactoryBean.getScheduler();  
    }  
    /** 
     * 初始化定时任务 
     * @throws SchedulerException 
     */  
    public void initTask() throws SchedulerException {  
    	SchedulejobExample example = new SchedulejobExample();
    	example.createCriteria().andScdCronIsNotNull().andScdCronNotEqualTo("");
    	List<Schedulejob> jobList = schedulejobMapper.selectByExampleWithBLOBs(example);
        for (Schedulejob job : jobList) {  
        	saveOrUpdateJob(job);  
        }  
    }  
    /** 
     * 添加一个任务 
     * @param job 
     */  
    public void saveOrUpdateJob(Schedulejob job){
    	TriggerKey triggerKey = TriggerKey.triggerKey(job.getScdJobType(), job.getScdJobGroup());  
    	//判断cron是否合法
    	if(isValidExpression(job.getScdCron())){
    		try {  
    			// 获取trigger，即在spring配置文件中定义的 bean id="myTrigger"
    			CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);  
    			// 不存在，创建一个  
    			if (null == trigger) { 
    				//获取任务链
    				List<Schedulejob> taskChain = new ArrayList<>();
    				ObjectMapper mapper = new ObjectMapper();
    	            try {
						JsonNode rootNode = mapper.readTree(job.getScdJsonAttr());
						JsonNode taskChainNode = rootNode.get("taskchainJson");
						Iterator<JsonNode> iterator = taskChainNode.elements();
						while(iterator.hasNext()){
							String taskId = iterator.next().asText();
							SchedulejobExample example = new SchedulejobExample();
							example.createCriteria().andScdIdEqualTo(taskId);
							List<Schedulejob> scdedulejobList = schedulejobMapper.selectByExample(example);
							for(Schedulejob s : scdedulejobList){
								taskChain.add(s);
							}
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    	            
    				JobDetail jobDetail = JobBuilder.newJob(QuartzJobFactory.class)  
    						.withIdentity(job.getScdJobType(), job.getScdJobGroup()).build();  
    				jobDetail.getJobDataMap().put("scheduleJob", job);
    				jobDetail.getJobDataMap().put("taskCain", taskChain);
    				
    				// 表达式调度构建器  
    				CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getScdCron());  
    				// 按新的cronExpression表达式构建一个新的trigger  
    				trigger = TriggerBuilder.newTrigger().withIdentity(job.getScdJobType(), job.getScdJobGroup())  
    						.withSchedule(scheduleBuilder).build();  
					scheduler.scheduleJob(jobDetail, trigger);
    			} else {
    				// Trigger已存在，那么更新相应的定时设置  
    				// 表达式调度构建器  
    				CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getScdCron());  
    				// 按新的cronExpression表达式重新构建trigger  
    				trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();  
    				// 按新的trigger重新设置job执行  
    				scheduler.rescheduleJob(triggerKey, trigger);
    			}  
    			if(job.getScdStatus()==0){  
    				pauseJob(job);  
    			}  
    			
    		} catch (SchedulerException e) {  
    			// TODO Auto-generated catch block  
    			e.printStackTrace();  
    		}  
    	}else{
    		try {
				if(scheduler.checkExists(triggerKey)){
					removeJob(job);
				}
			} catch (SchedulerException e) {
				e.printStackTrace();
			}
    	}
    }  
    /** 
     * 暂停一个job 
     * @param scheduleJob 
     * @throws SchedulerException 
     */  
    public void pauseJob(Schedulejob scheduleJob){  
        //Scheduler scheduler = schedulerFactoryBean.getScheduler();  
        logger.info(scheduleJob.getScdJobType()+"定时任务暂停");  
        JobKey jobKey = JobKey.jobKey(scheduleJob.getScdJobType(), scheduleJob.getScdJobGroup());  
        try {  
            scheduler.pauseJob(jobKey);  
        } catch (SchedulerException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
    }  
    /** 
     * 恢复一个job 
     * @param scheduleJob 
     */  
    public void resumeJob(Schedulejob scheduleJob){  
        logger.info(scheduleJob.getScdJobType()+"定时任务启动");  
        //Scheduler scheduler = schedulerFactoryBean.getScheduler();  
        JobKey jobKey = JobKey.jobKey(scheduleJob.getScdJobType(),scheduleJob.getScdJobGroup());  
        try {  
            scheduler.resumeJob(jobKey);  
        } catch (SchedulerException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
    }  
    /** 
     * 删除一个任务 
     * @param scheduleJob 
     */  
    public void removeJob(Schedulejob job){  
        logger.info(job.getScdJobType()+"删除定时任务");  
        TriggerKey triggerKey = TriggerKey.triggerKey(job.getScdJobType(), job.getScdJobGroup());  
        JobKey jobKey = JobKey.jobKey(job.getScdJobType(),job.getScdJobGroup());  
        // 获取trigger，即在spring配置文件中定义的 bean id="myTrigger"  
        //CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);  
        try {  
            scheduler.pauseTrigger(triggerKey);  
            scheduler.unscheduleJob(triggerKey);  
            scheduler.deleteJob(jobKey);  
        } catch (SchedulerException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
    }
    
    public static boolean isValidExpression(final String cronExpression){
        CronTriggerImpl trigger = new CronTriggerImpl();
        try {
            trigger.setCronExpression(cronExpression);
            Date date = trigger.computeFirstFireTime(null);
            return date != null;
        } catch (Exception e) {
        	logger.error("error cron expression : " + cronExpression);
            logger.error("[isValidExpression]:failed. throw ex:" , e);
        }
        return false;
    }
    
    public static Date getNextRunTime(final String cronExpression){
    	CronTriggerImpl trigger = new CronTriggerImpl();
        try {
            trigger.setCronExpression(cronExpression);
            Date date = trigger.computeFirstFireTime(null);
            if(date != null){
            	Date nextFireTime = trigger.getFireTimeAfter(new Date());
            	return nextFireTime;
            }
        } catch (Exception e) {
        	logger.error("error cron expression : " + cronExpression);
            logger.error("[isValidExpression]:failed. throw ex:" , e);
        }
    	return null;
    }
    
}  
