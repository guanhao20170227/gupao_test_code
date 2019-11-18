package com.example.classloader.demo5;

public class Test {

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = Test.class.getClassLoader();

        //1 ClassLoad.loadClass() 加载类不会执行初始化;
        classLoader.loadClass("com.example.classloader.demo5.Demo");

        //2 Class.forName() 加载类, 并且会直接初始化代码块;
        Class.forName("com.example.classloader.demo5.Demo");

        //3 Class.forName(,,)， 指定 ClassLoader， 初始化不执行静态代码块， false/true 都不值执行
        Class.forName("com.example.classloader.demo5.Demo", false, classLoader);
    }
}

class Demo {
    static {
        System.out.println("静态代码块.");
    }
}
