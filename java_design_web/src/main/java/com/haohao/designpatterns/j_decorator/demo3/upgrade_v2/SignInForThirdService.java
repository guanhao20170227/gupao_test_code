package com.haohao.designpatterns.j_decorator.demo3.upgrade_v2;

import com.haohao.designpatterns.j_decorator.demo3.old_v1.ISignInService;
import com.haohao.designpatterns.j_decorator.demo3.old_v1.ResultMsg;

public class SignInForThirdService implements ISignInForThirdService {

    private ISignInService signIn;

    public SignInForThirdService(ISignInService signIn) {
        this.signIn = signIn;
    }

    @Override
    public ResultMsg register(String username, String password) {
        return signIn.register(username, password);
    }

    @Override
    public ResultMsg login(String username, String password) {
        return signIn.login(username, password);
    }

    @Override
    public ResultMsg loginForQQ(String id) {
        return new ResultMsg(200, "使用 QQ: " + id + " 登录.", "成功登录.");
    }

    @Override
    public ResultMsg loginForWechat(String id) {
        return null;
    }

    @Override
    public ResultMsg loginForToken(String token) {
        return null;
    }

    @Override
    public ResultMsg loginForRegister(String username, String password) {
        return null;
    }


}
