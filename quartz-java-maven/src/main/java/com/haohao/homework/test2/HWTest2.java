package com.haohao.homework.test2;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class HWTest2 {
    public static void main(String[] args) throws SchedulerException {

        JobDetail aJobDetail = JobBuilder.newJob(AJob.class)
                .withIdentity("ajob", "my-group")
                .build();
        JobDetail bJobDetail = JobBuilder.newJob(BJob.class)
                .withIdentity("bjob", "my-group")
                .build();
        JobDetail cJobDetail = JobBuilder.newJob(CJob.class)
                .withIdentity("cjob", "my-group")
                .build();

        Trigger aTrigger = TriggerBuilder.newTrigger()
                .withIdentity("atrigger", "my-group")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                    .withIntervalInSeconds(1)
                    .repeatForever())
                .build();

        Trigger bTrigger = TriggerBuilder.newTrigger()
                .withIdentity("btrigger", "my-group")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(2)
                        .repeatForever())
                .build();

        Trigger cTrigger = TriggerBuilder.newTrigger()
                .withIdentity("ctrigger", "my-group")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(3)
                        .repeatForever())
                .build();

        SchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();

        scheduler.scheduleJob(aJobDetail, aTrigger);
        scheduler.scheduleJob(bJobDetail, bTrigger);
        scheduler.scheduleJob(cJobDetail, cTrigger);

        scheduler.start();

    }
}
