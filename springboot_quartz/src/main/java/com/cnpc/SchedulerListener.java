package com.cnpc;

import com.cnpc.scheduler.CronSchedulerJob;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Configuration
@EnableScheduling
@Component
public class SchedulerListener {  
      
    @Autowired
    public CronSchedulerJob scheduleJobs;
      
    @Scheduled(cron="0 3 10 11 4 ?")
    public void schedule() throws SchedulerException {
        scheduleJobs.scheduleJobs();
     }   
      
}