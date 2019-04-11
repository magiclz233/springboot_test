package com.cnpc.scheduler;

import com.cnpc.job.HelloJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloScheduler {

    @Bean
    public JobDetail helloJobDetail(){
        return JobBuilder.newJob( HelloJob.class ).withIdentity( "helloJob" )
                .usingJobData( "name","world" ).storeDurably().build();
    }

    @Bean
    public Trigger helloJobTrigger(){
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds( 2 ).repeatForever();
        return TriggerBuilder.newTrigger().forJob( helloJobDetail() ).withIdentity( "helloTrigger" )
                .withSchedule( scheduleBuilder ).build();
    }
}
