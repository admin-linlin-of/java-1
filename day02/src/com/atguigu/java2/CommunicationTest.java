package com.atguigu.java2;

/**
 * 线和的通信
 * 操作共享数据时互相交流
 * 使用两个线程，交替打印1-100内的数
 *
 * 涉及到的三个方法：
 * wait()：一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器
 * notify():一旦执行此方法，就会唤醒被wait的一个线程。如果有多个线程被wait，就唤醒优先级高的那个。
 * notifyAll()：一旦执行此方法，就会唤醒所有被wait的线程
 *
 * 说明：
 * 1。wait(),notify(),notifyAll()三个方法必须使用在同步代码块同步方法中。
 * 2。wait(),notify(),notifyAll()三个方法的调用者必须是同步代码块或同步方法中的同步监视器
 *          Exception in thread "线程二" Exception in thread "线程一" java.lang.IllegalMonitorStateException
 * 3。这三个方法定在java.lang.Object中
 *
 * 面试题：sleep()和wait()的异同
 * 1。相同点：一旦执行方法，都可以使得当前的线程进入阻塞状态
 * 2。不同点：1》两个方法声明的位置不同：Thread类中声明sleep()，Object类中声明wait()
 *            2》调用的要求不同：sleep()可以在任何需要的场景下调用，wait()必须使用在同步代码块和同步方法中
 *            3》关于是否释放同步监视器：如果两个方法都使用在同步代码块中sleep（）只阻塞不释放资源
 *                                                                    notify()又阻塞又释放资源
 * @author linlin
 * @create 2022-04-12 17:12
 */
class Number implements Runnable{
    private int number = 1;
    Object obj = new Object();
    @Override
    public void run() {

            while (true) {
                synchronized(this) {
                    this.notify();
                if (number <= 100) {
//                    Thread.suspend();
                    try {
                        Thread.sleep(100);//sleep阻塞线程不释放锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " " + number);
                    number++;
                    try {
                        wait();//wait阻塞线程后释放锁，其它的线程可以接着使用。
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } else {
                    break;
                }
            }
        }
    }
}
public class CommunicationTest {
    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程一");
        t2.setName("线程二");

        t1.start();
        t2.start();
    }
}
