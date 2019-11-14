package com.haohao.homework;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HWTest1 {

    public static void main(String[] args) throws SchedulerException {

        // job
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_quartz.xml");
        JobDetail jobDetail = (JobDetail) applicationContext.getBean("hwJob1");
        Trigger trigger = (Trigger) applicationContext.getBean("hwSimpleTrigger");

        SchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();

        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
    }
}
