package com.haohao.designpatterns.j_decorator.demo2;

public class BasePancake extends Pancake {

    @Override
    protected String getMsg() {
        return "煎饼";
    }

    @Override
    protected int getPrice() {
        return 5;
    }
}
