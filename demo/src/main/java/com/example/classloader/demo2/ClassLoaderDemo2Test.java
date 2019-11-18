package com.example.classloader.demo2;

public class ClassLoaderDemo2Test {

    public static void main(String[] args) {
        System.out.println(Son.strFather);

        /** result:
         * YeYe static code.
         * Father static code.
         * Father String Property.
         */
    }
}


