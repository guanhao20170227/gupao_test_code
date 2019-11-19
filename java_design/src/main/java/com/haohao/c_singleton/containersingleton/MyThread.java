package com.haohao.c_singleton.containersingleton;

import com.haohao.c_singleton.threadlocal.ThreadLocalSingleton;

/***
 * 创建多线程用于测试 懒汉式 Demo1 存在线程的问题;
 */
public class MyThread implements Runnable {

    @Override
    public void run() {
        ContainerSingleton singletonDemo1 = ContainerSingleton.getInstance(null);
        System.out.println(Thread.currentThread().getName() + " " + singletonDemo1);
    }
}
