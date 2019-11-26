package com.haohao.designpatterns.j_decorator.demo3.old_v1;

public interface ISignInService {

    // 1 注册的方法
    ResultMsg register(String username, String password);

    // 2 登录的方法
    ResultMsg login(String username, String password);
}
