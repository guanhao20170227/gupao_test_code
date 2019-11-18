package com.haohao.c_singleton.hungry;
/***
 *  饿汉式 单例的 第一种写法:
 *
 *  -- > 线程安全. 但是比较耗 内存
 *      添加 final 是为了防止 反射的破坏单例 --> result: 添加 final 与否, 都可以利用反射来, 打破 饿汉式的单例模式，创建多个对象;
 */


public class HungrySingletonDemo1 {

    // 方法0： 倍反射破坏的单例的测试: 没有添加 final 关键字
    private static final HungrySingletonDemo1 hungrySingleton = new HungrySingletonDemo1();

    // 私有的构造方法
    private HungrySingletonDemo1() {

    }

    // 提供外部的访问点
    public static HungrySingletonDemo1 getInstance() {
        return hungrySingleton;
    }



     // 这个是第一种写法
    /*
    private static final HungrySingletonDemo1 hungrySingleton = new HungrySingletonDemo1();

    // 私有的构造方法
    private HungrySingletonDemo1() {}

    // 提供外部的访问点
    public HungrySingletonDemo1 getInstance() {
        return hungrySingleton;
    }
    */

    // 第二种写法： 利用静态的代码块来处理;
    /*
    private static final HungrySingletonDemo1 hungrySingleton;

    static {
        hungrySingleton = new HungrySingletonDemo1();
    }

    private HungrySingletonDemo1() {}

    public HungrySingletonDemo1 getInstance() {
        return hungrySingleton;
    }
    */
}
