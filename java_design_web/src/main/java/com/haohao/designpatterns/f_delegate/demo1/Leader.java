package com.haohao.designpatterns.f_delegate.demo1;

public class Leader {

    public String acceptCommandFromBoss(String command) {

        //  关于这里的 if-else 的优化, 等学习完成策略模式后在优化;
        if ("加密".equals(command)) {
            return new EmployeeA().acceptCommandFromLeader(command);
        } else if ("架构".equals(command)) {
            return new EmployeeB().acceptCommandFromLeader(command);
        } else {
            return "接收到的任务是 " + command + " , 现在没有员工可以处理这些事情.";
        }
    }
}
