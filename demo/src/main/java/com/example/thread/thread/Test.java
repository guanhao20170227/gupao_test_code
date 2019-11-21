package com.example.thread.thread;

public class Test {

    public static void main(String[] args) {

        new NewThread();
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Main Thread: " + i);
                Thread.sleep(90);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Main Thread exit.");
    }
}
