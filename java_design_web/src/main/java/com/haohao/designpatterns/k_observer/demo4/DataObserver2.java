package com.haohao.designpatterns.k_observer.demo4;

import com.google.common.eventbus.Subscribe;

public class DataObserver2 {

    @Subscribe
    public void func(Integer msg) {
        System.out.println("Integer msg: " + msg);
    }
}
