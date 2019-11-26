package com.haohao.designpatterns.j_decorator.demo2;

public class EggDecorator extends PancakeDecorator {

    public EggDecorator(Pancake pancake) {
        super(pancake);
    }

    @Override
    protected void doSomeOtherThing() {
        System.out.println("还可以做一点别的事情.");
    }

    @Override
    protected String getMsg() {
        return super.getMsg() + "+ 1 个鸡蛋.";
    }

    @Override
    protected int getPrice() {
        return super.getPrice() + 1;
    }
}
