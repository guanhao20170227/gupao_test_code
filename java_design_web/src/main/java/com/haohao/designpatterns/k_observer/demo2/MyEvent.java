package com.haohao.designpatterns.k_observer.demo2;

import java.lang.reflect.Method;

public class MyEvent {

    private Object source; // 事件源, 事件是由谁发起的;
    private Object target; // 事件触发, 要通知谁;
    private Method callback; // 事件触发要什么动作, 回调;
    private String trigger; // 事件的名称, 触发的是什么事件;
    private long time; // 事件触发的时间

    public MyEvent(Object target, Method callback) {
        this.target = target;
        this.callback = callback;
    }

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Method getCallback() {
        return callback;
    }

    public void setCallback(Method callback) {
        this.callback = callback;
    }

    public String getTrigger() {
        return trigger;
    }

    public void setTrigger(String trigger) {
        this.trigger = trigger;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "MyEvent{" +
                "source=" + source +
                ", target=" + target +
                ", callback=" + callback +
                ", trigger='" + trigger + '\'' +
                ", time=" + time +
                '}';
    }
}
