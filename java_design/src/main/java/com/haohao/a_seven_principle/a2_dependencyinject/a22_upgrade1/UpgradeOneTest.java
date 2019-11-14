package main.java.com.haohao.a_seven_principle.a2_dependencyinject.a22_upgrade1;

public class UpgradeOneTest {

    public static void main(String[] args) {

        Person person = new Person();
        person.study(new JavaCourse());

        person.study(new PythonCourse());

        person.study(new AICourse());
    }


}
