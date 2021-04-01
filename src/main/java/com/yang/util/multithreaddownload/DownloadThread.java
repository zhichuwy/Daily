package com.yang.util.multithreaddownload;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 负责文件下载的类
 */
public class DownloadThread extends Thread {
	/**
	 * 待下载的文件
	 */
	private String url = null;

	/**
	 * 本地文件名
	 */
	private String fileName = null;

	/**
	 * 偏移量
	 */
	private long offset = 0;

	/**
	 * 分配给本线程的下载字节数
	 */
	private long length = 0;

	/**
	 * @param url      下载文件地址
	 * @param fileName 另存文件名
	 * @param offset   本线程下载偏移量
	 * @param length   本线程下载长度
	 */
	public DownloadThread(String url, String file, long offset, long length) {
		this.url = url;
		this.fileName = file;
		this.offset = offset;
		this.length = length;
		System.out.println("偏移量=" + offset + ";字节数=" + length);
	}

	public void run() {
		try {
			HttpURLConnection httpConnection = (HttpURLConnection) new URL(this.url).openConnection();
			httpConnection.setRequestMethod("GET");
			httpConnection.setRequestProperty("RANGE", "bytes=" + this.offset + "-" + (this.offset + this.length - 1));

			System.out.println("RANGE bytes=" + this.offset + "-" + (this.offset + this.length - 1));

			BufferedInputStream bis = new BufferedInputStream(httpConnection.getInputStream());
			byte[] buff = new byte[1024];
			int bytesRead;
			File newFile = new File(fileName);
			RandomAccessFile raf = new RandomAccessFile(newFile, "rw");

			while ((bytesRead = bis.read(buff, 0, buff.length)) != -1) {
				raf.seek(this.offset);
				raf.write(buff, 0, bytesRead);
				this.offset = this.offset + bytesRead;
			}
			raf.close();
			bis.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
