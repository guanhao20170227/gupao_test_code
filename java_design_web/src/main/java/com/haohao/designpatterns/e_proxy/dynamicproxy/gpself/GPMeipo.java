package com.haohao.designpatterns.e_proxy.dynamicproxy.gpself;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class GPMeipo implements GPInvocationHandler {

    private Object obj; // 被代理人

    public Object getInstance(Object obj) {
        this.obj = obj;

        Class<?> clazz = obj.getClass();
        return GPProxy.newProxyInstance(new GPClassLoader(), clazz.getInterfaces(),
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Exception {
        before();

        method.invoke(this.obj, args);

        after();
        return null;
    }

    public void before() {
        System.out.println("Before");
    }

    public void after() {
        System.out.println("After");
    }
}
