package com.haohao.e_proxy.staticproxy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**8
 *  用于测试 静态代理 来实现多数据源的 分库
 *
 *  给最简单的 三层架构 添加动态数据源切换的操作;
 *
 */
public class ClientTest {

    public static void main(String[] args) throws ParseException {

        Order order = new Order();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        // Date date = sdf.parse("2017/02/13");
        Date date = sdf.parse("2019/02/13");

        order.setCreateTime(date.getTime());

        IOrderService orderService = new OrderServiceStaticProxy(new OrderService());
        orderService.createOrder(order);

    }
}
