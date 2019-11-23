package com.haohao.designpatterns.c_singleton.lazy.demo2;

/***
 * 创建多线程用于测试 懒汉式 Demo1 存在线程的问题;
 */
public class MyThread2 implements Runnable {

    @Override
    public void run() {
        LazySingletonDemo2 singletonDemo2 = LazySingletonDemo2.getInstance();
        System.out.println(Thread.currentThread().getName() + " " + singletonDemo2);
    }
}
