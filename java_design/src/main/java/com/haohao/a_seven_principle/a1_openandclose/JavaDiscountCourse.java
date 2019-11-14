package main.java.com.haohao.a_seven_principle.a1_openandclose;

public class JavaDiscountCourse extends JavaCourse {

    public JavaDiscountCourse(Integer id, String name, Double price) {
        super(id, name, price);
    }

    // 8 折优惠的价格;
    @Override
    public Double getPrice() {
        return super.getPrice() * 0.8;
    }

    //
    public Double getOriginalPrice() {
        return super.getPrice();
    }
}
