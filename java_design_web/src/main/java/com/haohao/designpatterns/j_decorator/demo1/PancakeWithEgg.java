package com.haohao.designpatterns.j_decorator.demo1;

public class PancakeWithEgg extends Pancake {

    @Override
    protected String getMsg() {
        return super.getMsg() + "+一个鸡蛋.";
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 1;
    }
}
