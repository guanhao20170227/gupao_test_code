package com.haohao.quartz.listener;

import com.haohao.quartz.job.MyJob1;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.EverythingMatcher;
import org.quartz.impl.matchers.GroupMatcher;
import org.quartz.impl.matchers.KeyMatcher;

public class MyTriggerListenerTest {

    public static void main(String[] args) throws SchedulerException {
        testMyTriggerListener();
    }

    public static void testMyTriggerListener() throws SchedulerException {
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

        // 创建并注册一个全局的Trigger Listener
        scheduler.getListenerManager().addTriggerListener(new MyTriggerListener("myListener1"), EverythingMatcher.allTriggers());

        // 创建并注册一个局部的Trigger Listener
        scheduler.getListenerManager().addTriggerListener(new MyTriggerListener("myListener2"), KeyMatcher.keyEquals(TriggerKey.triggerKey("trigger1", "gourp1")));


        GroupMatcher matcher = GroupMatcher.triggerGroupEquals("trigger1-group");
        scheduler.getListenerManager().addTriggerListener(new MyTriggerListener("trigger-name-3"), matcher);

        scheduler.start();



    }
}
