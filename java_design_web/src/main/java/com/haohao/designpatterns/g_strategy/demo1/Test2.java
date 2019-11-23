package com.haohao.designpatterns.g_strategy.demo1;

import org.apache.commons.lang3.StringUtils;

/***
 *  随着 活动的不断添加, 我们的 If-else 或是 switch 就会越来越多, 这样就不好了
 *      --> 利用 单例模式--注册式单例和简单工厂模式来 重构 DiscountActivity 实时
 *      --> 重构的代码写到 demo2 中
 */

public class Test2 {

    static DiscountActivity activity = null;

    public static void main(String[] args) {

        String discountKey = "EMPTY";
        for (int i = 0; i < 4; i++) {
            switch(i) {
                case 0:
                    discountKey = "COUPON";
                    chooseStrategyAndExecute(discountKey);
                    break;
                case 1:
                    discountKey = "CASHBACK";
                    chooseStrategyAndExecute(discountKey);
                    break;
                case 2:
                    discountKey = "GROUPBY";
                    chooseStrategyAndExecute(discountKey);
                    break;
                case 3:
                    discountKey = "EMPTY";
                    chooseStrategyAndExecute(discountKey);
                    break;
                default:
                    discountKey = "EMPTY";
                    chooseStrategyAndExecute(discountKey);
            }
        }
    }

    public static void chooseStrategyAndExecute(String discountKey) {
        if (StringUtils.equals(discountKey, "COUPON")) {
            activity = new DiscountActivity(new CouponStrategy());
        } else if (StringUtils.equals(discountKey, "CASHBACK")) {
            activity = new DiscountActivity(new CashbackStrategy());
        } else if (StringUtils.equals(discountKey, "GROUPBY")) {
            activity = new DiscountActivity(new GroupbyStrategy());
        } else {
            activity = new DiscountActivity(new EmptyStrategy());
        }

        activity.execute();
    }
}
