package com.example.thread.thread;

public class NewThread extends Thread {

    public NewThread() {
        super("Demo Thread");
        System.out.println("Child thread: " + this);
        start();
    }

    @Override
    public void run() {
        try {
            for ( int i = 5; i > 0; i--) {
                System.out.println("Child Thread: " + i);
                Thread.sleep(50);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("Child Thread end.");
    }
}
