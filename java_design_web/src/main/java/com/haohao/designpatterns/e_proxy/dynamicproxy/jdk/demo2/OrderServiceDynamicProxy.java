package com.haohao.designpatterns.e_proxy.dynamicproxy.jdk.demo2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderServiceDynamicProxy implements InvocationHandler {

    /***
     *  这个类被加载的时候: 根据类加载的规则
     */

    private IOrderService orderService; // 被代理人

    public IOrderService getInstance(IOrderService orderService) {
        this.orderService = orderService;
        Class clazz = orderService.getClass();
        /**
         * getClassLoader: AppClassLoader
         * getInterfaces: --> 根据 类加载机制: 内存中会保存 Class 对象, Class 对象含有类的数据结构和提供了访问数据结构的方法;
         * this: OrderServiceDynamicProxy 对象
         */
        return (IOrderService) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        /**
         * Object proxy: $Proxy0 就是 getInstance 返回的
         *          $Proxy0@710 --> OrderServiceDynamicProxy@666
         * Method method: Method@717 -->
         *              clazz: IOrderService
         *              name: createOrder
         *              param: Order
         * Object[] args:Object[1]@718-->Order@667
         */
        before(args);
        // 这一步就是直接 调用了 orderService.createOrder 方法;
        Object obj = method.invoke(orderService, args);
        System.out.println("obj: " + obj);
        /**
         * Object obj: 就是调用 OrderService.createOrder 的返回值;
         */
        after();


        return obj;
    }

    public void before(Object[] args) {
        try {
            System.out.println("before 开始根据 Order 的 createTime 寻找对应的数据.");
            Long time = (Long) args[0].getClass().getMethod("getCreateTime").invoke(args[0]);
            SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
            int yearDbRouter = Integer.valueOf(yearFormat.format(new Date(time)));
            System.out.println("动态代理类自动分配到[DB_" + yearDbRouter + "] 数据源处理数据.");
            DynamicDataSourceEntity.set(yearDbRouter);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void after() {
        System.out.println("after, 代理后方法处理.");
    }
}
