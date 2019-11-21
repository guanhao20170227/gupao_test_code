package com.haohao.e_proxy.staticproxy;

/**
 * 动态切换 数据源
 *
 */
public class DynamicDataSourceEntity {

    // 默认数据源
    public static final String DEFAULT_SOURCE = null;

    private static final ThreadLocal<String> local = new ThreadLocal<String>();

    // 私有的构造方法
    private DynamicDataSourceEntity() {}

    // 清空数据源
    public static void clear() {
        local.remove();
    }

    // 获取当前数据源的名字
    public static String get() {
        return local.get();
    }

    // 设置 当前数据源
    public static void set(String year) {
        local.set(year);
    }

    public static void set(Integer year) {
        local.set("DB_" + year);
    }

    // 重置数据源
    public static void restore() {
        local.set(DEFAULT_SOURCE);
    }
}
