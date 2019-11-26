package com.haohao.designpatterns.k_observer.demo5;

import com.google.common.eventbus.Subscribe;

public class Teacher1 {

    private String name;

    public Teacher1(String name) {
        this.name = name;
    }

    @Subscribe
    public void getQuestion(Question question) {
        System.out.printf("%s 老师, 接受到 来自 %s 的问题， 具体的问题是: \n %s",
                this.name, question.getUsername(), question.getContent());
    }
}
