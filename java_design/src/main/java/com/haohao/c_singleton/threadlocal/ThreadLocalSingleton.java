package main.java.com.haohao.c_singleton.threadlocal;

public class ThreadLocalSingleton {

    private static final ThreadLocal<ThreadLocalSingleton> threadLocalInstance =
        new ThreadLocal<ThreadLocalSingleton>() {
            protected ThreadLocalSingleton initialValue() {
                return new ThreadLocalSingleton();
            }
    };

    private ThreadLocalSingleton() {}

    public static ThreadLocalSingleton getInstance() {
        return threadLocalInstance.get();
    }



}
