package com.haohao.c_singleton.lazy.demo2;

import main.java.com.haohao.c_singleton.lazy.MyThread;

public class Demo2Test {

    public static void main(String[] args) {

        Thread t1 = new Thread(new MyThread2());
        Thread t2 = new Thread(new MyThread2());

        t1.start();
        t2.start();
        System.out.println("End");

        /**
         * result: 几率性出现 创建了两个不一样的 对象;
         * End
         * Thread-0 main.java.com.haohao.c_singleton.lazy.LazySingletonDemo1@63cd8695
         * Thread-1 main.java.com.haohao.c_singleton.lazy.LazySingletonDemo1@7249381e
         */


    }
}
