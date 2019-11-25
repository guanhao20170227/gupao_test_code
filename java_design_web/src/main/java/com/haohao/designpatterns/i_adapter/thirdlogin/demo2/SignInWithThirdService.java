package com.haohao.designpatterns.i_adapter.thirdlogin.demo2;

import com.haohao.designpatterns.i_adapter.thirdlogin.ResultMsg;
import com.haohao.designpatterns.i_adapter.thirdlogin.SignInService;

/***
 *  创建一个新类, 继承以前的类, 这样就不用修改代码
 *      就可以保留以前的业务逻辑;
 *          -- 还可以使用 代理的方式也是可以实现 保留以前的业务逻辑的;
 */
public class SignInWithThirdService extends SignInService {

    /**
     * 1 openId 是全局 Id(加长的用户名)
     * 2 密码默认为 QQ_EMPTY
     * 3 注册 (在原有系统里面创建一个用户)
     * 4 调用原来的登录方法;
     */
    public ResultMsg loginForQQ(String openId) {
        return loginForRegister(openId, null);
    }

    public ResultMsg loginForWechat(String openId) {
        return null;
    }

    public ResultMsg loginForToken(String token) {
        return null;
    }

    public ResultMsg loginForTelephone(String telephone, String code) {
        return null;
    }

    public ResultMsg loginForRegister(String username, String password) {
        super.register(username, null);
        return super.login(username, null);
    }


}
