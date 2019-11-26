package com.haohao.designpatterns.k_observer.demo5;

public class Question {

    private String username;// 提出问题人
    private String content; // 问题的内容



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
