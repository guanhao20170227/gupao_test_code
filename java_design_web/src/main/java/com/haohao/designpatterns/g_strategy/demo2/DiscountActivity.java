package com.haohao.designpatterns.g_strategy.demo2;

public class DiscountActivity {

    public String discountKey;

    public DiscountActivity(String discountKey) {
        this.discountKey = discountKey;
    }

    // IDiscountStrategy strategy = DiscountStrategyFactory.getDiscountStrategy(discountKey);

    public void execute() {
        DiscountStrategyFactory.getDiscountStrategy(discountKey).doDiscount();
    }
}
