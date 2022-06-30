package com.atguigu.java;

import org.junit.Test;

/**
 * @author linlin
 * @create 2022-04-13 14:33
 */
public class StringTest {
    /**
     * String:字符串，使用一对“”引起来表示
     * String声明为final的，不可被继承
     * String实现了Serializable接口：支持序列化
     *       实现了Comparable接口：可以比较大小
     * String内部定义了final char[] value用于存储字符串数据
     * String:代表不可变的字符序列
     *              体现1当对字符串重新赋值时，不会改变，而是直接在常量池中开辟一个新的
     * 通过字面量赋值，是放在常量池中，区别于new()是放在堆中JDK8中字符串常量池中会引用堆中的String对象
     *
     *
     * String s1 = new String("abc");一个堆对象一个char[]放在常量池
     *
     */
    @Test
    public void test1(){
        String s1 = "abc";//字面量的定义方式
        String s2 = "abc";
//        s1 = "hello";
        s1.intern();

        System.out.println(s1 == s2);
        Person p = new Person("abc",12);
        Person p1 = new Person("abc",11);
        System.out.println(p.name == p1.name);

    }
}
class Person{
    String name;
    int age;
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }

}
