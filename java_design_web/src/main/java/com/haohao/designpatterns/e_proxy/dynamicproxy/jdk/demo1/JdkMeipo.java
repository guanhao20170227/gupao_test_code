package com.haohao.designpatterns.e_proxy.dynamicproxy.jdk.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *  JDK 媒婆 代理类
 */
public class JdkMeipo implements InvocationHandler {

    private Person agent;// 被代理人

    public Person getInstance(Person target) {
        this.agent = target;
        Class clazz = target.getClass();
        return (Person) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        method.invoke(this.agent, args);
        after();
        return null;
    }

    public void before() {
        System.out.println("before 我是媒婆, 我现在知道了您的需求, 我现在开始物色.");
    }

    public void after() {
        System.out.println("after 双方已经见过面了, 询问一下结果, 感觉合不合适.");
    }
}
