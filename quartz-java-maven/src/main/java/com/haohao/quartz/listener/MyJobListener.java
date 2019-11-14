package com.haohao.quartz.listener;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

public class MyJobListener implements JobListener {
    @Override
    public String getName() {
        String name = getClass().getSimpleName();
        System.out.println("Do getName: " + name);
        return name;
    }

    @Override
    public void jobToBeExecuted(JobExecutionContext jobExecutionContext) {
        String jobName = jobExecutionContext.getJobDetail().getKey().getName();
        System.out.println("Do jobToBeExecuted: " + jobName);
    }

    @Override
    public void jobExecutionVetoed(JobExecutionContext jobExecutionContext) {
        String jobName = jobExecutionContext.getJobDetail().getKey().getName();
        System.out.println("Do jobExecutionVetoed: " + jobName);
    }

    @Override
    public void jobWasExecuted(JobExecutionContext jobExecutionContext, JobExecutionException e) {
        String jobName = jobExecutionContext.getJobDetail().getKey().getName();
        System.out.println("Do jobWasExecuted: " + jobName);
    }


}
