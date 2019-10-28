package com.haohao.jdk.timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @since: 2019-10-28
 * @desc: 用于测试 JDK Timer 实现任务调度
 *
 */
public class JDKTimerTest {
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask task = new MyTimerTask();
        // 5 秒后启动 task, 每隔 2秒 启动一次;
        timer.schedule(task, 5000L, 2000);
    }
}
