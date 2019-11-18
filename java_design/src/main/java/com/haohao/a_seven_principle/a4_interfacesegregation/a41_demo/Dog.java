package com.haohao.a_seven_principle.a4_interfacesegregation.a41_demo;

public class Dog implements IAnimal {
    @Override
    public void eat() {

    }

    // 应该是 不会飞的
    @Override
    public void fly() {

    }

    @Override
    public void swim() {

    }
}
