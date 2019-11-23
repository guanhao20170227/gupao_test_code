package com.haohao.designpatterns.c_singleton.lazy.demo5;

import java.io.Serializable;

/**
 *  测试 序列化破坏 单例;
 */
public class SerializableSingleton implements Serializable {

    private static final SerializableSingleton INSTANCE = new SerializableSingleton();

    private SerializableSingleton() {}

    public static SerializableSingleton getInstance() {
        return INSTANCE;
    }

    // 单例里面添加 readResolve() 方法, 来解决序列化破坏单例的情况;
    public  Object readResolve() {
        return INSTANCE;
    }

}
