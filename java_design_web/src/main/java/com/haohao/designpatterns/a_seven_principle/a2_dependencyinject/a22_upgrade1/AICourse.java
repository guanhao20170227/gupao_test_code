package com.haohao.designpatterns.a_seven_principle.a2_dependencyinject.a22_upgrade1;

public class AICourse implements ICourse {
    @Override
    public void study() {
        System.out.println("Start to study AICourse.");
    }
}
