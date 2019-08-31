package com.yang.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Student {
	@JacksonXmlProperty(isAttribute = true, localName = "stu_id")
	private String id; // —ß∫≈--- Ù–‘
	private String name;
	private String gender;
	private String age;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
}
