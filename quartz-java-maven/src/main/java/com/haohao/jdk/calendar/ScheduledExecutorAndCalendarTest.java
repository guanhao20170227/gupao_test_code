package com.haohao.jdk.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.SimpleFormatter;

/***
 *  使用 ScheduledExecutor 和 Calendar 实现 复杂的任务调度
 *
 *  eg: 实现 每周二 16:38:10 执行任务;
 */

public class ScheduledExecutorAndCalendarTest extends TimerTask {

    private String jobName = "";

    public ScheduledExecutorAndCalendarTest(String jobName) {
        this.jobName = jobName;
    }

    // 获取下一次执行 任务的时间
    public Calendar getLastTimeDate(Calendar currentTime, Integer
                                    dayOfWeek, Integer hourOfDay, Integer minuteOfHour, Integer secondOfMinute) {
        int currentWeekOfYear = currentTime.get(Calendar.WEEK_OF_YEAR);
        int currentDayOfWeek = currentTime.get(Calendar.DAY_OF_WEEK);
        int currentHour = currentTime.get(Calendar.HOUR_OF_DAY);
        int currentMinute = currentTime.get(Calendar.MINUTE);
        int currentSecond = currentTime.get(Calendar.SECOND);

        // 用于判断 输入的周时间 是否 小于当前时间, 小于为 true, 大于为 false;
        /**
         * SUNDAY-1, MONDAY-2, TUESDAY-3, WEDNESDAY-4, THURSDAY-5, FRIDAY-6, SATURDAY-7
         */
        boolean weekLater = false;
        if (dayOfWeek < currentDayOfWeek) {
            weekLater = true;
        } else if (dayOfWeek == currentDayOfWeek) {
            if (hourOfDay < currentHour) {
                weekLater = true;
            } else if (hourOfDay == currentHour) {
                if (minuteOfHour < currentMinute) {
                    weekLater = true;
                } else if (minuteOfHour == currentMinute) {
                    if (secondOfMinute < currentSecond) {
                        weekLater = true;
                    }
                }
            }
        }

        if (weekLater) {
            currentTime.set(Calendar.WEEK_OF_YEAR, currentWeekOfYear + 1);
        }

        currentTime.set(Calendar.DAY_OF_WEEK, dayOfWeek);
        currentTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
        currentTime.set(Calendar.MINUTE, minuteOfHour);
        currentTime.set(Calendar.SECOND, secondOfMinute);

        return currentTime;

    }


    public static void main(String[] args) {
        ScheduledExecutorAndCalendarTest test = new ScheduledExecutorAndCalendarTest("jobTest");

        // 获取当前时间;
        Calendar currentTime = Calendar.getInstance();
        long currentTimeLong = currentTime.getTime().getTime();
        System.out.println("Current Time: " + currentTime.getTime().toString());
        Calendar doJobTime = test.getLastTimeDate(currentTime, Calendar.TUESDAY, 10, 58, 40);

        long doJobTimeLong = doJobTime.getTime().getTime();
        System.out.println("最近一次将要执行任务的时间: " + doJobTimeLong);
        String doJobTimeStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(doJobTimeLong));
        System.out.println("最近一次将要执行任务的时间: " + doJobTimeStr);

        long delay = doJobTimeLong - currentTimeLong; // 毫秒
        System.out.println("将要等待的时间: " + delay);
        String delayTimeStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(delay));
        long period = 7 * 24 * 60 * 60 * 1000; // 毫秒

        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
        //
        service.scheduleAtFixedRate(test, delay, period, TimeUnit.MILLISECONDS);
    }


    @Override
    public void run() {
        System.out.println("Just do it.");
    }
}
