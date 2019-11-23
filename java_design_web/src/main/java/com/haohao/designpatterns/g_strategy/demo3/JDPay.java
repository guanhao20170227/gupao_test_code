package com.haohao.designpatterns.g_strategy.demo3;

public class JDPay extends Payment {
    @Override
    public String getName() {
        return "京东支付";
    }

    @Override
    public double queryBalance(String uid) {
        return 2000.0d;
    }
}
