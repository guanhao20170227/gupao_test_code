package com.haohao.homework;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class HWTest1 {

    public static void main(String[] args) throws SchedulerException {

        //job
        JobDetail jobDetail = JobBuilder.newJob(MyJob1.class)
                .withIdentity("my-job-1", "my-group")
                .build();

        //trigger
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("my-trigger-1", "my-group")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                    .withIntervalInSeconds(1)
                    .repeatForever())
                .build();


        SchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();

        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();

    }
}
