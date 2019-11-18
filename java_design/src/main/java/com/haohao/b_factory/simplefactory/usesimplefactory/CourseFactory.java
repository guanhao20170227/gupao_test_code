package com.haohao.b_factory.simplefactory.usesimplefactory;

import main.java.com.haohao.b_factory.simplefactory.ICourse;
import main.java.com.haohao.b_factory.simplefactory.JavaCourse;
import main.java.com.haohao.b_factory.simplefactory.PythonCourse;

public class CourseFactory {

    // 第一种方法:
    /*public ICourse create(String name) {
        switch(name) {
            case "java":
                return new JavaCourse();
            case "python":
                return new PythonCourse();
            default:
                return null;
        }
    }*/

    // 使用 反射 来获取对象的实例;
    /*public ICourse create(String className) {
        try {
            if (!(null == className || "".equals(className))) {
                return (ICourse) Class.forName(className).newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }*/

    // 方法3: 传递一个 clazz 对象过来
    public ICourse create(Class<? extends ICourse> clazz) {
        try {
            if (null != clazz) {
                return clazz.newInstance();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
