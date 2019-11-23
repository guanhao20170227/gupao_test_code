package com.haohao.designpatterns.g_strategy.demo1;

public class CouponStrategy implements IDiscountStrategy {
    @Override
    public void doDiscount() {
        System.out.println("优惠券的优惠方式.");
    }
}
