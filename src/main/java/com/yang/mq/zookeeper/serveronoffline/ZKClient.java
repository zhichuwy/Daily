package com.yang.mq.zookeeper.serveronoffline;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

public class ZKClient {

	ZooKeeper zk = null;

	public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
		ZKClient zkClient = new ZKClient();
		zkClient.getConnection();
		zkClient.watching();
	}

	private void watching() throws InterruptedException {
		Thread.sleep(Long.MAX_VALUE);
	}

	private void getConnection() throws IOException {
		zk = new ZooKeeper("127.0.0.1:2181", 3000, new Watcher() {

			@Override
			public void process(WatchedEvent event) {
				try { // getChildren getData两个监听（节点以及节点数据变化均可触发监听器）
					List<String> children = zk.getChildren("/Servers", true);
					ArrayList<String> node = new ArrayList<String>();
					for (String c : children) {
						byte[] data = zk.getData("/Servers/" + c, true, null);
						node.add(new String(data));
					}
					System.out.println(node);
				} catch (KeeperException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
	}

}
