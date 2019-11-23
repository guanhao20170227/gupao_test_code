package com.haohao.designpatterns.g_strategy.demo3;

public class WechatPay extends Payment {
    @Override
    public String getName() {
        return "微信支付";
    }

    @Override
    public double queryBalance(String uid) {
        return 9999.0d;
    }
}
