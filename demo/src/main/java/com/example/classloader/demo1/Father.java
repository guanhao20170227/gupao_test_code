package com.example.classloader.demo1;

public class Father {

    public static String strFather = "Father String Property.";

    static {
        System.out.println("Father static code.");
    }
}
