package com.yang.util;

public class FileOperation {

	/**
	 *  FFmpeg ��ȡ��Ƶ from .mp4
	 *  FFmpeg �ϲ�  Audio&Video->MP4 ·�� ����.��׺          
	 * 
	 */
	
	
	public static void main(String[] args) {
		
		System.out.println(6^4);
		
	}

	private String path;
	private String pattern;
	private String suffix;

	public FileOperation() {
		path = "";
		pattern = "*";
		suffix = "";
	}

	public FileOperation(String path, String pattern, String suffix) {
		this.path = path;
		this.pattern = pattern;
		this.suffix = suffix;
	}

	
	//�ļ�������
	public void reName(String pattern) {
		
		

	}
	
	
	public void mergeAudioVideo(String audioPath, String videoPath) {
		
	}

}
