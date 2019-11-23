package com.haohao.designpatterns.b_factory.simplefactory.nousesimplefactory;


import com.haohao.designpatterns.b_factory.simplefactory.ICourse;
import com.haohao.designpatterns.b_factory.simplefactory.JavaCourse;
import com.haohao.designpatterns.b_factory.simplefactory.PythonCourse;

/**
 *  使用 new JavaCourse() 来创建 Course
 *  --
 *  新需求 添加一个 Python 的课程;
 *      我需要新加一个 PythonCourse 类
 *          还要添加 new PythonCourse 的测试方法;
 *
 */
public class Test {

    public static void main(String[] args) {
        ICourse javaCourse = new JavaCourse();
        javaCourse.record();

        // 需要新加
        ICourse pythonCourse = new PythonCourse();
        pythonCourse.record();

    }
}
