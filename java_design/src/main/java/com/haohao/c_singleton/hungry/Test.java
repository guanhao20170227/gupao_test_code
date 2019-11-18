package com.haohao.c_singleton.hungry;

import java.lang.reflect.Constructor;

public class Test {

    public static void main(String[] args) {

        // 测试方法0, 使用反射获取对象
        try {
            Class clazz = HungrySingletonDemo1.class;
            Constructor c = clazz.getDeclaredConstructor(null);
            c.setAccessible(true); // not access a member of class
            Object obj = c.newInstance();
            System.out.println(obj);  // result: 会得到两个不一样的地址;
        } catch (Exception ex) {
            ex.printStackTrace();
        }



        // 测试方法1, 使用反射破坏 饿汉式的单例
        HungrySingletonDemo1 demo1 = HungrySingletonDemo1.getInstance();

        HungrySingletonDemo1 demo2 = HungrySingletonDemo1.getInstance();

        System.out.println(demo1);
        System.out.println(demo2); // result: 地址是一样的


    }
}
