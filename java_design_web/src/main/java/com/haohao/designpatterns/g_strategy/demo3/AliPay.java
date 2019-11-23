package com.haohao.designpatterns.g_strategy.demo3;

public class AliPay extends Payment {
    @Override
    public String getName() {
        return "支付宝";
    }

    @Override
    public double queryBalance(String uid) {
        return 1000.0d;
    }
}
