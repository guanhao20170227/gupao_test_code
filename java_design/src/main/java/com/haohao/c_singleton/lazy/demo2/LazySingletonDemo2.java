package com.haohao.c_singleton.lazy.demo2;

/***
 *  懒汉式加载, 在外部方法调用的时候才会加载
 *
 *  第二种方法: 加上 synchronized 同步锁;
 */

public class LazySingletonDemo2 {

    private static LazySingletonDemo2 lazy = null;

    // 私有的构造方法:
    private LazySingletonDemo2() {}

    // 供外部访问的方法; --> 确实可以实现 同步的策略, 但是会将整个类都锁上, 一旦并发比较大就会严重的影响性能
    public static synchronized LazySingletonDemo2 getInstance() {
        if (null == lazy) {
            lazy = new LazySingletonDemo2();
        }
        return lazy;
    }

}
