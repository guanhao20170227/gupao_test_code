package com.haohao.d_prototype.deepcloneandsingleton;

/**
 * 实现深度克隆的单实例
 */
public class DeepCloneSingleton implements Cloneable {

    // 方法1, 继承 Cloneable, 重写 clone 方法;
    private static final DeepCloneSingleton INSTANCE = new DeepCloneSingleton();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return INSTANCE;
    }

    private DeepCloneSingleton() {
        if (INSTANCE != null) {
            throw new RuntimeException("不能创建多个实例");
        }
    }

    public static DeepCloneSingleton getInstance() {
        return INSTANCE;
    }
}
