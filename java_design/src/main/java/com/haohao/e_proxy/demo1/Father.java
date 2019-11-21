package com.haohao.e_proxy.demo1;

public class Father {

    // 持有对 被代理对象的 引用
    private Son son;

    public Father(Son son) {
        this.son = son;
    }

    // 代理类(Father) 必须要有与子类一样的方法;
    public void findLoveForSon() {
        System.out.println("将女同志交给 Son 看之前的审查工作.");
        this.son.findLove();
        System.out.println("询问 将女同志交给 Son 见面后的, 反馈情况.");
    }

    // 代理类也要添加一个方法来应对 被代理人 的新的需求
    public void findJobForSon() {
        System.out.println("将 工作 交给 Son 看之前的审查工作.");
        this.son.findJob();
        System.out.println("询问 将 工作 交给 Son 后的, 反馈情况.");
    }

}
