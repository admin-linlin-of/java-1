package com.atguigu.java;

import org.junit.jupiter.api.Test;

/**
 * @author linlin
 * @create 2022-04-18 13:56
 */
public class StringMethodTest {
    @Test
    public void test1(){
        String s1 = "HelloWorld";
        System.out.println(s1.length());
        System.out.println(s1.charAt(0));
        System.out.println(s1.isEmpty());
        System.out.println(s1.toLowerCase());
        System.out.println(s1.toUpperCase());
        System.out.println(s1.trim());
        System.out.println("HelloWrold".equalsIgnoreCase(s1));//忽略大小写
        System.out.println("a".concat("b"));//相同与+

        String s2 = "abc";
        String s3 = s2.concat("abe");
        System.out.println(s2.compareTo(s3));//涉及到字符串排序

        System.out.println(s1.substring(2));
        System.out.println(s1.substring(2,5));//从0开始，不包括5，只包括4
    }
    @Test
    public void test2(){
        String s1="abc";
        String s2="abe";
        System.out.println(s1.compareTo(s2));
        System.out.println("abc".compareTo("abe"));
    }
    @Test
    public void test3(){
        String str1 = "helloWorld";
        boolean b1 = str1.endsWith("ld");//以指定字符结尾
        System.out.println(b1);

        boolean b2 = str1.startsWith("He");
        System.out.println(b2);

        boolean b3 = str1.startsWith("11",2);//从第几个字符开始，以什么字符开头
        System.out.println(b3);

        String str2 = "wo";
        System.out.println(str1.contains(str2));//2是否包含在1中

        System.out.println(str1.indexOf("Wo"));//有返回索引，无返回-1

        System.out.println(str1.indexOf("lo",5));//返回最后一个出现的位置

        System.out.println(str1.lastIndexOf("Wo"));//从后住前找，第一个找到的字符串的位置

        System.out.println(str1.lastIndexOf("o",5));
        //lastIndexOf indexOf相同
//        str为一，会不存在在为-1
    }
    @Test
    public void test4(){
        String str = "北边";
        String str2 = str.replace('北','东');
        String str3 = str.replace(str,"南边");
        String str4 = str.replaceAll("\\d",",");
        String str5 = str.replaceFirst("\\d",",");

        String tel = "0571-43434343";
        boolean reuslt = tel.matches("0571-\\d{7,9}");
        System.out.println(reuslt);
        String[] newString = "1|2|3".split("|");
    }
}
