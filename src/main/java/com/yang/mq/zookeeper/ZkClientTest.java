package com.yang.mq.zookeeper;

import org.I0Itec.zkclient.ZkClient;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.zookeeper.CreateMode;

public class ZkClientTest {
	
	//zkClient连接超时 可能原因：zookeeper版本比zkClient过高，推荐使用原生zookeeper 熟悉原理
	
	private static final String zkServer = "172.81.250.4:2181";
	
	//log4j
	private final Logger LOG = Logger.getLogger(ZkClientTest.class.getName());
	
	//log4j2
	//private static Logger logger = LogManager.getLogger(ZkTest.class.getName());
	
	public static void fun() {
		ZkClient zc = new ZkClient(zkServer, 5000);
		
		/*
		String path = "/mynode";
		String data = "hello";
		zc.create(path, data, CreateMode.PERSISTENT);
		
		System.out.println("已存在？" + zc.exists(path));
		System.out.println("/下子节点：" + zc.getChildren("/"));
		
		System.out.println((String)zc.readData(path));
		
		zc.writeData(path, "world");
		System.out.println((String)zc.readData(path));
		
		zc.delete(path);
		System.out.println("after del:" + zc.getChildren("/"));
		*/
		
		if(zc != null) {
			zc.close();
		}
	}
	
	public static void main(String[] args) {
		fun();
	}
	
}
