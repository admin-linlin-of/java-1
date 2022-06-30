package com.atguigu.java;

/**
 * @author linlin
 * @create 2022-04-12 15:29
 */

public class WindowTest4 {
    public static void main(String[] args) {
        Window4 t1 = new Window4();
        Window4 t2 = new Window4();
        Window4 t3 = new Window4();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
class Window4 extends Thread{
    private static int ticket = 100;
    static Object  obj = new Object();//任何对象都行
    public  void run(){
            while(true){
                show();
            }
    }
//    public synchronized void show(){//这时同步监视器为THIS即t1 t2 t3 错误
    public static synchronized void show(){//同步监视器为class
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + ": 卖票，票号为：" + ticket);
            ticket--;
        }
    }
}
