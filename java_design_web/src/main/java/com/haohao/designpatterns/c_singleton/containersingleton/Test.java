package com.haohao.designpatterns.c_singleton.containersingleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;

public class Test {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

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


        // 尝试反射破坏 容器式单例;
        Class clazz = ContainerSingleton.class;


        /*Constructor c = clazz.getDeclaredConstructor(null);
        c.setAccessible(true);
        Object o1 = c.newInstance();*/
        Object o1 = ContainerSingleton.getInstance(null);

        // Object o2 = c.newInstance();  // System.out.println(o1 == o2); -- false
        Object o2 = ContainerSingleton.getInstance(null); // System.out.println(o1 == o2); -- false
        System.out.println(o1.hashCode());
        System.out.println(o2.hashCode());
        System.out.println(o1 == o2);

        // 2 尝试序列化破坏单例;
        ContainerSingleton s1 = null;

        ContainerSingleton s2 = ContainerSingleton.getInstance(null);

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("SerializableSingleton.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s2);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("SerializableSingleton.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s1 = (ContainerSingleton) ois.readObject();
            ois.close();

            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s1 == s2);
            /***
             * result:
             * main.java.com.haohao.c_singleton.lazy.demo5.SerializableSingleton@568db2f2
             * main.java.com.haohao.c_singleton.lazy.demo5.SerializableSingleton@135fbaa4
             * false
             *
             */

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
