package com.haohao.designpatterns.e_proxy.dynamicproxy.jdk.demo2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClientTest {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date date = sdf.parse("2012/09/09");

        Order order = new Order();
        order.setCreateTime(date.getTime());

        /**
         * 调试时的 链式的初始化顺序: new OrderServiceDynamicProxy() --> new OrderService() --> getInstance(...)
         *
         */

        IOrderService instance = new OrderServiceDynamicProxy().getInstance(new OrderService());
        // --> OrderServiceDynamicProxy.invoke() 方法
        instance.createOrder(order);
    }
}
