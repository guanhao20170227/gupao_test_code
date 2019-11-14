package com.haohao.quartz.simpledemo;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.concurrent.TimeUnit;

public class QuartzTest {

    public static void main(String[] args) throws InterruptedException, SchedulerException {
        // 调度器:
        StdSchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();

        // 具体执行的类
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
                .withIdentity("job1","group1")
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "triggerGroup1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(1)
                        .repeatForever())
                .build();

        scheduler.scheduleJob(jobDetail, trigger);
        System.out.println("--------------scheduler start !---------------------");
        scheduler.start();

        //
        TimeUnit.SECONDS.sleep(5);
        scheduler.shutdown();
        System.out.println("--------------scheduler shutdown !---------------------");
    }
}
