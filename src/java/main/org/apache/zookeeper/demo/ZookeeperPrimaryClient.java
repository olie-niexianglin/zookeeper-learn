package org.apache.zookeeper.demo;

import com.google.common.collect.Lists;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.apache.zookeeper.server.ZooKeeperServerMain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Nie Xianglin
 * Date: 2019/8/28
 * Time: 14:53
 * Desc: zookeeper 原生客户端
 */
public class ZookeeperPrimaryClient {

    private static final Logger LOG =
            LoggerFactory.getLogger(ZookeeperPrimaryClient.class);

    public static void main(String[] args) throws
            Exception {
        ZooKeeper zk = new ZooKeeper("localhost:2181", 3000, new Watcher() {

            @Override
            public void process(WatchedEvent event) {

                LOG.info(event.toString());

            }

        });

        Stat stat = new Stat();


//        for (int i = 0; i < 128; i++) {
//            zk.create("/niexianglin"+ i, "121312".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//
//            Thread.sleep(100);
//        }
//


        byte[] data = zk.getData("/niexianglin12", null, new Stat());

        System.out.printf(new String(data, Charset.defaultCharset()));

    }
}
