package com.example.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("((A)(B(C)))");
        Matcher matcher = pattern.matcher("One, (A)ABCD");
        System.out.println(matcher.groupCount()); // 4

        /*for (int i = 0; i < matcher.groupCount(); i++) {
            //System.out.println(matcher.group());
            System.out.println(matcher.group(i));
        }*/
    }
}
