package com.haohao.e_proxy.demo1;

/**
 *  这个例子主要是: 父母是子女的代理, 来找相亲的对象;
 */
public class Test {
    public static void main(String[] args) {

        Father father = new Father(new Son());
        father.findLoveForSon();

        System.out.println("--------------------");
        father.findJobForSon();

    }
}
