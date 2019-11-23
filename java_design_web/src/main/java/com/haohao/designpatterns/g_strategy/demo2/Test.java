package com.haohao.designpatterns.g_strategy.demo2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        //// GROUPBUY, COUPON, EMPTY, CASHBACK
        /*new DiscountActivity("coupon").execute();
        new DiscountActivity("empty").execute();
        new DiscountActivity("cashback").execute();
        new DiscountActivity("groupbuy").execute();*/

        // new DiscountActivity("coupon").execute()
        DiscountActivity activity = new DiscountActivity("coupon");
        activity.execute();


        // 利用反射了测试一下 DiscountFactory 是不是单例的;
        Class clazz = DiscountStrategyFactory.class;
        Constructor c = clazz.getDeclaredConstructor(null);
        c.setAccessible(true);
        DiscountStrategyFactory factory1 = (DiscountStrategyFactory) c.newInstance();

        // DiscountStrategyFactory 没有提供一个对外开放的接口;
        // DiscountStrategyFactory discountStrategyFactory = new DiscountStrategyFactory();

        DiscountStrategyFactory factory2 = (DiscountStrategyFactory)c.newInstance();

        System.out.println(factory1 == factory2);

    }
}
