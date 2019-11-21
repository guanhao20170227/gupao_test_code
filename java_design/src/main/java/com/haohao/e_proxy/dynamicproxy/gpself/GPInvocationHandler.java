package com.haohao.e_proxy.dynamicproxy.gpself;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public interface GPInvocationHandler {

    public Object invoke(Object proxy, Method method, Object[] args) throws Exception;
}
