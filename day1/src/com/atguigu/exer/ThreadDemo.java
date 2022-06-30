package com.atguigu.exer;

/**
 * @author linlin
 * @create 2022-04-12 10:33
 */
public class ThreadDemo {
    public static void main(String[] args) {
        new Thread(){
            public void run(){
                System.out.println(Thread.currentThread().getName());
            }
        }.start();
        new Thread(){
            public void run(){
                System.out.println(Thread.currentThread().getName());
            }
        }.start();
    }
}
