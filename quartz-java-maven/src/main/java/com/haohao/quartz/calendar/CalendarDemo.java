package com.haohao.quartz.calendar;


import com.haohao.quartz.job.MyJob1;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.AnnualCalendar;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/***
 *  用于来测试: Calendar 来排除某一些日子
 */

public class CalendarDemo {
    public static void main(String[] args) throws SchedulerException {
        SchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();
        scheduler.start();

        // 定义 AnnualCalendar 用于去除一年中的几天;
        AnnualCalendar holidays = new AnnualCalendar();

        // 中秋节 (java.util.Calendar)
        Calendar midAutumn = new GregorianCalendar(2019, 9, 13);
        holidays.setDayExcluded(midAutumn, true);

        // 圣诞节
        Calendar christmas = new GregorianCalendar(2019,12, 25);
        holidays.setDayExcluded(christmas, true);

        // 调度器添加日历
        scheduler.addCalendar("holidays", holidays, false, false);

        // job --> jobDetail
        JobDetail jobDetail = JobBuilder.newJob(MyJob1.class)
                .withIdentity("myjob1", "myjob-group")
                .usingJobData("name", "pie")
                .build();

        // trigger
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("simpleTrigger", "trigger-group")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                    .withIntervalInSeconds(2)
                    //.repeatForever())
                    .withRepeatCount(5))
                .build();

        // scheduler --> jobdetail:trigger
        Date firstRunTime = scheduler.scheduleJob(jobDetail, trigger);
        System.out.println(jobDetail.getKey() + " 第一次触发: " + firstRunTime);

        // 思考：如何循环 5 次后自己关闭 shutdown ？

    }
}
