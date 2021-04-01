package com.yang.util.multithreaddownload;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 文件下载管理类
 */
public class DownLoadManager {

	/**
	 * 每个线程下载的字节数
	 */
	static final long unitSize = 1000 * 1024;

	/**
	 * 启动多个线程下载文件
	 */
	public void doDownload(String remoteFileUrl) throws IOException {
		String fileName = new URL(remoteFileUrl).getFile();
		fileName = fileName.substring(fileName.lastIndexOf("/") + 1, fileName.length()).replace("%20", " ");

		long fileSize = this.getRemoteFileSize(remoteFileUrl);
		if (fileSize == 0) {
			return;
		}

		this.createFile(fileName, fileSize); //项目根目录下
		long threadCount = fileSize / unitSize;
		System.out.println("共启动 " + (fileSize % unitSize == 0 ? threadCount : threadCount + 1) + " 个线程");

		long offset = 0;
		if (fileSize <= unitSize) {// 如果远程文件尺寸小于等于unitSize
			DownloadThread downloadThread = new DownloadThread(remoteFileUrl, fileName, offset, fileSize);
			downloadThread.start();
		} else {// 如果远程文件尺寸大于unitSize
			for (int i = 1; i <= threadCount; i++) {
				DownloadThread downloadThread = new DownloadThread(remoteFileUrl, fileName, offset, unitSize);
				downloadThread.start();
				offset = offset + unitSize;
			}

			if (fileSize % unitSize != 0) {// 如果不能整除，则需要再创建一个线程下载剩余字节
				DownloadThread downloadThread = new DownloadThread(remoteFileUrl, fileName, offset,
						fileSize - unitSize * threadCount);
				downloadThread.start();
			}
		}
	}

	/**
	 * 获取远程文件尺寸
	 */
	private long getRemoteFileSize(String remoteFileUrl) throws IOException {
		long fileSize = 0;
		HttpURLConnection httpConnection = (HttpURLConnection) new URL(remoteFileUrl).openConnection();
		httpConnection.setRequestMethod("HEAD");

		int responseCode = httpConnection.getResponseCode();
		if (responseCode >= 400) {
			System.out.println("Web服务器响应错误!");
			return 0;
		}

		String sHeader;
		for (int i = 1;; i++) {
			sHeader = httpConnection.getHeaderFieldKey(i);
			if (sHeader != null && sHeader.equals("Content-Length")) {
				System.out.println("文件大小ContentLength:" + httpConnection.getContentLength());
				fileSize = Long.parseLong(httpConnection.getHeaderField(sHeader));
				break;
			}
		}
		return fileSize;
	}

	/**
	 * 创建指定大小的文件
	 */
	private void createFile(String fileName, long fileSize) throws IOException {
		File newFile = new File(fileName);
		RandomAccessFile raf = new RandomAccessFile(newFile, "rw");
		raf.setLength(fileSize);
		raf.close();
	}
}
