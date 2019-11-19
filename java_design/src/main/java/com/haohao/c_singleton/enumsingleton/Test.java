package com.haohao.c_singleton.enumsingleton;

import com.haohao.c_singleton.lazy.demo5.SerializableSingleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**8
 *  测试 枚举单例;
 */
public class Test {

    public static void main(String[] args) {

        EnumSingleton s1 = null;

        EnumSingleton s2 = EnumSingleton.getInstance();


        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("SerializableSingleton.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s2);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("SerializableSingleton.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s1 = (EnumSingleton) ois.readObject();
            ois.close();

            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s1 == s2);
            /***
             * result:
             * true
             *
             */

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
