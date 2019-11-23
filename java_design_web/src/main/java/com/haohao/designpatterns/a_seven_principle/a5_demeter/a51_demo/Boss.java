package com.haohao.designpatterns.a_seven_principle.a5_demeter.a51_demo;

import java.util.ArrayList;
import java.util.List;

public class Boss {

    public void getCountByTeamLeader(TeamLeader teamLeader) {
        List<Course> courses = new ArrayList<Course>();
        for (int i = 0; i < 20; i++) {
            courses.add(new Course());
        }
        teamLeader.getCountOfCoursesOnline(courses);
    }
}
