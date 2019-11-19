package com.haohao.c_singleton.containersingleton;

public class Test {

    public static void main(String[] args) {

        System.out.println(ContainerSingleton.getInstance(null));
        System.out.println(ContainerSingleton.getInstance(null));
        System.out.println(ContainerSingleton.getInstance(null));
        System.out.println(ContainerSingleton.getInstance(null));

        Thread t1 = new Thread(new MyThread());

        Thread t2 = new Thread(new MyThread());

        t1.start();
        t2.start();

        System.out.println(t1);
        System.out.println(t2);
    }
}
