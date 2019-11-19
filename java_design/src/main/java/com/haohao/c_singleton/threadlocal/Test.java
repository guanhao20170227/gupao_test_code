package com.haohao.c_singleton.threadlocal;

public class Test {

    public static void main(String[] args) {

        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());

        Thread t1 = new Thread(new MyThread());

        Thread t2 = new Thread(new MyThread());

        t1.start();
        t2.start();

        System.out.println(t1);
        System.out.println(t2);

    }
}
