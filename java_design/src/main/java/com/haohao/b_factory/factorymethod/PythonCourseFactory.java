package main.java.com.haohao.b_factory.factorymethod;

public class PythonCourseFactory implements ICourseFactory {


    @Override
    public ICourse create() {
        return new PythonCourse();
    }
}
