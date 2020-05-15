package com.yang.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.yang.entity.SerializeObj;

public class Serailization {

	public static void main(String[] args) throws Exception, IOException {

		SerializeObj so = new SerializeObj();
		so.setName("xiaoming");
		so.setAge(30);
		so.setSex("girl");
		System.out.println(so);

		ObjectOutputStream oo;
		ObjectInputStream oi;
		// D:/SerializeObj.txt
		String path = "src/main/resources/ff/SO.txt";

		
		//序列化
		oo = new ObjectOutputStream(new FileOutputStream(new File(path)));
		oo.writeObject(so);
		oo.close();

		//反序列化
		oi = new ObjectInputStream(new FileInputStream(new File(path)));
		SerializeObj obj = (SerializeObj) oi.readObject();
		oi.close();
		System.out.println(obj);

	}

}
