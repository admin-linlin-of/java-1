package com.atguigu.java;

/**
 * 问题：卖票过程中，出现了重票和错票的问题
 * 出现的原因：当某个线程操作车票的过程中，尚未操作完成时，其他线程进来，进行操作
 * 如何解决：当一个线程在操作ticket的时候，其他线程不能参与进来。直到线程a操作完成ticket时，其他线程才可以开
 * 始操作ticket。这种情况即使线程a出现了阻塞，也不能被改变。
 * 4。在java中，我们通过同步机制，来解决线程的安全问题
 *
 *  方式一：同步代码块
 *      synchronized(同步监视器){
 *          //需要被 同步的代码
 *      }
 *      说明： 1操作共享数据的代码，即为需要被同步的代码
 *            2共享数据， 多个线程共同操作的变量。比如：ticket就是共离数据
 *            3同步监视器，俗称：锁。任何一个类的对象，都可以充当锁
 *                  要求：多个线程必须要共用同一把锁 Runnable在run()方法外定义，thread得是static的
 *            解决同步问题
 *            但是只能有一个线程参其他线程等侍。相当于是一个单线程的变慢
 *
 *            继承thread慎用this充当同步监视器，最好用Class对象
 *            Runnable的可以用this，根据情况而定
 *
 *            同步代码块不要包多也不能包少
 * 方式二：同步方法
 *      如果操作共享数据的代码完整的声明在一个方法，我们不妨将此方法声明同步
 *      关于同步方法的总结
 *      1.同步方法儋涉及到同步监视器，只是不需要我们显式的声明
 *      2.非静态的同步方法，同步监视器是this
 *      静态的同步方法，同步监视器是：当前类本身
 * @author linlin
 * @create 2022-04-12 11:29
 */
public class WindowTest {
    public static void main(String[] args) {
        Window t1 = new Window();
        Window t2 = new Window();
        Window t3 = new Window();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
class Window extends Thread{
    private static int ticket = 100;
    static Object  obj = new Object();//任何对象都行
    public void run(){
         synchronized (Window.class){//synchronized (obj) {//通类对象也行
            while(true){
                    if (ticket > 0) {
                                        try {
                                            Thread.sleep(100);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }

                        System.out.println(getName() + ": 卖票，票号为：" + ticket);
                        ticket--;
                    } else {
                        break;
                    }
                }
            }
    }
}
