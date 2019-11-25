package com.haohao.designpatterns.h_template.networkcourse;

public class Test {

    public static void main(String[] args) {

        System.out.println("--- Java 架构师课程---");
        NetworkCourse javaCourse = new JavaCourse();
        javaCourse.createCourse();

        System.out.println("--- 大数据课程 ---");
        NetworkCourse bigDataCourse = new BigDataCourse(true);
        bigDataCourse.createCourse();

    }
}
