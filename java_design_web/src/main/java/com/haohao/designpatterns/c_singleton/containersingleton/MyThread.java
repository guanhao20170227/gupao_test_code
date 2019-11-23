package com.haohao.designpatterns.c_singleton.containersingleton;

/***
 * 创建多线程用于测试 懒汉式 Demo1 存在线程的问题;
 */
public class MyThread implements Runnable {

    @Override
    public void run() {
        ContainerSingleton singletonDemo1 = ContainerSingleton.getInstance(null);

        // 利用反射破坏单例;
        /*ContainerSingleton singletonDemo1 = null;
        Class clazz = ContainerSingleton.class;
        try {
            Constructor c = clazz.getDeclaredConstructor(null);
            c.setAccessible(true);
            singletonDemo1 = (ContainerSingleton) c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }*/


        System.out.println(Thread.currentThread().getName() + " " + singletonDemo1);
    }
}
