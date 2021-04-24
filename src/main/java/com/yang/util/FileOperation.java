package com.yang.util;

import org.junit.Test;

public class FileOperation {

	/**
	 * FFmpeg 提取音频 from .mp4 FFmpeg 合并 Audio&Video->MP4 路径 正则.后缀
	 */

	public static void main(String[] args) {
		
		System.out.println(6 ^ 4);
	}
	
	
	//文件重命名 PC Android 批处理
	/*
		1、文件名列表获取（文件夹 -> 文件名）
		2、重命名情形：
			含网址    掐头，去尾，取中：
			截取 (start, end)=>(charAt(indexOf('')), charAt(indexOf(''))) 文件后缀
			分割，子串，正则 。。。
	
			图片顺序序号命名
			后缀修改批处理

	*/
	
	@Test 
	public void f() {
		
		
		String s = "www.aaa.com百年孤独@www.aaa.com";
		System.out.println(s.indexOf('百')); // 0-...
		System.out.println(s.substring(11, s.indexOf('@')));
		
		
		
		
		/*
		String s1 = "yang杨";
		String s2 = new String("yang杨");
		String s3 = "yang杨";
		String s4 = new String("yang杨");
		
		System.out.println(s1.equals(s2)); //true
		System.out.println(s1 == s2); //false
		System.out.println(s1 == s3); //true
		System.out.println(s2 == s4); //false
		System.out.println(s2.equals(s4)); //true
		
		*/
		
		//java.lang.IllegalArgumentException: 
		//Test class can only have one constructor（注释有参构造函数）
		
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
