package com.haohao.designpatterns.k_observer.demo1;

import java.util.Observable;

public class GPer extends Observable {

    private String name = "GPer 生态圈";
    private static GPer gper = null;

    private GPer() {}

    public static GPer getInstance() {
        if (null == gper) {
            gper = new GPer();
        }
        return gper;
    }

    public String getName() {
        return name;
    }

    public void publishQuestion(Question question) {
        System.out.printf("%s , 在 %s 上提交了一个问题. \n", question.getUsername(), this.name);
        setChanged();
        notifyObservers(question);
    }
}
