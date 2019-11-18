package main.java.com.haohao.c_singleton.lazy;

/***
 * 创建多线程用于测试 懒汉式 Demo1 存在线程的问题;
 */
public class MyThread implements Runnable {

    @Override
    public void run() {
        LazySingletonDemo1 singletonDemo1 = LazySingletonDemo1.getInstance();
        System.out.println(Thread.currentThread().getName() + " " + singletonDemo1);
    }
}
