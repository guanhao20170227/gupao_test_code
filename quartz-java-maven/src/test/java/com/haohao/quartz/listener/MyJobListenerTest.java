package com.haohao.quartz.listener;

import com.haohao.quartz.job.MyJob1;
import org.junit.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.EverythingMatcher;

public class MyJobListenerTest {

    private MyJobListener myJobListener = new MyJobListener();

    @Test
    public void testGetName() {
        String name = myJobListener.getName();
        System.out.println("Name: " + name);
    }

    // Test JobListener
    @Test
    public void testMyJobListener() throws SchedulerException {

        // job
        JobDetail jobDetail = JobBuilder.newJob(MyJob1.class)
                .withIdentity("myjob1", "myjob1-group")
                .build();

        // trigger
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "trigger1-group")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                    .withIntervalInSeconds(2)
                    .repeatForever())
                .build();

        // scheduler
        SchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();

        // 绑定 job, trigger
        scheduler.scheduleJob(jobDetail, trigger);

        // 添加监听:
        scheduler.getListenerManager().addJobListener(new MyJobListener(),
                EverythingMatcher.allJobs());

        scheduler.start();




    }
}
