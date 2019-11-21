package com.example.generics.method;

public class Test2 {

    public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
        T max = x;
        if (y.compareTo(max) > 0) {
            max = y;
        }
        if (z.compareTo(max) > 0) {
            max = z;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.printf(" In number of %d %d %d, max is %d \r\n",
                6, 8 , 9, maximum(6, 8, 9));
    }
}
