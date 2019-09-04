package com.mt.mythread;

/**
 * author: liqm
 * 2019-09-03
 */
public class Book {

    private Integer num = new Integer(0);

    public synchronized void produce() {
        if (num < 100L) {
            this.num++;
            System.out.println(Thread.currentThread().getName() + ":生产1个,库存:" + this.num);
        }else {
            System.out.println(Thread.currentThread().getName() + ":仓库已满，暂停生成");
            try {
                wait(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public synchronized void consumer() {

        if (num > 0) {
            System.out.println(Thread.currentThread().getName() + ":消费前数量:" + this.num);
            this.num--;
            System.out.println(Thread.currentThread().getName() + ":消费1个，剩余:" + this.num);
        } else {
            System.out.println(Thread.currentThread().getName() + ":库存为0，暂停消费");
            try {
                wait(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public int getNum() {
        return this.num;
    }

}
