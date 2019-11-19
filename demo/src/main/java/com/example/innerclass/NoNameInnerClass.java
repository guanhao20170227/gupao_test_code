package com.example.innerclass;

public class NoNameInnerClass {

    private int age =23;

    // 这个就是匿名内部类
    private Object obj = new Object() {
        private String name = "NoNameInnerClass";

        public String toString() {
            System.out.println(name);
            return name;
        }
    };

    public Object getObj() {
        return obj;
    }
}
