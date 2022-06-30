package com.atguigu.java;

import java.io.IOException;

/**
 * 继承的规则
 * 1。子类的访问权限不能比父类的小，否则编译时报错
 * 2。返回类必须一致，否则编译时报错
 * 3。参数必须一致，否则就是方法的重载
 * 4。重写方法不能抛出新的异常或者比被重写方法声明的检查异常更广的检查异常。但是可以抛出更少，更有限或者不抛出异常。编译时报错
 * @author linlin
 * @create 2022-04-12 11:03
 */
public class inheritTest {}

class father{
    private void test1(){
        System.out.println("father method");
    }
    public void test2(){}
    public void test3(int a, int b){}
    public void test4() throws IOException{}
}
class son extends father{
//    private void test1(){ }
//    protected void test1(){ }
    public void test1(){  }
//    public int test2(){ return 1;}
    public void test3(float a){}
//    public void test4() throws IOException,InterruptedException{}
}