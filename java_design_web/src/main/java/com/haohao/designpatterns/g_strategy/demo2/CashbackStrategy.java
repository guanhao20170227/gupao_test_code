package com.haohao.designpatterns.g_strategy.demo2;

public class CashbackStrategy implements IDiscountStrategy {

    @Override
    public void doDiscount() {
        System.out.println("返现的优惠方式.");
    }
}
