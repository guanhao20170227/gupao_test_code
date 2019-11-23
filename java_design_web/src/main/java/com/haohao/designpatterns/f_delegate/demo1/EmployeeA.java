package com.haohao.designpatterns.f_delegate.demo1;

public class EmployeeA implements IEmployee {

    @Override
    public String acceptCommandFromLeader(String command) {
        StringBuffer sf = new StringBuffer();
        sf.append("我是员工A, 我接受到的任务是: " + command);
        sf.append(" ,现在我正在处理它");

        return sf.toString();
    }

    private void swimming() {
        System.out.println("I am EmployeeA, I like swimming.");
    }
}
