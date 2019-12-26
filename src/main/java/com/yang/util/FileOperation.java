package com.yang.util;

public class FileOperation {

	/**
	 *  FFmpeg 提取音频 from .mp4
	 *  FFmpeg 合并  Audio&Video->MP4 路径 正则.后缀          
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

	
	//文件重命名
	public void reName(String pattern) {
		
		

	}
	
	
	public void mergeAudioVideo(String audioPath, String videoPath) {
		
	}

}
