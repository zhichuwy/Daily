package com.yang.mq.zookeeper.serveronoffline;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

public class ZKServer2 {

	ZooKeeper zk = null;
	private String parentNode = "/Servers";

	public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
		String childNode = "hd2";
		ZKServer2 zkServer = new ZKServer2();
		// ��ȡ����
		zkServer.getConnection();
		// ע����Ϣ
		zkServer.regist(childNode);
		// ҵ���߼�����ʾ����
		zkServer.build(childNode);

	}

	private void build(String hostname) throws InterruptedException {
		System.out.println(hostname + "�����ˣ���");
		Thread.sleep(Long.MAX_VALUE); // ��ʱ�ڵ�
	}

	private void regist(String hostname) throws KeeperException, InterruptedException {
		String path = zk.create(parentNode + "/server", hostname.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
				CreateMode.EPHEMERAL_SEQUENTIAL);
		System.out.println(path);
	}

	private void getConnection() throws IOException {
		zk = new ZooKeeper("127.0.0.1:2181", 3000, new Watcher() {
			
			@Override
			public void process(WatchedEvent event) {
				// TODO Auto-generated method stub
			}
			
		});
	}

}
