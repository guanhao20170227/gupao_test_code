package com.haohao.e_proxy.dynamicproxy.gpself;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GPProxyTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Object person = new GPMeipo().getInstance(new Girl());
        System.out.println(person.getClass());
        Method method = person.getClass().getMethod("findLove",null);
        method.invoke(person, null);
    }
}
