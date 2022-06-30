package com.atguigu.java;

/**
 * 创建一个实现了Runnable接口的类
 * 重写run()
 * 创建实现类的对象
 * 将此对象作为参数传到Thread的构造器中
 *
 *
 * 比较创建线程的两种的方法
 * 开发中：优先选择：实现Runnable接口的方式
 * 原因：1。实现的方式没有类的单继承性的局限性
 *      2。实现的方式更适合来处理共享数据的情况
 * 联系：public class Thread implements Runnable
 * 两种方式都需要实现run()方法，实现业务处理
 *
 * @author linlin
 * @create 2022-04-12 12:12
 */
public class RunnableTest {
    public static void main(String[] args) {
        Thread testThead = new Thread(new ThreadTest1());
        testThead.start();
        //问题1：为什么Thread的start()方法调用的是接实现的run()看源码
//        @Override
//        public void run() {
//            if (target != null) {
//                target.run();
//            }
//        }
//          /* What will be run. */
//    private Runnable target;
//        由此可见在执行前会前判断是否有Runnable实现对象

        //再启动一个线程，遍历100内的偶数
        new Thread(new Runnable(){
            public void run(){
                for(int i = 0 ; i < 100 ; i++){
                    if(i % 2 == 0){
                        System.out.println(Thread.currentThread().getName()+":"+i);
                    }
                }
            }
        }).start();
    }
}
class ThreadTest1 implements Runnable{

    @Override
    public void run() {
        for(int i = 0 ; i < 100 ; i++){
            if(i % 2 == 0){
                System.out.println("i:"+i);
            }
        }
    }
}
