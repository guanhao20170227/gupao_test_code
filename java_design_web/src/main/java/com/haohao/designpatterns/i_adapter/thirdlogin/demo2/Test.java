package com.haohao.designpatterns.i_adapter.thirdlogin.demo2;

import com.haohao.designpatterns.i_adapter.thirdlogin.SignInService;

public class Test {

    public static void main(String[] args) {

        SignInWithThirdService service = new SignInWithThirdService();

        service.loginForQQ("121212121");

    }
}
