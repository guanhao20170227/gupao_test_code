package com.example.thread.runnable.demo1;

public class Seller implements Runnable {
    private Integer ticket;

    public Seller(Integer ticket) {
        this.ticket = ticket;
    }

    @Override
    public void run() {
        while (ticket > 0) {
            ticket --;
            System.out.println("剩余 " + ticket + " 张票.");
        }
    }
}
