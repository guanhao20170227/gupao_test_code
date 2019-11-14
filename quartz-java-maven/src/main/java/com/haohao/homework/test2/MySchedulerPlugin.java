package com.haohao.homework.test2;

import org.quartz.*;
import org.quartz.spi.ClassLoadHelper;
import org.quartz.spi.SchedulerPlugin;

public class MySchedulerPlugin implements SchedulerPlugin, JobListener {

    private String name;
    private Scheduler scheduler;

    private String AJob;

    // 2
    @Override
    public void initialize(String name, Scheduler scheduler, ClassLoadHelper classLoadHelper) throws SchedulerException {
        System.out.println("initialize");
        this.name = name;
        this.scheduler = scheduler;
        scheduler.getListenerManager().addJobListener(this);
        scheduler.getContext().put(name, this);
    }

    //4
    @Override
    public void start() {
        System.out.println("start");
    }

    //
    @Override
    public void shutdown() {
        System.out.println("shutdown");
    }

    // down are listener.

    //3  5
    @Override
    public String getName() {
        System.out.println("getName");
        String name = getClass().getSimpleName();
        return name;
    }

    // 6
    @Override
    public void jobToBeExecuted(JobExecutionContext jobExecutionContext) {
        System.out.println("jobToBeExecuted");
    }

    @Override
    public void jobExecutionVetoed(JobExecutionContext jobExecutionContext) {
        System.out.println("jobExecutionVetoed");
    }

    // 8
    @Override
    public void jobWasExecuted(JobExecutionContext jobExecutionContext, JobExecutionException e) {
        System.out.println("jobWasExecuted");
    }

    // 1

    public void setAJob(String AJob) {
        System.out.println("setAJob() :" + AJob);

        this.AJob = AJob;
    }
}
