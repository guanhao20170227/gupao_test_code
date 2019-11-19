package com.example.innerclass;

public class MemberInnerClass {

    private int age = 23;

    class InnerClass {

        public void getAge() {
            System.out.println("Age: " + age);
        }
    }
}
