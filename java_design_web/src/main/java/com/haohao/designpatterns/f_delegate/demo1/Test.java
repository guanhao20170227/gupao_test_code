package com.haohao.designpatterns.f_delegate.demo1;

public class Test {
    public static void main(String[] args) {
        System.out.println(new Boss(new Leader()).sendCommand("加密"));
        System.out.println(new Boss(new Leader()).sendCommand("架构"));
        System.out.println(new Boss(new Leader()).sendCommand("新项目"));
    }
}
