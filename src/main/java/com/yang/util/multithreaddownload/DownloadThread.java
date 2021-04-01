package com.yang.util.multithreaddownload;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * �����ļ����ص���
 */
public class DownloadThread extends Thread {
	/**
	 * �����ص��ļ�
	 */
	private String url = null;

	/**
	 * �����ļ���
	 */
	private String fileName = null;

	/**
	 * ƫ����
	 */
	private long offset = 0;

	/**
	 * ��������̵߳������ֽ���
	 */
	private long length = 0;

	/**
	 * @param url      �����ļ���ַ
	 * @param fileName ����ļ���
	 * @param offset   ���߳�����ƫ����
	 * @param length   ���߳����س���
	 */
	public DownloadThread(String url, String file, long offset, long length) {
		this.url = url;
		this.fileName = file;
		this.offset = offset;
		this.length = length;
		System.out.println("ƫ����=" + offset + ";�ֽ���=" + length);
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
