package com.yang.util.multithreaddownload;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * �ļ����ع�����
 */
public class DownLoadManager {

	/**
	 * ÿ���߳����ص��ֽ���
	 */
	static final long unitSize = 1000 * 1024;

	/**
	 * ��������߳������ļ�
	 */
	public void doDownload(String remoteFileUrl) throws IOException {
		String fileName = new URL(remoteFileUrl).getFile();
		fileName = fileName.substring(fileName.lastIndexOf("/") + 1, fileName.length()).replace("%20", " ");

		long fileSize = this.getRemoteFileSize(remoteFileUrl);
		if (fileSize == 0) {
			return;
		}

		this.createFile(fileName, fileSize); //��Ŀ��Ŀ¼��
		long threadCount = fileSize / unitSize;
		System.out.println("������ " + (fileSize % unitSize == 0 ? threadCount : threadCount + 1) + " ���߳�");

		long offset = 0;
		if (fileSize <= unitSize) {// ���Զ���ļ��ߴ�С�ڵ���unitSize
			DownloadThread downloadThread = new DownloadThread(remoteFileUrl, fileName, offset, fileSize);
			downloadThread.start();
		} else {// ���Զ���ļ��ߴ����unitSize
			for (int i = 1; i <= threadCount; i++) {
				DownloadThread downloadThread = new DownloadThread(remoteFileUrl, fileName, offset, unitSize);
				downloadThread.start();
				offset = offset + unitSize;
			}

			if (fileSize % unitSize != 0) {// �����������������Ҫ�ٴ���һ���߳�����ʣ���ֽ�
				DownloadThread downloadThread = new DownloadThread(remoteFileUrl, fileName, offset,
						fileSize - unitSize * threadCount);
				downloadThread.start();
			}
		}
	}

	/**
	 * ��ȡԶ���ļ��ߴ�
	 */
	private long getRemoteFileSize(String remoteFileUrl) throws IOException {
		long fileSize = 0;
		HttpURLConnection httpConnection = (HttpURLConnection) new URL(remoteFileUrl).openConnection();
		httpConnection.setRequestMethod("HEAD");

		int responseCode = httpConnection.getResponseCode();
		if (responseCode >= 400) {
			System.out.println("Web��������Ӧ����!");
			return 0;
		}

		String sHeader;
		for (int i = 1;; i++) {
			sHeader = httpConnection.getHeaderFieldKey(i);
			if (sHeader != null && sHeader.equals("Content-Length")) {
				System.out.println("�ļ���СContentLength:" + httpConnection.getContentLength());
				fileSize = Long.parseLong(httpConnection.getHeaderField(sHeader));
				break;
			}
		}
		return fileSize;
	}

	/**
	 * ����ָ����С���ļ�
	 */
	private void createFile(String fileName, long fileSize) throws IOException {
		File newFile = new File(fileName);
		RandomAccessFile raf = new RandomAccessFile(newFile, "rw");
		raf.setLength(fileSize);
		raf.close();
	}
}
