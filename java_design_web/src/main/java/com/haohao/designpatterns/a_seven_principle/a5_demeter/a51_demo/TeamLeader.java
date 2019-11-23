package com.haohao.designpatterns.a_seven_principle.a5_demeter.a51_demo;

import java.util.List;

public class TeamLeader {

    public void getCountOfCoursesOnline(List<Course> courses) {
        System.out.println("线上课程的数量是: " + courses.size());
    }
}
