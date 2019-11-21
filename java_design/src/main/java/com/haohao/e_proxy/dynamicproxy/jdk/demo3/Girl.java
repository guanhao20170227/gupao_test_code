package com.haohao.e_proxy.dynamicproxy.jdk.demo3;

import com.haohao.e_proxy.dynamicproxy.jdk.demo1.Person;

public class Girl implements Person {

    @Override
    public void findLove() {
        System.out.println("我的要求是: 高富帅.");
    }
}
