package com.haohao.e_proxy.dynamicproxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 *  使用 CGlib 时, 需要引入 Jar 包: cglib-3.3.0.jar 包
 */
public class CglibMeipo implements MethodInterceptor {

    public Object getInstance(Class<?> clazz) {
        Enhancer enhancer = new Enhancer();
        // 默认创建的类继承 被代理类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        /**
         * invokeSuper 会调用 代理类: Girl$$EnhancerByCGLIB$$a0c84e73.CGLIB$findLove$0() 方法
         *   methodProxy.invoke() 会一直调用拦截器;
         *
         */
        Object obj = methodProxy.invokeSuper(o, objects);
        after();
        return obj;
    }

    public void before() {
        System.out.println("Before");
    }

    public void after() {
        System.out.println("After");
    }
}
