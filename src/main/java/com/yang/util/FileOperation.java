package com.yang.util;

import org.junit.Test;

public class FileOperation {

	/**
	 * FFmpeg ��ȡ��Ƶ from .mp4 FFmpeg �ϲ� Audio&Video->MP4 ·�� ����.��׺
	 */

	public static void main(String[] args) {
		
		System.out.println(6 ^ 4);
	}
	
	
	//�ļ������� PC Android ������
	/*
		1���ļ����б��ȡ���ļ��� -> �ļ�����
		2�����������Σ�
			����ַ    ��ͷ��ȥβ��ȡ�У�
			��ȡ (start, end)=>(charAt(indexOf('')), charAt(indexOf(''))) �ļ���׺
			�ָ�Ӵ������� ������
	
			ͼƬ˳���������
			��׺�޸�������

	*/
	
	@Test 
	public void f() {
		
		
		String s = "www.aaa.com����¶�@www.aaa.com";
		System.out.println(s.indexOf('��')); // 0-...
		System.out.println(s.substring(11, s.indexOf('@')));
		
		
		
		
		/*
		String s1 = "yang��";
		String s2 = new String("yang��");
		String s3 = "yang��";
		String s4 = new String("yang��");
		
		System.out.println(s1.equals(s2)); //true
		System.out.println(s1 == s2); //false
		System.out.println(s1 == s3); //true
		System.out.println(s2 == s4); //false
		System.out.println(s2.equals(s4)); //true
		
		*/
		
		//java.lang.IllegalArgumentException: 
		//Test class can only have one constructor��ע���вι��캯����
		
	}
	
	

	private String path;
	private String pattern;
	private String suffix;

	public FileOperation() {
		path = "";
		pattern = "*";
		suffix = "";
	}

	/*
	public FileOperation(String path, String pattern, String suffix) {
		this.path = path;
		this.pattern = pattern;
		this.suffix = suffix;
	}*/


	public void mergeAudioVideo(String audioPath, String videoPath) {

	}

}
