package com.haohao.designpatterns.b_factory.factorymethod;

public class JavaCourse implements ICourse {
    @Override
    public void record() {
        System.out.println("录制 Java 课程.");
    }
}
