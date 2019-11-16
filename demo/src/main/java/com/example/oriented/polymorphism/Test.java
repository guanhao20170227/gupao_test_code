package com.example.oriented.polymorphism;

/**
 *
 */
public class Test {

    public static void main(String[] args) {

        Salary s = new Salary("Mohd Mohtashim", "Ambehta, UP", 3, 3600.00);
        Employee e = new Salary("John Adams", "Boston, MA", 2, 2400.00);
        System.out.println("Call mailCheck using Salary reference --");
        s.mailCheck();
        System.out.println("\n Call mailCheck using Employee reference--");
        e.mailCheck();

        System.out.println("***************");
        test2();
    }

    public static void test2() {
        Salary s = new Salary("Mohd Mohtashim", "Ambehta, UP", 3, 3600.00);
        Employee e = new Employee("Jack", "changsha", 100);

        s.mailCheck();
        e.mailCheck();
    }
}
