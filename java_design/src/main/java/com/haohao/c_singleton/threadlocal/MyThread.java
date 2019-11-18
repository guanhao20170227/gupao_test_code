package main.java.com.haohao.c_singleton.threadlocal;

import main.java.com.haohao.c_singleton.lazy.LazySingletonDemo1;

/***
 * 创建多线程用于测试 懒汉式 Demo1 存在线程的问题;
 */
public class MyThread implements Runnable {

    @Override
    public void run() {
        ThreadLocalSingleton singletonDemo1 = ThreadLocalSingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + " " + singletonDemo1);
    }
}
