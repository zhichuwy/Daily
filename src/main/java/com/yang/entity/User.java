package com.yang.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

	// JSON���л��ͷ����л�ʹ�õ�User��

	/**
	 * Jackson�ṩ��һϵ��ע�⣬�����JSON���л��ͷ����л����п��ƣ��������һЩ���õ�ע�⡣
	 * 
	 * @JsonIgnore ��ע�����������ϣ������ǽ���JSON����ʱ���Ը����ԡ�
	 * @JsonFormat ��ע�����������ϣ������ǰ�Date����ֱ��ת��Ϊ��Ҫ�ĸ�ʽ����@JsonFormat(pattern = "yyyy-MM-dd
	 *             HH-mm-ss")��
	 * @JsonProperty ��ע�����������ϣ������ǰѸ����Ե��������л�Ϊ����һ�����ƣ����trueName�������л�Ϊname��@JsonProperty("name")��
	 */

	private String name;

	// ��JSON���л���������
	@JsonIgnore
	private Integer age;

	// ��ʽ����������
	@JsonFormat(pattern = "yyyy��MM��dd��")
	private Date birthday;

	// ���л�email����Ϊmail
	@JsonProperty("my_email")
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User{" + "name='" + name + '\'' + ", age=" + age + ", birthday=" + birthday + ", email='" + email + '\''
				+ '}';
	}
}
