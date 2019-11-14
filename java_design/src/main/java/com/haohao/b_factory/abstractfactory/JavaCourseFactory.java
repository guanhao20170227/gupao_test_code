package main.java.com.haohao.b_factory.abstractfactory;

public class JavaCourseFactory implements CourseFactory {

    @Override
    public IVideo createVideo() {
        return new JavaVideo();
    }

    @Override
    public INote createNote() {
        return new JavaNote();
    }
}
