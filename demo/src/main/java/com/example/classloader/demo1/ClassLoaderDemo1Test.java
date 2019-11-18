package com.example.classloader.demo1;

/***
 *
 *  类加载 案例1：
 */

public class ClassLoaderDemo1Test {

    public static void main(String[] args) {

        System.out.println(Son.strSon);

        /**
         * result:
         * Father static code.
         * Son static code.
         * Son String Property.
         *
         */
    }

}
