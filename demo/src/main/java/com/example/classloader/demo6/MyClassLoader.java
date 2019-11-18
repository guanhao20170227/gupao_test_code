package com.example.classloader.demo6;

import java.io.*;

public class MyClassLoader extends ClassLoader {
    private String root;

    protected Class<?> findClass(String name) throws ClassNotFoundException {

        name = "com.example.classloader.demo6.Demo6";

        byte[] classData = loadClassData(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            return defineClass(name, classData, 0, classData.length);
        }
    }

    private byte[] loadClassData(String className) {
        String fileName = root + File.separatorChar
                + className.replace('.', File.separatorChar) + ".class";
        try {
            InputStream ins = new FileInputStream(fileName);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int bufferSize = 1024;
            byte[] buffer = new byte[bufferSize];
            int length = 0;
            while ((length = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, length);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public static void main(String[] args) {

        MyClassLoader classLoader = new MyClassLoader();
        // result: sun.misc.Launcher$AppClassLoader@18b4aac2  由 AppClassLoader 处理了;
        // classLoader.setRoot("I:\\develop\\code\\idea_code\\gupao_test_code\\demo\\src\\main\\java\\com\\example\\classloader\\demo6");
        // result: com.example.classloader.demo6.MyClassLoader@7adf9f5f  使用的自己的 ClassLoader
        classLoader.setRoot("F:\\pie\\temp");


        Class<?> testClass = null;
        try {
            testClass = classLoader.loadClass("com.example.classloader.demo6.Demo6");
            Object object = testClass.newInstance();
            System.out.println(object.getClass().getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
