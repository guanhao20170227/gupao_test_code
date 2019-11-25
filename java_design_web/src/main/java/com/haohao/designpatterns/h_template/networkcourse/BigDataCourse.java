package com.haohao.designpatterns.h_template.networkcourse;

public class BigDataCourse extends NetworkCourse {

    private Boolean needHomeworkFlag = false;

    public BigDataCourse(Boolean needHomework) {
        this.needHomeworkFlag = needHomework;
    }

    @Override
    void checkHomework() {
        System.out.println("6 检查 BigData 的作业.");
    }

    @Override
    protected boolean needHomework() {
        return this.needHomeworkFlag;
    }
}
