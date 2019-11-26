package com.haohao.designpatterns.k_observer.demo3;

import com.google.common.eventbus.EventBus;

public class Test {

    public static void main(String[] args) {

        EventBus eventBus = new EventBus();

        GuavaEvent guavaEvent = new GuavaEvent();

        eventBus.register(guavaEvent);
        eventBus.post("Tom");

    }
}
