package main.java.com.haohao.c_singleton.containersingleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * spring 中 的单例模式;
 */
public class ContainerSingleton {

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
}
