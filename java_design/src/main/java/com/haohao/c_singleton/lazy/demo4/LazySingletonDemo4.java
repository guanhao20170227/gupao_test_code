package com.haohao.c_singleton.lazy.demo4;

/***
 *  懒汉式加载, 在外部方法调用的时候才会加载
 *
 *  --> 使用静态内部类来实现单例, 运用了 类加载的知识: 后面看 Think in Java 后在说;
 */

public class LazySingletonDemo4 {

    // 方法1: 正常的写法;
    /*
    private LazySingletonDemo4() {}

    public static final LazySingletonDemo4 getInstance() {
        return LazyHolder.LAZY;
    }

    private static class LazyHolder {
        private static final LazySingletonDemo4 LAZY = new LazySingletonDemo4();
    }
    */

    // 方法2: 添加防止 反射破坏单例;
    // 会逼着你去调用 getInstance() 方法
    private LazySingletonDemo4() {
        if (LazyHolder.LAZY != null) {
            throw new RuntimeException("不能创建多个实例");
        }
    }

    public static final LazySingletonDemo4 getInstance() {
        return LazyHolder.LAZY;
    }

    private static class LazyHolder {
        private static final LazySingletonDemo4 LAZY = new LazySingletonDemo4();
    }


}
