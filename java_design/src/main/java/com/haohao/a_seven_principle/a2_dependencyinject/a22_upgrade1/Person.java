package main.java.com.haohao.a_seven_principle.a2_dependencyinject.a22_upgrade1;

public class Person {

    public void study(ICourse course) {
        course.study();
    }
}
