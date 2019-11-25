package com.haohao.designpatterns.i_adapter.thirdlogin.demo3;

import com.haohao.designpatterns.i_adapter.thirdlogin.ResultMsg;

/**
 *  第三方: 兼容的接口;
 */
public interface IPasswordForThird {

    // QQ 登录;
    ResultMsg loginForQQ(String id);

    // 微信登录;
    ResultMsg loginForWechat(String id);

    // token 登录;
    ResultMsg loginForToken(String id);

    // 留一个扩展点; loginForTelephone(String telephone, String code)
    ResultMsg loginForTelephone(String telephone, String code);
}
