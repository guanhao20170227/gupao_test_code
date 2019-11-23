package com.haohao.designpatterns.e_proxy.dynamicproxy.jdk.demo3;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.lang.reflect.Method;

/**
 * 尝试直接从 内存中获取 $Proxy0 对象;
 *
 *
 */
public class Test {
    public static void main(String[] args) {

        try {
            Object obj = new JdkMeipo().getInstance(new Girl());
            Method method = obj.getClass().getMethod("findLove", null);
            method.invoke(obj);

            // 通过反编译工具看到 $Proxy0 的源码
            byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Person.class});
            FileOutputStream fos = new FileOutputStream("I:\\develop\\code\\idea_code\\gupao_test_code\\java_design\\src\\main\\java\\com\\haohao\\e_proxy\\dynamicproxy\\jdk\\demo3\\$Proxy0.class");
            fos.write(bytes);

            fos.close();

        } catch(Exception ex) {
            ex.printStackTrace();
        }

    }
}
