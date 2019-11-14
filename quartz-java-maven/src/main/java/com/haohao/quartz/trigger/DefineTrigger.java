package com.haohao.quartz.trigger;

import org.quartz.*;

/***
 * 这里用来定义 四种常用的 Trigger 接口
 */

public class DefineTrigger {

    public static void main(String[] args) {

        // SimpleTrigger
        Trigger simpleTrigger = TriggerBuilder.newTrigger()
                // name + group 是唯一标识符;
                .withIdentity("simpleTrigger", "trigger-group")
                // 加入 scheduler 之后立即执行;
                .startNow()
                //
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()//
                    .withIntervalInSeconds(1)// 1 秒钟执行一次
                    .repeatForever())// 一直重复的执行
                .build();

        // CalendarIntervalTrigger
        Trigger calendarIntervalTrigger = TriggerBuilder.newTrigger()
                // 唯一标识符
                .withIdentity("calendarIntervalTrigger","trigger-group")
                // 一加入 scheduler 就执行
                .startNow()
                //
                .withSchedule(CalendarIntervalScheduleBuilder.calendarIntervalSchedule()
                    .withIntervalInDays(1)) // 每天执行一次
                .build();

        // DailyTimeIntervalTrigger
        Trigger dailyTimeIntervalTrigger = TriggerBuilder.newTrigger()
                .withIdentity("dailyTimeIntervalTrigger", "trigger-group")
                .startNow()
                .withSchedule(DailyTimeIntervalScheduleBuilder.dailyTimeIntervalSchedule()
                        // 每天 9 点开始
                    .startingDailyAt(TimeOfDay.hourAndMinuteOfDay(9,0))
                        // 每天 16 点结束
                    .endingDailyAt(TimeOfDay.hourAndMinuteOfDay(16, 0))
                        // 周一到周五, 才会执行;
                    .onDaysOfTheWeek(1, 2, 3, 4, 5)
                        // 每间隔一小时执行一次
                    .withIntervalInHours(1)
                        // 最多重复 100 次(实际执行 100 + 1 次)
                    .withRepeatCount(100))
                .build();

        // CronTrigger
        Trigger cronTrigger = TriggerBuilder.newTrigger()
                .withIdentity("cronTrigger","trigger-group")
                .startNow()
                // 每秒钟 触发一次任务;
                .withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ? * "))
                .build();

    }


}
