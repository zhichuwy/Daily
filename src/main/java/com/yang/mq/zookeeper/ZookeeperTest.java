package com.yang.mq.zookeeper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;


public class ZookeeperTest {

	private String connectString = "127.0.0.1:2181";
	private int sessionTimeout = 5000;
	private ZooKeeper zc;

	public static void main(String[] args) throws Exception {

		ZookeeperTest z = new ZookeeperTest();
		z.conn3();

		Thread.sleep(Long.MAX_VALUE);
	}

	public void conn3() throws IOException {
		zc = new ZooKeeper(connectString, sessionTimeout, new Watcher() {

			@Override
			public void process(WatchedEvent event) { // ����ĳ�ڵ�Ŀ¼�ı仯
				ArrayList<String> nodes = new ArrayList<String>();
				List<String> children;
				try {
					children = zc.getChildren("/", true);
					for (String c : children) {
						nodes.add(c);
					}
					System.out.println(nodes);
				} catch (KeeperException | InterruptedException e) {
					e.printStackTrace();
				}

			}
		});
	}

	public void conn2() throws IOException {
		zc = new ZooKeeper(connectString, sessionTimeout, new Watcher() {

			@Override
			public void process(WatchedEvent event) { // ����ĳһ�ڵ�����

				try {

					// path�����ڣ�NoNodeException
					// dataΪnull��ע�⣡NullPointerException
					// byte[] data = zc.getData("/n1", true, null);

					byte[] data = zc.getData("/n1", this, null);

					System.out.println("��������Ϊ��" + event.getType());
					System.out.println("����·��Ϊ��" + event.getPath());

					System.out.println("���ݱ��޸�Ϊ��" + new String(null == data ? "null".getBytes() : data));
					System.out.println("============================");

				} catch (KeeperException | InterruptedException e) {
					e.printStackTrace();
				}

			}
		});
	}

	public void conn1() throws IOException {
		zc = new ZooKeeper(connectString, sessionTimeout, new Watcher() {

			@Override
			public void process(WatchedEvent event) {

				System.out.println("1");

				List<String> children;
				try {
					children = zc.getChildren("/", true); // ��ʼ�����ʱִ��һ��

					System.out.println("2");

					for (String child : children) {
						System.out.println(child);
					}
				} catch (KeeperException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		});
	}

	public void getDataAndWatch() throws KeeperException, InterruptedException {
		List<String> children = zc.getChildren("/", true);

		System.out.println("3");

		for (String child : children) {
			System.out.println(child);
		}
	}

	public void createNode() throws KeeperException, InterruptedException, IOException {

		String path = "/n1";
		byte[] data = "d1".getBytes();
		List<ACL> acl = Ids.OPEN_ACL_UNSAFE;
		CreateMode createMode = CreateMode.PERSISTENT;
		String p = zc.create(path, data, acl, createMode); // ���Ѵ��� ֮����벻ִ�У�����

		System.out.println("aaa");
		System.out.println("".equals(p));
		System.out.println("aaa");
		System.err.print("created:" + p);
	}

}
