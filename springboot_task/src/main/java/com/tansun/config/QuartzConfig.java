package com.tansun.config;

import com.tansun.quzrtz.quartzJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * program: java_daily
 * Created with IntelliJ IDEA.
 * Description:
 * User: mwt
 * Date: 2022/8/8 15:43
 */
@Configuration
public class QuartzConfig {
    @Bean
    public JobDetail CaljobDetail(){
        //绑定对应的JOb

        return JobBuilder.newJob(quartzJob.class).storeDurably().build();
    }
    @Bean
    public Trigger CalTrigger(){
        //每隔两秒
        ScheduleBuilder scheduleBuilder=CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
        //绑定对应的工作明细
        return TriggerBuilder.newTrigger().forJob(CaljobDetail()).withSchedule(scheduleBuilder).build();
    }
}
