package com.haohao.designpatterns.e_proxy.demo1;


// 接口暴露 被代理人(Son) 的所有向被代理的方法;
public interface Person {

    void findLove();

    // 扩展, 寻找工作的方法
    void findJob();
}
