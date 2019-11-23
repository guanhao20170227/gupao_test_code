package com.haohao.designpatterns.g_strategy.demo1;

public class DiscountActivity {

    private IDiscountStrategy discountStrategy;

    public DiscountActivity(IDiscountStrategy strategy) {
        this.discountStrategy = strategy;
    }

    public void execute() {
        discountStrategy.doDiscount();
    }

}
