package com.haohao.designpatterns.i_adapter.thirdlogin;

public class SignInService {

    // 1 注册的方法;
    public ResultMsg register(String username, String password) {
        ResultMsg resultMsg = new ResultMsg(200, "注册成功", new Member());
        System.out.println(resultMsg.toString());
        return resultMsg;
    }

    // 2 登录的方法;
    public ResultMsg login(String username, String password) {
        System.out.println("Login Msg: username " +  username + " , password: " + password);
        return null;
    }

}
