package com.haohao.designpatterns.g_strategy.demo1;

public class GroupbyStrategy implements IDiscountStrategy {

    @Override
    public void doDiscount() {
        System.out.println("团购的优惠方式.");
    }
}
