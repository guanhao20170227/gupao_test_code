package com.haohao.quartz.listener;

import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.TriggerListener;

public class MyTriggerListener implements TriggerListener {

    private String name;
    @Override
    public String getName() {
        return name;
    }

    public MyTriggerListener(String name) {
        this.name = name;
    }

    @Override
    public void triggerFired(Trigger trigger, JobExecutionContext jobExecutionContext) {
        String triggerName = trigger.getKey().getName();
        System.out.println("Method triggerFired: " + triggerName);
    }

    @Override
    public boolean vetoJobExecution(Trigger trigger, JobExecutionContext jobExecutionContext) {
        String triggerName = trigger.getKey().getName();
        System.out.println("Method vetoJobExecution: " + triggerName);
        return false;
    }

    @Override
    public void triggerMisfired(Trigger trigger) {
        String triggerName = trigger.getKey().getName();
        System.out.println("Method triggerMisfired: " + triggerName);
    }

    @Override
    public void triggerComplete(Trigger trigger, JobExecutionContext jobExecutionContext, Trigger.CompletedExecutionInstruction completedExecutionInstruction) {
        String triggerName = trigger.getKey().getName();
        System.out.println("Method triggerComplete: " + triggerName);
    }
}
