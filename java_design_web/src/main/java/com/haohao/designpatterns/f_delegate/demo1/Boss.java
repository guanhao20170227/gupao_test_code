package com.haohao.designpatterns.f_delegate.demo1;

public class Boss {

    public Leader leader ;

    public Boss(Leader leader) {
        this.leader = leader;
    }

    public String sendCommand(String command) {

        return this.leader.acceptCommandFromBoss(command);
    }
}
