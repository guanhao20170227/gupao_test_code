package main.java.com.haohao.c_singleton.lazy;

/***
 *  懒汉式加载, 在外部方法调用的时候才会加载
 *
 *  --> 会存在线程 不安全的问题;
 */

public class LazySingletonDemo1 {

    private static LazySingletonDemo1 lazy = null;

    // 私有的构造方法:
    private LazySingletonDemo1() {}

    // 供外部访问的方法; ---> 会存在 线程不安全的问题;
    public static LazySingletonDemo1 getInstance() {
        if (null == lazy) {
            lazy = new  LazySingletonDemo1();
        }
        return lazy;
    }

}
