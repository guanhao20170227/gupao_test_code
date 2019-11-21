package com.haohao.e_proxy.dynamicproxy.jdk.demo2;

public class OrderDao {
    public Integer insert(Order order) {
        System.out.println("OrderDao 插入 Order 成功.");
        return 999;
    }
}
