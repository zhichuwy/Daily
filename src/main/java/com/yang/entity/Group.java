package com.yang.entity;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "Class") // ָ������XML����ǩ������
public class Group {

	Teacher teacher; // ��ʦ

	@JacksonXmlElementWrapper(localName = "Students")
	@JacksonXmlProperty(localName = "Stu")
	List<Student> student; // ѧ���б�

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}
}