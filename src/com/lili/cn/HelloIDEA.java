package com.lili.cn;

public class HelloIDEA {



}
class aa{
    public static void main(String[] args) {
        aa aa1 = new aa();
    }
    public aa(){
        System.out.println("我是构造块");
    }
    static{
        System.out.println("我是静态块");
        System.out.println();
    }
    {
        System.out.println("我是代码中的块");
    }
}