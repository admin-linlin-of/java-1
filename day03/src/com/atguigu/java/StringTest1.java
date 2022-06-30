package com.atguigu.java;

import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * String类与其他结构 之间的转换
 * @author linlin
 * @create 2022-04-18 14:46
 */
public class StringTest1 {
    /*
    复习
    String 与基本数据类型、包装类之间的转换。
    String --> 基本数据类型、包装类：调用包装类的静态方法：parseXXX(str)
    基本数据类型、包装类-->String:调用Stringt重载的valueOf(xxx)

     */
    @Test
    public void test1(){
        String str1 = "123";
        int num = Integer.parseInt(str1);
        String str2 = String.valueOf(num);
    }
    /*
    String 与 char[]之间的转换：调用String的toCharArray

     */
    @Test
    public void test2(){
        String str1 = "abc123";

        char[] charArray = str1.toCharArray();
        for(int i = 0; i < charArray.length; i++){
            System.out.println(charArray[i]);
        }

        char[] arr = new char[]{'h','e','l'};
        String arrr = new String(arr);
    }

    /**
     * String与byte[] 之间的转换
     * String --> byte[]:调用String的getBytes()
     */
    @Test
    public void test3() throws UnsupportedEncodingException {
        String str1 = "abc123中国";
        byte[] bytes = str1.getBytes();//使用默认字符集转换
        System.out.println(Arrays.toString(bytes));
        System.out.println(Arrays.toString(str1.getBytes("utf-8")));
        String str2 = new String(bytes);//使用默认字符集，进行编码 解码
        System.out.println(str2);
        String str3 = new String(bytes,"gbk");
        System.out.println(str3);
    }
}
