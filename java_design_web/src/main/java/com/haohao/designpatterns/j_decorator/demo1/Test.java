package com.haohao.designpatterns.j_decorator.demo1;

public class Test {

    public static void main(String[] args) {

        // 1 基本的套餐
        Pancake pancake = new Pancake();
        String msg = pancake.getMsg();
        int price = pancake.getPrice();
        System.out.println("基础套餐: " + msg + " ,价格是: " + price);

        //2 加鸡蛋的套餐
        PancakeWithEgg pancakeWithEgg = new PancakeWithEgg();
        String msgWithEgg = pancakeWithEgg.getMsg();
        int priceWithEgg = pancakeWithEgg.getPrice();
        System.out.println("鸡蛋套餐: " + msgWithEgg + " ,价格是: " + priceWithEgg);

        // 3 加鸡蛋和火腿肠的套餐
        PancakeWithEggAndSausage pancakeWithEggAndSausage = new PancakeWithEggAndSausage();
        String msgWithEggAndSausage = pancakeWithEggAndSausage.getMsg();
        int priceWithEggAndSausage = pancakeWithEggAndSausage.getPrice();
        System.out.println("鸡蛋套餐: " + msgWithEggAndSausage + " ,价格是: " + priceWithEggAndSausage);

    }
}
