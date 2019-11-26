package com.haohao.designpatterns.k_observer.demo5;

import com.haohao.designpatterns.k_observer.demo1.Teacher;

public class Test {

    public static void main(String[] args) {

        Teacher1 teacher1 = new Teacher1("Tom");
        Teacher2 teacher2 = new Teacher2("Mic");

        Question question = new Question();
        question.setUsername("小明");
        question.setContent("请老师详细的讲解 观察者设计模式.\n");

        EventBusCenter.register(teacher1);
        EventBusCenter.register(teacher2);

        EventBusCenter.post(question);
    }
}
