package com.haohao.designpatterns.j_decorator.demo2;

public abstract class PancakeDecorator extends Pancake {

    // 1 静态代理
    private Pancake pancake;

    public PancakeDecorator(Pancake pancake) {
        this.pancake = pancake;
    }

    protected abstract void doSomeOtherThing();


    @Override
    protected String getMsg() {
        return pancake.getMsg();
    }

    @Override
    protected int getPrice() {
        return pancake.getPrice();
    }
}
