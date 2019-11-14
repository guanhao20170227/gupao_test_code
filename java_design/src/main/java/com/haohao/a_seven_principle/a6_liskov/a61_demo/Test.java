package main.java.com.haohao.a_seven_principle.a6_liskov.a61_demo;

import java.util.Objects;

public class Test {


    public static void resize(Rectangle rectangle) {
        while (rectangle.getWidth() >= rectangle.getHeight()) {
            rectangle.setHeight(rectangle.getHeight() + 1);
            System.out.println("Rectangle width: " + rectangle.getWidth() + " ,Rectangle height: " + rectangle.getHeight());
        }
        System.out.println("resize() 方法已經結束: Height: " + rectangle.getHeight() + " ,Width: " + rectangle.getWidth());
    }

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(20L);
        rectangle.setWidth(30L);
        resize(rectangle);
    }
}
