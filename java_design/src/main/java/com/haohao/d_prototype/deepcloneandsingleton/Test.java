package com.haohao.d_prototype.deepcloneandsingleton;

import java.lang.reflect.Constructor;

public class Test {

    public static void main(String[] args) throws Exception {

        // 1 使用反射获取 实例， 在构造方法添加判断
        Class clazz = DeepCloneSingleton.class;
        Constructor c = clazz.getDeclaredConstructor(null);
        c.setAccessible(true);
        //DeepCloneSingleton deep1 = (DeepCloneSingleton) c.newInstance();

        // 2 直接获取对象
        DeepCloneSingleton deep2 = DeepCloneSingleton.getInstance();

        // 3 克隆的
        DeepCloneSingleton deep3 = (DeepCloneSingleton) deep2.clone();

        // System.out.println(deep1 == deep2);
        // System.out.println(deep1 == deep3);
        System.out.println(deep2 == deep3);
    }
}
