package com.haohao.designpatterns.b_factory.simplefactory.usesimplefactory;

/***
 *  这个就是客户端的代码,
 *      客户端调用确实会简单一点, 不需要 new 对象了;
 */
public class Test {

    public static void main(String[] args) {
        CourseFactory factory = new CourseFactory();
        // 第一种 factory
       /* ICourse javaCourse = factory.create("java");
        javaCourse.record();

        ICourse pythonCourse = factory.create("python");
        pythonCourse.record();*/

       // 第二种 factory, 使用反射的方式
        /*ICourse javaCourse = factory.create("main.java.com.haohao.b_factory.simplefactory.JavaCourse");
        javaCourse.record();*/

        // 方法3: 直接传递 clazz 对象
        // ICourse javaCourse = factory.create(JavaCourse.class); // 这样就不好了, 又引入了 JavaCourse.class 的类， 方法2、1 都是可以的
        // javaCourse.record();

    }
}
