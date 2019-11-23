package com.haohao.designpatterns.e_proxy.dynamicproxy.cglib;


public class Girl implements Person {

    @Override
    public void findLove() {
        System.out.println("我的要求是: 高富帅.");
    }
}
