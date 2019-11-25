package com.haohao.designpatterns.i_adapter.thirdlogin.demo3;

import com.haohao.designpatterns.i_adapter.thirdlogin.ResultMsg;
import com.haohao.designpatterns.i_adapter.thirdlogin.SignInService;

public class PasswordForThirdAdapter extends SignInService implements IPasswordForThird {

    @Override
    public ResultMsg loginForQQ(String id) {
        return processLogin(id, LoginForQQAdapter.class);
    }

    @Override
    public ResultMsg loginForWechat(String id) {
        return processLogin(id, LoginForWechatAdapter.class);
    }

    @Override
    public ResultMsg loginForToken(String id) {
        return processLogin(id, LoginForTokenAdapter.class);
    }

    @Override
    public ResultMsg loginForTelephone(String telephone, String code) {
        return processLogin(telephone, LoginForTelephoneAdapter.class);
    }

    // 统一上面的公共方法, 根据传递过来的值, 执行各自的逻辑  是 简单工厂方法;
    //    --> 登录的各个方式是不同的, 但是结果都是可以登录进入  是 策略方法;

    // 这种写法是 模仿的 Sprig AOP 里面的写法写的, 希望多多的思考
    private ResultMsg processLogin(String key, Class<? extends ILoginAdapter> clazz) {
        try {
            ILoginAdapter adapter = clazz.newInstance();
            if (adapter.support(adapter)) {
                return adapter.login(key, adapter);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
