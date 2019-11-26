package com.haohao.designpatterns.j_decorator.demo2;

public class Test {

    public static void main(String[] args) {
        // 1 基本的套餐
        Pancake pancake;
        pancake = new BasePancake();
        String baseMsg = pancake.getMsg();
        int basePrice = pancake.getPrice();
        System.out.println("基本套餐: " + baseMsg + " ,价格是: " + basePrice);

        //2 加鸡蛋的套餐
        pancake = new EggDecorator(pancake);
        String eggMsg = pancake.getMsg();
        int eggPrice = pancake.getPrice();
        System.out.println("加鸡蛋套餐: " + eggMsg + " ,价格是: " + eggPrice);




        // 3 加鸡蛋和火腿肠的套餐
        pancake = new SausageDecorator(pancake);
        String sausageMsg = pancake.getMsg();
        int sausagePrice = pancake.getPrice();
        System.out.println("加鸡蛋和火腿肠套餐: " + sausageMsg + " ,价格是: " + sausagePrice);

        // 4 在加一个鸡蛋

        pancake = new EggDecorator(pancake);
        String msg4 = pancake.getMsg();
        int price4 = pancake.getPrice();
        System.out.println("加鸡蛋和火腿肠在加一个鸡蛋套餐: " + msg4 + " ,价格是: " + price4);

    }
}
