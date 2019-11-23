package com.haohao.designpatterns.g_strategy.demo2;

import java.util.HashMap;
import java.util.Map;

public class DiscountStrategyFactory {

    private static Map<String, IDiscountStrategy> discount_strategy_map = new HashMap<String, IDiscountStrategy>();
    private static final IDiscountStrategy EMPTY_STRATEGY = new EmptyStrategy();

    static {
        discount_strategy_map.put(DiscountKey.COUPON.getName(), new CouponStrategy());
        discount_strategy_map.put(DiscountKey.CASHBACK.getName(), new CashbackStrategy());
        discount_strategy_map.put(DiscountKey.GROUPBUY.getName(), new GroupbyStrategy());
        discount_strategy_map.put(DiscountKey.EMPTY.getName(), new EmptyStrategy());
    }

    // 对外提供的访问接口
    private DiscountStrategyFactory() {

    }

    public static IDiscountStrategy getDiscountStrategy(String discountKey) {
        return discount_strategy_map.get(discountKey) == null ? EMPTY_STRATEGY : discount_strategy_map.get(discountKey);
    }

    enum DiscountKey {
        COUPON("coupon"),
        CASHBACK("cashback"),
        GROUPBUY("groupbuy"),
        EMPTY("empty");

        DiscountKey(String name) {
            this.name = name;
        }

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    /*public interface DiscountKey {
        static final String COUPON = "coupon";
        static final String CASHBACK = "cashback";
        static final String GROUPBUY = "groupbuy";
        static final String EMPTY = "empty";
    }*/
}
