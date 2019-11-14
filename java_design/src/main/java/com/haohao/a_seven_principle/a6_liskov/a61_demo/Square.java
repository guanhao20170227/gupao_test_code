package main.java.com.haohao.a_seven_principle.a6_liskov.a61_demo;

public class Square extends Rectangle {

    private Long length;

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    // 重写的 父类的方法
    public Long getHeight() {
        return getLength();
    }

    public void setHeight(Long height) {
        setLength(height);
    }

    public Long getWidth() {
        return getLength();
    }

    public void setWidth(Long width) {
        setLength(width);
    }

}
