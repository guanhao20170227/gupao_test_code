package com.haohao.designpatterns.a_seven_principle.a5_demeter.a51_demo;

public class Test {

    public static void main(String[] args) {
        Boss boss = new Boss();
        TeamLeader teamLeader = new TeamLeader();
        boss.getCountByTeamLeader(teamLeader);
    }
}
