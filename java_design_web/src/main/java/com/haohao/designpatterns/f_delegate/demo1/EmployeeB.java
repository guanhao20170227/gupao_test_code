package com.haohao.designpatterns.f_delegate.demo1;

public class EmployeeB implements IEmployee {


    @Override
    public String acceptCommandFromLeader(String command) {
        StringBuffer sf = new StringBuffer();
        sf.append("我是员工B, 我接受到的任务是: " + command);
        sf.append(" ,现在我正在处理它");

        return sf.toString();
    }

    private void drinkTea() {
        System.out.println("I am EmployeeB, I like drink tea.");
    }
}
