package com.haohao.c_singleton.lazy.demo5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test {

    public static void main(String[] args) {

        SerializableSingleton s1 = null;

        SerializableSingleton s2 = SerializableSingleton.getInstance();


        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("SerializableSingleton.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s2);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("SerializableSingleton.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s1 = (SerializableSingleton) ois.readObject();
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
