package main.java.com.haohao.a_seven_principle.a5_demeter.a52_upgrade1;

public class Test {
    public static void main(String[] args) {

        TeamLeader teamLeader = new TeamLeader();
        Boss boss = new Boss();
        boss.getOnLineCounts(teamLeader);
    }
}
