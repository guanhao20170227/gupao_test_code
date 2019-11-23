package com.haohao.designpatterns.g_strategy.demo3;

import java.util.HashMap;
import java.util.Map;

/***
 *  还是使用 注册式的单例 + 工厂模式 来实现;
 */
public class PayStrategy {

    public static final String ALIPAY = "AliPay";
    public static final String JDPAY = "JdPay";
    public static final String UNIONPAY = "UnionPay";
    public static final String WECHATPAY = "WechatPay";
    public static final String DEFAULT = ALIPAY;

    private static Map<String, Payment> payStrategyMap = new HashMap<String, Payment>();
    private static Map<String, PayStrategy> instanceMap = new HashMap<String, PayStrategy>();

    static {
        payStrategyMap.put(ALIPAY, new AliPay());
        payStrategyMap.put(JDPAY, new AliPay());
        payStrategyMap.put(UNIONPAY, new AliPay());
        payStrategyMap.put(WECHATPAY, new WechatPay());

        instanceMap.put(PayStrategy.class.getName(), new PayStrategy());
    }

    private PayStrategy() {
        // 1 防止反射破坏单例
        if (instanceMap.get(PayStrategy.class.getName()) != null) {
            throw new RuntimeException("不能创建多个实例.");
        }
    }

    // 提供对外的访问点
    public static PayStrategy getInstance() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if (instanceMap.get(PayStrategy.class.getName()) == null) {
            instanceMap.put(PayStrategy.class.getName(), (PayStrategy) Class.forName(PayStrategy.class.getName()).newInstance());
        }
        return instanceMap.get(PayStrategy.class.getName());
    }

    // 2 防止序列化 破坏单例
    public Object readResolve() { return instanceMap.get(PayStrategy.class.getName());}


    // 获取 支付策略
    public static Payment get(String discountKey) {
        if (!payStrategyMap.containsKey(discountKey)) {
            return payStrategyMap.get(DEFAULT);
        }
        return payStrategyMap.get(discountKey);
    }
}
