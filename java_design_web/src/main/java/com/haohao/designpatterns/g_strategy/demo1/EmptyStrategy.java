package com.haohao.designpatterns.g_strategy.demo1;

public class EmptyStrategy implements IDiscountStrategy {

    @Override
    public void doDiscount() {
        System.out.println("没有优惠.");
    }
}
