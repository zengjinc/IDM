package com.ssm.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ssm.shedule.JobManager;
import com.ssm.utils.BeanUtil;

public class TaskListener implements ServletContextListener{  
    private static final Logger logger = LoggerFactory.getLogger(TaskListener.class);
    @Override  
    public void contextDestroyed(ServletContextEvent arg0) {  
        // TODO Auto-generated method stub  
    }  
  
    @Override  
    public void contextInitialized(ServletContextEvent arg0) {  
  
        logger.info("TaskListener", "定时任务初始化");  
        JobManager m = (JobManager) BeanUtil.getBean("jobManager");  
        try {  
            m.initTask();  
        } catch (SchedulerException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
    }  
  
}  
