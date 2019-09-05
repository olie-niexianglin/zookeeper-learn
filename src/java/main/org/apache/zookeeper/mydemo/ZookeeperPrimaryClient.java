package org.apache.zookeeper.mydemo;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;

/**
 * Created by IntelliJ IDEA.
 * User: Nie Xianglin
 * Date: 2019/8/28
 * Time: 14:53
 * Desc: zookeeper 原生客户端
 */
public class ZookeeperPrimaryClient extends Thread {

    private static final Logger LOG =
            LoggerFactory.getLogger(ZookeeperPrimaryClient.class);

    public ZookeeperPrimaryClient(String name) {
        super(name);
    }

    public static void main(String[] args) throws
            Exception {


        ZooKeeper zk = new ZooKeeper("localhost:2181", 3000, new Watcher() {

            @Override
            public void process(WatchedEvent event) {

                LOG.info(event.toString());

            }

        });


        byte[] data = zk.getData("/eclipse", true, new Stat());

        new CountDownLatch(1).await();


    }

}
