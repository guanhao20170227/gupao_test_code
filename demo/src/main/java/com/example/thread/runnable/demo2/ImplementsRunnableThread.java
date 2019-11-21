package com.example.thread.runnable.demo2;

public class ImplementsRunnableThread implements Runnable {

    Thread t;

    ImplementsRunnableThread() {
        t = new Thread(this, "Demo Thread");
        System.out.println("Child thread: " + t);
        t.start();
    }


    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Child Thread: " + i);
                Thread.sleep(50);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Exiting child thread.");
    }
}
