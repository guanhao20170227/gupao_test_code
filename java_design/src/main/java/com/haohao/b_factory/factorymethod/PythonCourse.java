package com.haohao.b_factory.factorymethod;


public class PythonCourse implements ICourse {
    @Override
    public void record() {
        System.out.println("录制 Python 的课程.");
    }
}
