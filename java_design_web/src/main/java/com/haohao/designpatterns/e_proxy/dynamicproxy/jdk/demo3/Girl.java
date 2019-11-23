package com.haohao.designpatterns.e_proxy.dynamicproxy.jdk.demo3;


public class Girl implements Person {

    @Override
    public void findLove() {
        System.out.println("我的要求是: 高富帅.");
    }
}
