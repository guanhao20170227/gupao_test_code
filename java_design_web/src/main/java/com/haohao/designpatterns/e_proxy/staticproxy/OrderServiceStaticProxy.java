package com.haohao.designpatterns.e_proxy.staticproxy;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderServiceStaticProxy implements IOrderService {

    private IOrderService orderService;

    private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

    public OrderServiceStaticProxy(IOrderService orderService) {
        this.orderService = orderService;
    }


    @Override
    public int createOrder(Order order) {
        before(order);
        // 执行代理类的方法
        orderService.createOrder(order);
        after();
        return 0;
    }

    public void before(Order order) {
        System.out.println("代理前的方法.");
        // 根据 createTime 来切换数据源
        //   数据源 与 orderService 最后数据的保存有关联？
        Long time = order.getCreateTime();
        Integer dbRouter = Integer.valueOf(yearFormat.format(new Date(time)));
        System.out.println("静态代理类自动分配到[DB_" + dbRouter + "] 数据源处理数据.");
        DynamicDataSourceEntity.set(dbRouter);
    }

    public void after() {
        System.out.println("代理后的方法.");
    }
}
