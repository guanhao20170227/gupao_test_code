package com.haohao.designpatterns.e_proxy.staticproxy;

public class OrderService implements IOrderService {

    private OrderDao orderDao;

    public OrderService() {
        orderDao = new OrderDao();
    }

    @Override
    public int createOrder(Order order) {
        System.out.println("com.haohao.e_proxy.staticproxy.OrderService.createOrder");
        return orderDao.insert(order);
    }
}
