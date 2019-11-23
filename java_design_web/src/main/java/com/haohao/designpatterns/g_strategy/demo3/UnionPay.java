package com.haohao.designpatterns.g_strategy.demo3;

public class UnionPay extends Payment {
    @Override
    public String getName() {
        return "银联支付";
    }

    @Override
    public double queryBalance(String uid) {
        return 1200.0d;
    }
}
