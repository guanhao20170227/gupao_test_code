package com.example.format;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatTest {

    public static void main(String[] args) {
       // DateFormat 不太好测试

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        SimpleDateFormat clone = (SimpleDateFormat) sdf.clone();
        System.out.println(sdf == clone); // false  说明是 深克隆
    }
}
