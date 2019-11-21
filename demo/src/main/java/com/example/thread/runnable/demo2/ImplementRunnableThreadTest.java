package com.example.thread.runnable.demo2;

public class ImplementRunnableThreadTest {

    public static void main(String[] args) {
        new ImplementsRunnableThread();

        try {
            for (int i=5; i>0; i--) {
                System.out.println("Main Thread: " + i);
                Thread.sleep(100);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Main thread exiting.");
    }
}
