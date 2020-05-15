package com.yang.entity;

import java.io.Serializable;

public class SerializeObj implements Serializable {

	private static final long serialVersionUID = 1L;

	private static int ID;
	private String name;
	private int age;	
	private transient String sex;
	
	@Override
	public String toString() {
		return "SerializeObj [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}

	public static int getID() {
		return ID;
	}

	public static void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
