package com.haohao.designpatterns.k_observer.demo4;

import com.google.common.eventbus.Subscribe;

public class DataObserver1 {

    @Subscribe
    public void func(String msg) {
        System.out.println("String msg: " + msg);
    }
}
