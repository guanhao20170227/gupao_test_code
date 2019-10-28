package com.haohao.jdk.timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask {
    @Override
    public void run() {
        Date executeTime = new Date(this.scheduledExecutionTime());
        String dateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.println("Task cost time: " + dateStr);
    }
}
