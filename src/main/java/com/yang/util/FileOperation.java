package com.yang.util;

public class FileOperation {

	/**
	 *  �ļ�������
	 *  FFmpeg ��ȡ��Ƶ from .mp4
	 *  FFmpeg �ϲ�  Audio&Video->MP4
	 * 
	 *  ·�� ����.��׺
	 *  FFmpeg
	 * 
	 */

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

	public void reName(String pattern) {
		
		

	}
	
	
	public void mergeAudioVideo(String audioPath, String videoPath) {
		
	}

}
