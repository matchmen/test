package com.mt.mythread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MythreadApplication {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Book book = new Book();

        executorService.execute(() -> {
            for (; ; ) {
                book.produce();
            }
        });


        executorService.execute(() -> {
            for (; ; ) {
                book.consumer();
            }
        });


    }


}
