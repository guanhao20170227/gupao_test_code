package com.haohao.e_proxy.dynamicproxy.cglib;

import net.sf.cglib.core.DebuggingClassWriter;

public class CglibProxyTest {

    public static void main(String[] args) {

        // add this to save the proxy to store
        // 添加这一行用于将 内存中的代理类 class 写入磁盘;
        String classPath = Girl.class.getResource("").getPath();
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,
                classPath);

        Girl girl = (Girl) new CglibMeipo().getInstance(Girl.class);
        girl.findLove();
    }
}
