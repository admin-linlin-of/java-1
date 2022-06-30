package com.atguigu.java;

/**
 * 使用同步方法解决同步问题
 * @author linlin
 * @create 2022-04-12 15:23
 */
class Window3 implements Runnable{
    private int ticket = 100;
    Object obj = new Object();
    @Override
    public void run() {

        while(true) {
            show();
        }

    }
    public synchronized void show(){//同步监视器:this
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + ":卖票，标号为" + ticket);
            ticket--;
        }
    }
}
public class WindowTest3 {
    public static void main(String[] args) {
        Window3 w = new Window3();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);
        //这是三百张票，还是一百张票，一百张，因为只有一个window1对象
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();

    }
}