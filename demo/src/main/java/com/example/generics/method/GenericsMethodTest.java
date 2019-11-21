package com.example.generics.method;

public class GenericsMethodTest {

    public static <E> void printArray(E[] inputArray) {
        for (E element : inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Integer[] intArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {1.1, 1.2, 3.4, 7.8, 3.1};
        Character[] charArray = {'A', 'B', 'Y', 'W'};

        System.out.println("IntArray: ");
        printArray(intArray);
        System.out.println("DoubleArray: ");
        printArray(doubleArray);
        System.out.println("CharArray: ");
        printArray(charArray);

    }
}
