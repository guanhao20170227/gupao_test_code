package com.example.thread.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableThreadTest implements Callable {

    public static void main(String[] args) {

        CallableThreadTest test = new CallableThreadTest();
        FutureTask futureTask = new FutureTask(test);

        for (int i = 0; i < 2; i++) {
            System.out.println(Thread.currentThread().getName() + " 的循环变量的值 " + i);
            if (i == 1) {
                new Thread(futureTask, "有返回值的线程").start();
            }
        }
        try {
            System.out.println("子线程的返回值: " + futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object call() throws Exception {
        int i = 0;
        for (; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
        return i;
    }
}
