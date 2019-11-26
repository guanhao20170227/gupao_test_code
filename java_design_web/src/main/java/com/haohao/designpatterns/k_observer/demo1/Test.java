package com.haohao.designpatterns.k_observer.demo1;

public class Test {

    public static void main(String[] args) {

        GPer gper = GPer.getInstance();

        Teacher tom = new Teacher("tom");
        Teacher mic = new Teacher("mic");

        gper.addObserver(tom);
        gper.addObserver(mic);

        Question question = new Question();
        question.setUsername("小明");
        question.setContent("请老师详细讲解观察者模式.");

        gper.publishQuestion(question);

    }
}
