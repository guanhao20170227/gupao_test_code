package com.example.string;

public class StringTest {

    public static void main(String[] args) {

        String fs = "123";
        Float floatVar = Float.valueOf(fs);
        Integer intVar = Integer.valueOf(fs);
        String stringVar = String.valueOf(fs);
        fs = String.format("The value of the float variable is " +
                "%f, while the value of the integer " +
                "variable is %d, and the string " +
                "is %s", floatVar, intVar, stringVar);
        System.out.println(fs);
        System.out.println("*******************");
        System.out.printf("The value of the float variable is " +
                "%f, while the value of the integer " +
                "variable is %d, and the string " +
                "is %s \n", floatVar, intVar, stringVar);

        System.out.println("*******************");

        String str1 = "你";
        byte[] str1Bytes = str1.getBytes();
        System.out.println(getEncoding(str1));
        System.out.println(str1Bytes.toString());
        String str2 = "我";
        byte[] str2Bytes = str2.getBytes();
        System.out.println(getEncoding(str2));
        System.out.println(str2Bytes.toString());

        int a = str1.compareTo(str2);
        System.out.println(str1.compareTo(str2));

        System.out.println("abe".compareTo("abcd")); //ok


    }


    public static String getEncoding(String str) {
        String encode;
        encode = "UTF-16";
        try {
            if(str.equals(new String(str.getBytes(), encode))) {
                return encode;
            }
        } catch(Exception ex) {
        }

        encode = "ASCII";
        try	{
            if(str.equals(new String(str.getBytes(), encode))) {
                return "字符串<< " + str + " >>中仅由数字和英文字母组成，无法识别其编码格式";
            }
        } catch(Exception ex) {
        }

        encode = "ISO-8859-1";
        try {
            if(str.equals(new String(str.getBytes(), encode))) {
                return encode;
            }
        } catch(Exception ex) {
        }

        encode = "GB2312";
        try {
            if(str.equals(new String(str.getBytes(), encode))) {
                return encode;
            }
        } catch(Exception ex) {
        }

        encode = "UTF-8";
        try {
            if(str.equals(new String(str.getBytes(), encode))) {
                return encode;
            }
        } catch(Exception ex) {
        }

        /*
         *......待完善
         */

        return "未识别编码格式";
    }
}
