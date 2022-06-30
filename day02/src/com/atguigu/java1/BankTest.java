package com.atguigu.java1;

/**
 * 使用同小机制将单例模式中的懒汉式必定为线程安全的
 * @author linlin
 * @create 2022-04-12 15:51
 */
public class BankTest {
}
class Bank{
    private Bank(){

    }
    private static Bank instance = null;

        public static  Bank getinstance() {
            //方式一：效率稍差
//            synchronized (Bank.class) {
//                if (instance == null) {
//                    instance = new Bank();
//                }
//                return instance;
//            }
            //方式一：效率稍高
            if(instance == null) {
                synchronized (Bank.class) {
                    if (instance == null) {
                        instance = new Bank();
                    }
                }
            }
            return instance;
        }
}