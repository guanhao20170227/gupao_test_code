package com.haohao.designpatterns.g_strategy.demo3;

/**
 *  场景1:　提供了　alipay, unionpay, jdpay
 *
 *  场景2: --> 新加一个 WechatPay 呢;
 *
 *
 */
public class Test {

    public static void main(String[] args) {

        Order order = new Order("20191123", "买菜", 5660d);
        // System.out.println(order.pay());
        // 订单需要知道有哪些 策略， 比如 Android 上需要提供 4个按钮可以选择
        // System.out.println(order.pay(PayStrategy.JDPAY));


        // test 场景2
        System.out.println(order.pay(PayStrategy.WECHATPAY));

    }

}
