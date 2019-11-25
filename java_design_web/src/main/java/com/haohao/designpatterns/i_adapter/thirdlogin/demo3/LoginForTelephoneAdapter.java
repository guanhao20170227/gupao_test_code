package com.haohao.designpatterns.i_adapter.thirdlogin.demo3;

import com.haohao.designpatterns.i_adapter.thirdlogin.ResultMsg;

public class LoginForTelephoneAdapter implements ILoginAdapter {
    @Override
    public Boolean support(Object adapter) {
        return adapter instanceof LoginForTelephoneAdapter;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {
        return null;
    }
}
