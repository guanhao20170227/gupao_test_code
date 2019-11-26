package com.haohao.designpatterns.k_observer.demo1;

import java.util.Observable;
import java.util.Observer;

public class Teacher implements Observer {

    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        GPer gper = (GPer) o;
        Question question = (Question)arg;
        System.out.println("====================");
        System.out.printf("%s 老师, 你好! \n 您收到一个来自 %s 的提问, 希望您解答, " +
                        "问题内容如下: \n %s \n 提问者: %s \n", this.name, gper.getName(),
                question.getContent(), question.getUsername());
    }
}
