package com.example.classloader.demo1;

public class Son extends Father {

    public static String strSon = "Son String Property.";

    static {
        System.out.println("Son static code.");
    }
}
