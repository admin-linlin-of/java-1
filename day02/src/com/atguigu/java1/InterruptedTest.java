package com.atguigu.java1;

/**
 * interrupt()方法的工作仅仅是改变中断状态，并不是直接中断正在运行的线程。
 * .wait(),Thread.join()或sleep()方法阻塞时，调用interrupt()方法后改变中断状态，
 * 而wait/join/sleep这些方法内部会不断地检查线程的中断状态值，
 * 当发现中断状态值改变时则抛出InterruptedException异常，
 * 从而结束阻塞；对于没有阻塞的线程，调用interrupt()方法是没有任何作用。
 * @author linlin
 * @create 2022-04-13 13:23
 */
public class InterruptedTest implements Runnable{
    @Override
    public void run() {
        try{
            for(int i = 0; i < Integer.MAX_VALUE; i++){
                if(Thread.interrupted()){
                    System.out.println("已经中断，运行次数为：" + i);
                    throw new InterruptedException();
                }
            }
        } catch(InterruptedException e){
            System.out.println("线程catch 方法");
        }
    }
}

class Test {
    public static void main(String[] args) {
        try {
            InterruptedTest test = new InterruptedTest();
            Thread thread = new Thread(test);
            thread.start();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            thread.interrupt();
        } catch (Exception e) {
            System.out.println("main catch方法");
        }

    }
}