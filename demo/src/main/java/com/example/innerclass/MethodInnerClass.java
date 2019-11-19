package com.example.innerclass;

import com.sun.org.apache.xml.internal.res.XMLErrorResources_tr;

public class MethodInnerClass {

    private Integer age = 23;

    public void sayHello() {
        final String name = "pie";
        final int height = 34;

        class InnerClass {
            public void print() {
                System.out.println("name: " + name);
                System.out.println("height: " + height);
                System.out.println("age: " + age);
            }
        }
        new InnerClass().print();
    }

}
