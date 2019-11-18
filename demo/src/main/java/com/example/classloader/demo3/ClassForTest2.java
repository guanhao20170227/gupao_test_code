package com.example.classloader.demo3;

public class ClassForTest2 {

    static {
        System.out.println("静态代码块.");
    }

    public static final double str = Math.random();// 编译期不确定
}
