package com.atguigu.java2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式三：实现Callable接口。————jDK5。新增
 * 如何理解实现Callable接口的方式创建多线程比实现Runnable更强大
 * call()可以有返回值
 * call()可以返回值，被外面的操作捕获，获取异常的信息
 * Callable是支持泛型的 Callable 和 FutrueTask 都支持泛型
 *
 * @author linlin
 * @create 2022-04-12 19:39
 */
//1、创建一个实现Callable的实现类
class NumThread implements Callable<Integer>{
    //2。实现call方法，将此线程需要执行的操作声明在call()中
    @Override
    public Integer call() throws Exception {
        int sum = 0;
       for(int i = 1; i <= 100; i++){
           if(i % 2 == 0){
               System.out.println(i);
               sum += i;
           }
       }
       return sum;
    }
}
public class ThreadNew {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        NumThread numThread = new NumThread();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(numThread);//3。创建Callable接口实现类的对象
        //get()返回值为FutureTask构造器参数Callable实现类重写的call()的返回值
        Thread thread = new Thread(futureTask);//4。将此Callable接口实现类的对象作为传递到FutureTask构造器中，创建FutureTask的对象
        thread.start();//6、获得callable的返回值
        System.out.println(futureTask.get()+"总和为");//futureTask实现了Runnable
    }
}
