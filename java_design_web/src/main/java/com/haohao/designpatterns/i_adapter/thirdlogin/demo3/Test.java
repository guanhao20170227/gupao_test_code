package com.haohao.designpatterns.i_adapter.thirdlogin.demo3;

public class Test {
    public static void main(String[] args) {

        IPasswordForThird passwordForThird = new PasswordForThirdAdapter();
        passwordForThird.loginForQQ("121212");

    }
}
