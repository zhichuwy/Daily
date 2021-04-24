package com.yang.mq.zookeeper;

import java.io.IOException;
import java.util.List;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;
import org.junit.Before;
import org.junit.Test;

public class ZookeeperTest {
	
	private String connectString = "127.0.0.1:2181";
	private int sessionTimeout = 5000;
	private ZooKeeper zc;
	
	
	//@Test
	public void init() throws IOException {
		zc = new ZooKeeper(connectString, sessionTimeout, new Watcher() { 
			
			@Override
			public void process(WatchedEvent event) {
				
				List<String> children;
				try {
					children = zc.getChildren("/", true);
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
	
	
	@Test
	public void f() throws Exception {
		init();
		
		//createNode();
		getDataAndWatch();
		
		Thread.sleep(Long.MAX_VALUE);
	}
	
	
	
	
	
	
	public void getDataAndWatch() throws KeeperException, InterruptedException {
		List<String> children = zc.getChildren("/", true);
		for (String child : children) {
			System.out.println(child);
		}
	}
	
	
	public void createNode() throws KeeperException, InterruptedException, IOException {
		
		String path = "/n1";
		byte[] data = "d1".getBytes();
		List<ACL> acl = Ids.OPEN_ACL_UNSAFE;
		CreateMode createMode = CreateMode.PERSISTENT;
		String p = zc.create(path, data, acl, createMode); //若已存在 之后代码不执行？？？
		
		System.out.println("aaa");
		System.out.println("".equals(p));
		System.out.println("aaa");
		System.err.print("created:" + p);
	}
	
}
