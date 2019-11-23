package com.haohao.designpatterns.g_strategy.demo1;

/**
 *  场景说明: 就是商家办一个促销活动, 促销的方式有 -> : 返现, 反优惠券, 团购, 没有优惠 4 中方式;
 */

public class Test {

    /**
     *      策略只是会选择一种, 所以就需要添加判断,
     *      --> 改进到 demo1/Test2 中
     * @param args
     */
    public static void main(String[] args) {

        DiscountActivity discountActivityFor618 = new DiscountActivity(new CouponStrategy());
        discountActivityFor618.execute();

        DiscountActivity discountActivityFor315 = new DiscountActivity(new CashbackStrategy());
        discountActivityFor315.execute();

        DiscountActivity discountActivityFor1111 = new DiscountActivity(new GroupbyStrategy());
        discountActivityFor1111.execute();

        DiscountActivity discountActivityForNormalDay = new DiscountActivity(new EmptyStrategy());
        discountActivityForNormalDay.execute();

    }
}
