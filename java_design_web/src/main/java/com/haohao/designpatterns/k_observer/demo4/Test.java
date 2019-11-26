package com.haohao.designpatterns.k_observer.demo4;



public class Test {

    public static void main(String[] args) {

        DataObserver1 observer1 = new DataObserver1();
        DataObserver2 observer2 = new DataObserver2();

        EventBusCenter.register(observer1);
        EventBusCenter.register(observer2);

        EventBusCenter.post("Post String.");
        EventBusCenter.post(123);

    }
}
