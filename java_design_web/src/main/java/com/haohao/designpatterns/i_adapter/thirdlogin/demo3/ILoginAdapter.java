package com.haohao.designpatterns.i_adapter.thirdlogin.demo3;

import com.haohao.designpatterns.i_adapter.thirdlogin.ResultMsg;

public interface ILoginAdapter {
    Boolean support(Object adapter);
    ResultMsg login(String id, Object adapter);
}
