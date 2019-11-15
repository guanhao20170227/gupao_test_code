package com.example.time;

import java.util.Calendar;

public class CalendarTest {

    public static void main(String[] args) {

        Calendar cal = Calendar.getInstance();

        cal.set(2019, 11, 15);
        System.out.println(cal.toString());
        System.out.println("TomeZone: " + cal.getTimeZone());

        boolean bool = (2004 & 3) == 0 ? true : false ;
        System.out.println(bool);

    }
}
