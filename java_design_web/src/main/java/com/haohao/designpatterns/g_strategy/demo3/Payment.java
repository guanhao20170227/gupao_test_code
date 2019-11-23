package com.haohao.designpatterns.g_strategy.demo3;

public abstract class Payment {

    // 支付类型
    public abstract String getName();

    // 查询余额
    public abstract double queryBalance(String uid);

    // 扣款支付
    public PayState pay(String uid, double amount) {
        if (queryBalance(uid) < amount) {
            return new PayState(500, "支付失败", "余额不足");
        }
        return new PayState(200, "支付成功", "您这次消费了 " + amount + " 元.");
    }
}
