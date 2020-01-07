package com.mt.zk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.util.List;

/**
 * zookeeper 增删改查
 * author: liqm
 * 2019-10-28
 */
public class ZKTest {

    /**
     * 数据查询
     */
    private static void getData(String path) throws KeeperException, InterruptedException {

        Stat stat = ZookeeperServer.getConnection().exists(path,false);

        String msg = new String(ZookeeperServer.getConnection().getData(path, false, stat));

        System.out.println(msg);

    }

    /**
     * 数据修改/设置
     * @throws KeeperException
     * @throws InterruptedException
     */
    private static void setData(String path) throws KeeperException, InterruptedException {
        ZooKeeper zooKeeper = ZookeeperServer.getConnection();
        zooKeeper.setData(path, "hello world1".getBytes(), -1);
    }


    /**
     * 创建节点
     * @throws KeeperException
     * @throws InterruptedException
     */
    private static void createNode(String path) throws KeeperException, InterruptedException {
        ZooKeeper zooKeeper = ZookeeperServer.getConnection();
        zooKeeper.create(path, "child node".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }


    /**
     * 获取子节点
     * @param parent
     * @throws KeeperException
     * @throws InterruptedException
     */
    private static void getChild(String parent) throws KeeperException, InterruptedException {

        List<String> childPaths = ZookeeperServer.getConnection().getChildren(parent, true);

        System.out.println("child node:");
        for (String path : childPaths) {
            System.out.println("path:" + path);
        }
    }

    /**
     * 删除子节点
     * @param path
     * @throws KeeperException
     * @throws InterruptedException
     */
    private static void deleteNode(String path) throws KeeperException, InterruptedException {
        ZooKeeper zooKeeper = ZookeeperServer.getConnection();
        zooKeeper.delete(path, -1);
    }

    /**
     * 存在验证
     * @param path
     * @throws KeeperException
     * @throws InterruptedException
     */
    private static void exist(String path) throws KeeperException, InterruptedException {
       Stat stat = ZookeeperServer.getConnection().exists(path, false);

       System.out.println(stat);
    }

    private static void transction() throws KeeperException, InterruptedException {

        ZookeeperServer.getConnection().transaction().
                create("/root/child", "child node".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT)
                .setData("/root/child", "transction".getBytes(), -1).commit();
    }

    public static void main(String[] args) throws KeeperException, InterruptedException {
        try {
            getData("/root");
            //setData("/root");
            //createNode("/root/child");
            //getData("/root/child");
            //getChild("/root");
            //deleteNode("/root/child");
            //exist("/root/child");
            //transction();
            //setData("/root/child");



        }finally {
            ZookeeperServer.close();
        }
    }
}
