package main.java.com.haohao.a_seven_principle.a2_dependencyinject.a21_demo;

public class DemoTest {

    public static void main(String[] args) {

        Person person = new Person();

        person.studyJavaCourse();
        person.studyPythonCourse();

        // new add
        person.studyAICourse();
    }
}
