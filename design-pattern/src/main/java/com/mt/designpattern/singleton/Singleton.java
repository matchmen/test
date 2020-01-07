package com.mt.designpattern.singleton;

/**
 * 原型模式
 * 定义：jvm中只有一个类实例存在
 *
 * 懒汉模式: 启动时不做初始化，使用时再做初始化
 *  注意：为防止并发环境下多个线程同时做初始化，要保证线程安全
 *  两种实现方式:
 *  a:
 *
 * author: liqm
 * 2019-10-19
 */
public class Singleton {

    private static Singleton lazyParttern;

    private static Singleton hungerPattern = new Singleton();
    //构造函数私有化
    private Singleton(){}

    /**
     * 懒汉模式
     *
     * synchronized保证线程安全
     * 策略：
     * 1.为什么不用synchronized修饰getInstance()方法？先看看我们保证线程安全的目的，防止多线程并发初始化LazySingleton，
     *      最终需要同步的代码只有lazySingleton = new LazySingleton()，如果加在getInstance方法上，不管LazySingleton已经被初始化
     *      还是未初始化，并发环境下调用getInstance方法都会是同步的，显然会影响效率
     * 2.第一个IF，如果被初始化了，即返回，这个比较好理解
     * 3.第二个IF比较关键。现在假设一下，去掉第二个IF，LazySingleton没有被初始化，两个线程A、B访问getInstance时都满足了lazySingleton==null条件，都进入了第一个IF，
     *      如果线程A拿到了锁，那B将被阻塞，线程A完成初始化后释放了锁，B就能拿到锁,接下来B将再次做初始化，那LazySingleton就被初始化两次了，显然不对，第二个IF就是为了
     *      防止这种情况的发生
     *
     * @return
     */
    public static Singleton getLazyInstance(){

        if(lazyParttern==null){
            synchronized (Singleton.class) {
                if (lazyParttern == null) {
                    lazyParttern = new Singleton();
                }
            }
        }
        return lazyParttern;
    }


    /**
     * 饿汉模式
     * 策略：
     * 加载即初始化
     * @return
     */
    private static Singleton getHungerInstance() {

        return hungerPattern;
    }




}
