package main.java.com.haohao.a_seven_principle.a1_openandclose;

public class Test {

    public static void main(String[] args) {

        ICourse javaCourse = new JavaCourse(1,"Java", 9990d);
        System.out.println("Java Price: " + javaCourse.getPrice());

        ICourse javaDiscount = new JavaDiscountCourse(1,"Java", 9990d);
        System.out.println("Java Price 优惠后的价格: " + javaDiscount.getPrice());
    }
}
