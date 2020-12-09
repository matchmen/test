package com.mt.mythread.executor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.*;

/**
 * author: liqm
 * 2019-10-16
 */

/**
 *  1. -Xms 初始化堆大小，-Xmx 最大堆大小
 *
 *
 *
 */
public class ExecutorTest {

    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2, 100L, TimeUnit.MINUTES, new ArrayBlockingQueue<>(1000));

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Long st = System.currentTimeMillis();
        Vector<Long> runTimeList = new Vector<>();
        Vector<Long > wholeTimeList = new Vector<>();
        List<Future<?>> futureList = new ArrayList<Future<?>>();
        for (int i = 0; i < 50; i++) {
            //Future<?> submit = executor.submit(new CPUTypeTest(runTimeList, wholeTimeList));
            Future<?> submit = executor.submit(new IOTypeTest(runTimeList, wholeTimeList));
            futureList.add(submit);
        }

        for (int i = 0; i < futureList.size(); i++) {
            futureList.get(i).get();
        }
        long wholeTime = 0;
        for (int i = 0; i < wholeTimeList.size(); i++) {
            wholeTime = wholeTimeList.get(i) + wholeTime;
        }

        long runTime = 0;
        for (int i = 0; i < runTimeList.size(); i++) {
            runTime = runTimeList.get(i) + runTime;
        }
        //System.out.println("平均每个线程整体花费时间： " +wholeTime/wholeTimeList.size());
        //System.out.println("平均每个线程执行花费时间： " +runTime/runTimeList.size());

        System.out.println("耗时:" + (System.currentTimeMillis() - st));
        executor.shutdown();


    }


    static class CPUTypeTest implements Runnable {

        //整体执行时间，包括在队列中等待的时间
        List<Long> wholeTimeList;
        //真正执行时间
        List<Long> runTimeList;

        private long initStartTime = 0;

        /**
         * 构造函数
         * @param runTimeList
         * @param wholeTimeList
         */
        public CPUTypeTest(List<Long> runTimeList, List<Long> wholeTimeList) {
            initStartTime = System.currentTimeMillis();
            this.runTimeList = runTimeList;
            this.wholeTimeList = wholeTimeList;
        }

        /**
         * 判断素数
         * @param number
         * @return
         */
        public boolean isPrime(final int number) {
            if (number <= 1)
                return false;
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0)
                    return false;
            }
            return true;
        }

        /**
         * 計算素数
         * @return
         */
        public int countPrimes(final int lower, final int upper) {
            int total = 0;
            for (int i = lower; i <= upper; i++) {
                if (isPrime(i))
                    total++;
            }
            return total;
        }

        public void run() {
            long start = System.currentTimeMillis();
            countPrimes(1, 1_000_000);
            long end = System.currentTimeMillis();

            long wholeTime = end - initStartTime;
            long runTime = end - start;

            //wholeTimeList.add(wholeTime);
            //runTimeList.add(runTime);
            System.out.println("" + runTime);
//            System.out.println("平均每个线程整体花费时间： " +wholeTime/wholeTimeList.size());
        }

    }


     static class IOTypeTest implements Runnable {

        //整体执行时间，包括在队列中等待的时间
        Vector<Long> wholeTimeList;
        //真正执行时间
        Vector<Long> runTimeList;

        private long initStartTime = 0;

        /**
         * 构造函数
         * @param runTimeList
         * @param wholeTimeList
         */
        public IOTypeTest(Vector<Long> runTimeList, Vector<Long> wholeTimeList) {
            initStartTime = System.currentTimeMillis();
            this.runTimeList = runTimeList;
            this.wholeTimeList = wholeTimeList;
        }

        /**
         *IO操作
         * @return
         * @throws IOException
         */
        public void readAndWrite() throws IOException {
            File sourceFile = new File("D:/test.txt");
            //创建输入流
            BufferedReader input = new BufferedReader(new FileReader(sourceFile));
            //读取源文件,写入到新的文件
            String line = null;
            while((line = input.readLine()) != null){
                //System.out.println(line);
            }
            //关闭输入输出流
            input.close();
        }

        public void run() {
            long start = System.currentTimeMillis();
            try {
                readAndWrite();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            long end = System.currentTimeMillis();


            long wholeTime = end - initStartTime;
            long runTime = end - start;
//            wholeTimeList.add(wholeTime);
//            runTimeList.add(runTime);
            System.out.println("" + runTime);
            //System.out.println("单个线程花费时间：" + (end - start));
        }
    }

}
