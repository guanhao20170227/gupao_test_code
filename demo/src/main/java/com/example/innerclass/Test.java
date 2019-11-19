package com.example.innerclass;

public class Test {

    public static void main(String[] args) {

        // 1, 访问静态内部类
        StaticInnerClass.Inner inner = new StaticInnerClass.Inner();

        // 2, 访问成员内部类
        MemberInnerClass.InnerClass innerClass = new MemberInnerClass().new InnerClass();
        innerClass.getAge();

        // 3, 访问局部内部类
        MethodInnerClass methodInnerClass = new MethodInnerClass();
        methodInnerClass.sayHello();

        // 4, 访问匿名内部类
        NoNameInnerClass noNameInnerClass = new NoNameInnerClass();
        noNameInnerClass.getObj().toString();

    }
}
