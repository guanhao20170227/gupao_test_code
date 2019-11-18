package com.example.string;

public class EqualsStringTest {

    public static void main(String[] args) {

        String str1 = new String("abc");
        String str2 = new String("abc");

        System.out.println(str1.equals(str2)); // true
        System.out.println(str1 == str2); // false

        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());

        System.out.println(str1.getBytes());
        System.out.println(str2.getBytes());


    }
}
