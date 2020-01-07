package com.mt.zk;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.List;

/**
 * author: liqm
 * 2019-10-29
 */
public class MyWatcherForChildrenOfNode implements Watcher {

    private ZooKeeper zooKeeper;

    public MyWatcherForChildrenOfNode(ZooKeeper zooKeeper){
        this.zooKeeper = zooKeeper;
    }

    @Override
    public void process(WatchedEvent watchedEvent) {

        String path = watchedEvent.getPath();

        System.out.println("监听[" + path + "]子节点,type:" + watchedEvent.getType());

        try {
            List<String> children = zooKeeper.getChildren(path, new MyWatcherForChildrenOfNode(zooKeeper));

            System.out.println();

        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
