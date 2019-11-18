package com.example.classloader.demo2;

public class Father extends YeYe {

    public static String strFather = "Father String Property.";

    static {
        System.out.println("Father static code.");
    }
}
