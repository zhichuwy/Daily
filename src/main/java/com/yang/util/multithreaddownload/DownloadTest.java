package com.yang.util.multithreaddownload;

import org.junit.Test;

public class DownloadTest {

	// 多线程文件下载测试

	@Test
	public void FileDownloadTest() {
		try {
			String remoteFileUrl = "http://dl.maxthon.cn/cn/mx2/mx_2.5.1.4751cn.exe";
			//String remoteFileUrl = "https://dev.mysql.com/downloads/file/?id=501540"; bug
			DownLoadManager downLoadManager = new DownLoadManager();
			downLoadManager.doDownload(remoteFileUrl);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
