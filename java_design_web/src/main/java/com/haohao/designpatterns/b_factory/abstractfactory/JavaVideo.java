package com.haohao.designpatterns.b_factory.abstractfactory;

public class JavaVideo implements IVideo {

    @Override
    public void record() {
        System.out.println("录制 Java Video.");
    }
}
