package com.yang.util.JsonFileParse;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonFileParse {

	public static void main(String[] args) {

		File json = new File("src/main/resources/URL.json");
		ObjectMapper mapper = new ObjectMapper();

		// FileWriter fw = new FileWriter(html);//����
		BufferedWriter bw = null;

		try {
			int count = 0;
			List<Da> listDa = mapper.readValue(json, new TypeReference<List<Da>>() {
			}); // num(ʵ����������) > num(JSON�������Ը���)

			File html = new File("src/main/resources/out.html");
			String start = "<!DOCTYPE html> <html lang=\"en\"> <head> <meta charset=\"utf-8\">"
					+ "<title>�����������ǩ</title> </head> <body>";
			
			bw = new BufferedWriter(new OutputStreamWriter (new FileOutputStream (html,true),"UTF-8"));
			bw.write(start);

			for (Da da : listDa) {
				// if (!da.getContents().isEmpty()) {
				// Json�в�����Class�е�����ʱ���ֶ�Ĭ��Ϊnull����˵��� .isEmpty() ��ָ���쳣��
				if (da.getContents() != null) {
					System.out.println("---------" + da.getTitle() + "---------");
					bw.write("<h3>" + da.getTitle() + "</h3><br>");
					for (Xiao xiao : da.getContents()) {
						System.out.println(xiao.getTitle());
						System.out.println(xiao.getIntent().split("#")[0]);
						System.out.println();
						count++;
						bw.write("<a href=\"" + xiao.getIntent().split("#")[0] + "\">" + xiao.getTitle() + "</a><br>");
					}
				} else {
					System.out.println();
					System.out.println("-------------Single Icon------------");
					System.out.println(da.getTitle());
					System.out.println(da.getIntent().split("#")[0]);
					System.out.println("---------------------------");
					count++;
					bw.write("<h3>Single Icon</h3><br>");
					bw.write("<a href=\"" + da.getIntent().split("#")[0] + "\">" + da.getTitle() + "</a><br>");
				}
			}
			String end = "</body> </html>";
			bw.write(end);
			bw.flush();
			bw.close();
			System.out.println(count);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
