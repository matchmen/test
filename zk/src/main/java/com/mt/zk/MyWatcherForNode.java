package com.mt.zk;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

/**
 * author: liqm
 * 2019-10-29
 */
public class MyWatcherForNode  implements Watcher{

    private ZooKeeper zooKeeper;

    public MyWatcherForNode(ZooKeeper zooKeeper){
        this.zooKeeper = zooKeeper;
    }

    @Override
    public void process(WatchedEvent watchedEvent) {

        String path = watchedEvent.getPath();

        System.out.println("监听：" + path + ",type:" + watchedEvent.getType());

        try {
            Stat stat = zooKeeper.exists(path, false);

            if(stat == null) return;

            String msg = new String(zooKeeper.getData(path, new MyWatcherForNode(zooKeeper), stat));

            System.out.println(msg);

        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
