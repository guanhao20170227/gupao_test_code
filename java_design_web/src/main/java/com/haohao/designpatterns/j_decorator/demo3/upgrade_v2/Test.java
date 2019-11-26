package com.haohao.designpatterns.j_decorator.demo3.upgrade_v2;

import com.haohao.designpatterns.j_decorator.demo3.old_v1.ResultMsg;
import com.haohao.designpatterns.j_decorator.demo3.old_v1.SignInService;

public class Test {

    public static void main(String[] args) {

        ISignInForThirdService signInForThirdService = new SignInForThirdService(new SignInService());
        ResultMsg resultMsg = signInForThirdService.loginForQQ("121212121");
        System.out.println(resultMsg);

    }
}
