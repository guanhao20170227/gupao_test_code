package com.haohao.c_singleton.containersingleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * spring 中 的单例模式;
 */
public class ContainerSingleton {
    //方法1: 感觉这种写法不对
    /*
    private static Map<String, Object> ioc = new ConcurrentHashMap<String, Object>();

    public static Object getBean(String className) {
        synchronized (ioc) { // 由于会有多线程的问题, 所以在这里添加了 同步锁
            if (!ioc.containsKey(className)) {
                Object obj = null;
                try {
                    obj = Class.forName(className).newInstance();
                    ioc.put(className, obj);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return obj;
            } else {
                return ioc.get(className);
            }
        }
    }
    */

    // 方法2: 使用静态代码块
    private static Map<String, ContainerSingleton> map = new ConcurrentHashMap<String, ContainerSingleton>();

    static {
        ContainerSingleton singleton = new ContainerSingleton();
        map.put(singleton.getClass().getName(), singleton);
    }

    private ContainerSingleton() {}

    public static ContainerSingleton getInstance(String name) {
        if (name == null) {
            name = ContainerSingleton.class.getName();
        }
        if (map.get(name) == null) {
            try {
                map.put(name, (ContainerSingleton) Class.forName(name).newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return map.get(name);
    }

}
