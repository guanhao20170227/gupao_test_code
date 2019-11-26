package com.haohao.designpatterns.k_observer.demo3;

import com.google.common.eventbus.Subscribe;

public class GuavaEvent {

    @Subscribe
    public void subscribe(String str) {
        System.out.println("执行 subscribe 方法, 传入的参数是: " + str);
    }
}
