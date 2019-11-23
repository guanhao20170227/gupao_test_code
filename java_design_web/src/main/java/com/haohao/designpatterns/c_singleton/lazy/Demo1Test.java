package com.haohao.designpatterns.c_singleton.lazy;

public class Demo1Test {

    public static void main(String[] args) {

        Thread t1 = new Thread(new MyThread());
        Thread t2 = new Thread(new MyThread());

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
