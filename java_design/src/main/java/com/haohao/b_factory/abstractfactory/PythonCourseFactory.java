package com.haohao.b_factory.abstractfactory;

public class PythonCourseFactory implements CourseFactory {
    @Override
    public IVideo createVideo() {
        return new PythonVideo();
    }

    @Override
    public INote createNote() {
        return new PythonNote();
    }
}
