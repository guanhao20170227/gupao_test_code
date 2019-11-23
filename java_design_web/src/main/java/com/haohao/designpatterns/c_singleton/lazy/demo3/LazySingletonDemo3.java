package com.haohao.designpatterns.c_singleton.lazy.demo3;

/***
 *  懒汉式加载, 在外部方法调用的时候才会加载
 *
 *  --> 使用双重锁的方式, 来实现单例;
 */

public class LazySingletonDemo3 {

    private static LazySingletonDemo3 lazy = null;

    // 私有的构造方法:
    private LazySingletonDemo3() {}

    // 供外部访问的方法, 只是对类的 getInstance() 方法加锁了, 所以不会锁定整个类
    public LazySingletonDemo3 getInstance() {
        if (null == lazy) {
            synchronized (LazySingletonDemo3.class) {
                if (lazy == null) {
                    lazy = new LazySingletonDemo3();
                }
            }
        }
        return lazy;
    }

}
