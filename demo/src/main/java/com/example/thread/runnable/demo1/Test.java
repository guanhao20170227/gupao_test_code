package com.example.thread.runnable.demo1;

public class Test {
    public static void main(String[] args) {

        // 方法1:
        /**
         *  实现 Runable 创建 线程的 执行逻辑是:
         *      new Seller() --> Thread.start() --> Thread.run() --> Runnable.run();
         */
       /*
        System.out.println("开始卖票.");
        new Thread(new Seller(3)).start();
        new Thread(new Seller(2)).start();
        */

        // 方法2: 直接 run
        new Seller(3).run();
        new Seller(5).run();

    }
}
