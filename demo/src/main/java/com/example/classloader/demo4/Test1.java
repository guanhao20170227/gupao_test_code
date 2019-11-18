package com.example.classloader.demo4;

public class Test1 {

    int age = 18;
    static int realAge = 24;

    static {
        System.out.println("Static code.");
    }

    {
        System.out.println("Code clock.");
    }

    public Test1() {
        System.out.println("构造方法.");
        System.out.println("我的年龄: " + age + ", real age: " + realAge);
    }

    public static void main(String[] args) {
        System.out.println("输出的打印语句.");
        /***
         * result:
         * Static code.
         * 输出的打印语句.
         */
    }
}
