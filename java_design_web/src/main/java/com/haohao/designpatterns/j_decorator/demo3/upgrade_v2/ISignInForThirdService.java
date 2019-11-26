package com.haohao.designpatterns.j_decorator.demo3.upgrade_v2;

import com.haohao.designpatterns.j_decorator.demo3.old_v1.ISignInService;
import com.haohao.designpatterns.j_decorator.demo3.old_v1.ResultMsg;

public interface ISignInForThirdService extends ISignInService {

    // 1 QQ 登录
    ResultMsg loginForQQ(String id);

    // 2 wechat 登录
    ResultMsg loginForWechat(String id);

    // 3 token 登录
    ResultMsg loginForToken(String token);

    // 4 telephone 登录, 用于扩展;
    // ResultMsg loginForTelephone(String telephone, String code);

    // 5 注册后, 自动登录;
    ResultMsg loginForRegister(String username, String password);
}
