package com.haohao.designpatterns.j_decorator.demo1;

public class PancakeWithEggAndSausage extends PancakeWithEgg {

    @Override
    protected String getMsg() {
        return super.getMsg() + "+一根火腿肠.";
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 2;
    }
}
