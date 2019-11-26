package com.haohao.designpatterns.j_decorator.demo3.old_v1;

public class SignInService implements ISignInService {

    @Override
    public ResultMsg register(String username, String password) {
        return new ResultMsg(200, "注册成功", new Member());
    }

    @Override
    public ResultMsg login(String username, String password) {
        return null;
    }
}
