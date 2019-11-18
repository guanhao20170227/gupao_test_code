package com.haohao.a_seven_principle.a5_demeter.a52_upgrade1;

import java.util.ArrayList;
import java.util.List;

public class TeamLeader {

    public void getOnlineCounts() {
        List<Course> courses = new ArrayList<Course>();
        for (int i = 0; i < 20; i++) {
            courses.add(new Course());
        }
        System.out.println("线上课程数量是: " + courses.size());
    }
}
