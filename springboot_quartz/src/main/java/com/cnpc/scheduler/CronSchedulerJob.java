package com.cnpc.scheduler;

import com.cnpc.job.Scheduler2Job;
import com.cnpc.job.SchedulerJob;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

@Component
public class CronSchedulerJob {

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    public void scheduleJobs() throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        scheduleJob1( scheduler );
        scheduleJob2( scheduler );
    }

    public void scheduleJob1(Scheduler scheduler) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob( SchedulerJob.class ).withIdentity( "job1","group1" ).build();
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule( "0/6 * * * * ?" );
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity( "trigger1","group1" )
                .withSchedule( scheduleBuilder ).build();
        scheduler.scheduleJob( jobDetail,trigger );
    }

    private void scheduleJob2(Scheduler scheduler) throws SchedulerException{
        JobDetail jobDetail = JobBuilder.newJob( Scheduler2Job.class) .withIdentity("job2", "group2").build();
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/12 * * * * ?");
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger2", "group2") .withSchedule(scheduleBuilder).build();
        scheduler.scheduleJob(jobDetail,cronTrigger);
    }
}
