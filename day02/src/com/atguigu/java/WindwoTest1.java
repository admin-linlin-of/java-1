package com.atguigu.java;

/**
 * 使用Runnable 接口的方式实现卖票
 * @author linlin
 * @create 2022-04-12 12:29
 */
class Window1 implements Runnable{
    private int ticket = 100;
    Object obj = new Object();
    @Override
    public void run() {

            while(true) {
                synchronized(this){//synchronized(obj){这个this就是w，只一个，一个锁
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + ":卖票，标号为" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}
public class WindwoTest1 {
    public static void main(String[] args) {
        Window1 w = new Window1();
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
