package com.haohao.c_singleton.lazy.demo4;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/***
 *  使用反射来破坏 内部类
 */
public class Test1 {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        // 使用反射初始化对象;
        /*Class clazz = LazySingletonDemo4.class;
        Constructor c = clazz.getDeclaredConstructor(null);
        c.setAccessible(true);
        Object o1 = c.newInstance();

        Object o2 = LazySingletonDemo4.getInstance();

        System.out.println(o1 == o2); // false
        */
        Object o2 = LazySingletonDemo4.getInstance();
        Object o3 = LazySingletonDemo4.getInstance();
        System.out.println(o2 == o3);

    }

}
