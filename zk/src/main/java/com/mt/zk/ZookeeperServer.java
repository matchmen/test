package com.mt.zk;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;

/**
 * author: liqm
 * 2019-10-29
 */
public class ZookeeperServer{

    private static MyZookeeper myZookeeper = new MyZookeeper();

    public static ZooKeeper getConnection(){

        return myZookeeper.createConnection();
    }

    public static void close(){
        myZookeeper.close();
    }

    static class MyZookeeper implements Watcher {

        private static int sessionTimeout = 10000;

        private static String connectUrl = "localhost:2181";

        private ZooKeeper zooKeeper;

        private CountDownLatch countDownLatch = new CountDownLatch(1);

        private ZooKeeper createConnection(){

            if(Objects.isNull(zooKeeper) || !zooKeeper.getState().isAlive()) {
                System.out.println("开始启动zooKeeper！");
                long st = System.currentTimeMillis();
                try {
                    zooKeeper = new ZooKeeper(connectUrl, sessionTimeout, this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("启动zooKeeper成功！耗时：" + (System.currentTimeMillis() - st));
            }

            return zooKeeper;
        }

        @Override
        public void process(WatchedEvent event) {

            if(event.getState().equals(Event.KeeperState.SyncConnected)){
                countDownLatch.countDown();
            }
        }

        private void close() {
            try {
                zooKeeper.close();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
