package com.example.generics.gclass;

public class Test<T> {

    private T t;

    public void add(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public static void main(String[] args) {

        Test<Integer> integerTest = new Test<Integer>();
        Test<String> stringTest = new Test<String>();

        integerTest.add(new Integer(12));
        stringTest.add(new String("Hello World."));

        System.out.println("integerTest: " + integerTest.get());
        System.out.println("stringTest: " + stringTest.get());

    }

}
