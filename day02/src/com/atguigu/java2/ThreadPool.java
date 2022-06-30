package com.atguigu.java2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 创建线程的方式四：使用线程池
 * @author linlin
 * @create 2022-04-12 20:17
 */
class NumberThread implements Runnable{
    @Override
    public void run() {
        for(int i = 0 ; i <= 100; i++){
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+"i:"+i);
            }
        }
    }
}
public class ThreadPool {
    public static void main(String[] args) {
       //
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1 = (ThreadPoolExecutor)service;
//      设置线程池的属性
        System.out.println(service.getClass());
        service1.setCorePoolSize(15);
//        service1.setKeepAliveTime(100000);


        service.execute(new NumberThread());//适合适用于Runnable
//        service.submit();//适合用于Callable
        service.shutdown();//关闭线程池
    }
}
