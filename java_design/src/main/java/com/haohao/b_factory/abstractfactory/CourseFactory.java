package com.haohao.b_factory.abstractfactory;

public interface CourseFactory {

    IVideo createVideo();

    INote createNote();

    // 一旦新加一个 新的产品, 就会改动比较大, 需要每一个实现类都要改变
    // ISource createSource();
}
