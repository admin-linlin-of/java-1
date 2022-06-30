package com.atguigu.java;

/**
 * 测试Thread中的常用方法
 * 1。start()启动当前线程：调用当前线程的run()
 * 2。run()：通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明在此方法中
 * 3。currentThread():静态方法，返回当前代码的线程
 * 4。getName()：获取当前线程的名字
 * 5。setName(): 设置当前线程的名字 Thread也提供了构造器的方式给线程命名
 * 6。yield():   释放当前CPU的执行权，线程礼让。（不一定生效CPU可能再次让执行权给它）
 * 7。join()：   在线程a中调用线程b的join(),此时线程a就进入阻塞状态，直到线程b完全执行完成以后，线程a才结束阻塞状态。
 * 8。stop()：   已过时，当执行此方法时，强制结束生命周期
 * 9。sleep(long millitime):让当前线程“睡眠”指定的millitime毫秒数
 * 10。isAlive() 判断当前线程是否存活
 *
 * 线程的优先级
 * 1。
 * MAX_PRIORITY:10
 * MIN_PRIORITY:1
 * NORM_PRIORITY:5-->默认优先级
 * 2。如何获取和设置当前线程的优先级
 *    getPriority()：获取线程的优先级
 *    setPriority(int p):设置线程的优先级
 *    说明：高优先级的线程要抢占低优先级的线程cpu的执行权。但是只是从概率上讲，高优先级的线程高概率的情况下被执行。并不意味
 *    着只有当高优先级的线程执行完以后，低优先级的线程才执行。
 *
 * @author linlin
 * @create 2022-04-12 10:37
 */
public class ThreadMethod {
    public static void main(String[] args) throws InterruptedException {
        HelloThread h1 = new HelloThread("Thread:1");
//        h1.setName("线程一");
        h1.setPriority(Thread.MAX_PRIORITY);
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        h1.start();
        //给主线程命名
        Thread.currentThread().setName("mainThread___");
        System.out.println(Thread.currentThread().getName());
        for(int i = 0 ; i < 100 ; i++){
            System.out.println(Thread.currentThread().getName()+":"+i+"  "+Thread.currentThread().getPriority());
//            if(i == 30){
//                h1.join();
//            }
        }
        System.out.println(h1.isAlive());
    }

}
class HelloThread extends Thread{
    public HelloThread(String s) {
        super(s);
    }

    public void run(){
        for(int i = 0 ; i < 100 ; i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
//            if(i % 2 == 0){
//                this.yield();
//            }
//            try {
//                sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        System.out.println("HelloThread");
        System.out.println(Thread.currentThread().getName()+"  "+Thread.currentThread().getPriority());
    }
}