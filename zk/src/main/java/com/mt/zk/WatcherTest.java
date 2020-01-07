package com.mt.zk;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.List;

/**
 * author: liqm
 * 2019-10-29
 */
public class WatcherTest {


    private static void watchNode() throws KeeperException, InterruptedException {
        String path = "/root/child";

        ZooKeeper zooKeeper = ZookeeperServer.getConnection();

        Stat stat = zooKeeper.exists(path, false);

        String msg = new String(zooKeeper.getData(path, new MyWatcherForNode(zooKeeper), stat));

        System.out.println(msg);
    }

    private static void watchChildren() throws KeeperException, InterruptedException {
        String path = "/root";

        ZooKeeper zooKeeper = ZookeeperServer.getConnection();

        List<String> children = zooKeeper.getChildren(path, new MyWatcherForChildrenOfNode(zooKeeper));

        for (String child : children) {

            String childPath = path + "/" + child;

            Stat childStat = zooKeeper.exists(path, false);

            String msg = new String(zooKeeper.getData(childPath, new MyWatcherForNode(zooKeeper), childStat));

            System.out.println("子节点-》" + child + ":" + msg);
        }

    }



    public static void main(String[] args) throws KeeperException, InterruptedException {

        watchNode();

        //watchChildren();

        while (true) {
            Thread.sleep(1000L);
        }

    }



}
