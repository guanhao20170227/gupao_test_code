package com.haohao.designpatterns.c_singleton.containersingleton;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * spring 中 的单例模式;
 */
public class ContainerSingleton implements Serializable {
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
    private static int count = 0;

    static {
        ContainerSingleton singleton = new ContainerSingleton();
        map.put(singleton.getClass().getName(), singleton);
    }

    private ContainerSingleton() {
        //synchronized (ContainerSingleton.class) {
            /*if (count > 0) {
                throw new RuntimeException("创建了多个实例。");
            }
            count ++;*/
        //}

        // 添加这个防止 反射破话单例;
        if (map.get(ContainerSingleton.class.getName()) != null) {
            throw new RuntimeException("已经存在实例了.");
        }
    }

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

    public  Object readResolve() {
        return map.get(ContainerSingleton.class.getName());
    }

}
