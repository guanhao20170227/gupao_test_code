package com.haohao.designpatterns.e_proxy.staticproxy;

public class OrderDao {
    public Integer insert(Order order) {
        System.out.println("OrderDao 插入 Order 成功.");
        return 1;
    }
}
