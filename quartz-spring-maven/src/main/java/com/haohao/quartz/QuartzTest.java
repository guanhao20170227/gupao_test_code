package com.haohao.quartz;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QuartzTest {

    private static Scheduler scheduler;

    public static void main(String[] args) throws SchedulerException {
        // 注释为了 测试 homework 的作业
        /*// 获取 spring 容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_quartz.xml");

        // 获取调度器
        scheduler = (Scheduler) applicationContext.getBean("scheduler");

        // 启动
        scheduler.start();
*/
    }
}
