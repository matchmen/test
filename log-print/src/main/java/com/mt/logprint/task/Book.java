package com.mt.logprint.task;


import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

/**
 * author: liqm
 * 2019-09-03
 */
@Slf4j
public class Book {

    private Integer num = new Integer(0);

    private Set<String> list = new HashSet<String>();

    public synchronized void produce() {
        if (num < 10000000000L) {
            this.num++;
            list.add("当前数量:{}" + num);
            if (num % 10 == 0) {
                log.info("生产1个,库存:{}", this.list.size());
            }

        }else {
            log.info("仓库已满，暂停生成");
            try {
                wait(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public synchronized void consumer() {

        if (num > 0) {
            log.info("消费前数量:{}" ,this.list.size());
            this.num--;
            list.remove("当前数量:" + num);
            if (num % 100 == 0) {
                log.info("消费1个，剩余:{}", this.list.size());
            }
        } else {
            log.info("库存为0，暂停消费");
            try {
                wait(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


}
