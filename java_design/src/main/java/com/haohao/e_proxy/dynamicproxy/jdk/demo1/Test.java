package com.haohao.e_proxy.dynamicproxy.jdk.demo1;

/**
 * 媒婆帮助找对象的 动态代理的例子;
 */
public class Test {
    public static void main(String[] args) {
        try {
            Person obj = new JdkMeipo().getInstance(new Girl());
            obj.findLove();

        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {

        }
    }
}
