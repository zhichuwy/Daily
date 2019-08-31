package com.yang.recruit;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public class Exam {

	public static void main(String[] args) throws IOException {

		f6();

	}

	// double���
	public static void f7() throws IOException {

		File file = new File("src/main/resources/double.txt");
		FileReader fr = new FileReader(file);
		char[] ch = new char[1024];

		double sum = 0;

		fr.read(ch);
		String[] str = String.copyValueOf(ch).split(",");

		for (String s : str) {
			sum += Double.parseDouble(s);
		}

		fr.close();

		System.out.println(sum);

	}

	// 10����<==>36����
	public static void f6() {

		int decimal = 123456789;
		StringBuilder thirtySix = new StringBuilder();

		// int 10 -> String 36

		int shang = -1;
		int yu = -1;

		Stack<String> stack = new Stack<String>();

		while (shang != 0) {
			shang = decimal / 36;
			yu = decimal % 36;
			if (yu >= 10) {
				char ch = (char) (yu - 10 + 'a');
				stack.push(String.valueOf(ch));
			} else {
				stack.push(String.valueOf(yu));
			}
			decimal = shang;
		}

		int size = stack.size();

		for (int i = 0; i < size; i++) {

			thirtySix.append(stack.pop());
		}

		System.out.println(thirtySix.toString());

		// String 36 -> int 10

		String ts = thirtySix.toString();

		int res = 0;
		int len = ts.length();

		for (int i = 0; i < ts.length(); i++) {

			char ch = ts.charAt(--len);

			if (ch >= 'a') {

				res += (ch - 'a' + 10) * Math.pow(36, i);

			} else {

				res += (ch - '0') * Math.pow(36, i);
			}

		}
		System.out.println(res);

	}

	public static void f5() {

		// int i = 0;
		// if (i) {} Type mismatch: cannot convert from int to boolean

		boolean b1 = true;
		boolean b2 = true;

		if (b1 == b2) {
			System.out.println("boolean b1 == b2");
		}

	}

	// src.txt ��ͬ���ʳ��ִ���ͳ��

	public static void f4() throws IOException {

		TreeMap<String, Integer> map = new TreeMap<String, Integer>();

		File file = new File("src/main/resources/src.txt");
		FileReader fr = new FileReader(file);

		int len = 0;
		char[] ch = new char[16];// size��С�����ʱ��ָ����
		String tmp = "";// ���ʱ��ָ�
		String word = "";

		while ((len = fr.read(ch)) != -1) {

			// String word = "";// null�������ַ���"null"

			// ��ȡ���� i..j
			int i = 0;
			int j = 0;

			for (; j < len; i = j) {

				while (j < len && ch[j] >= 'A' && ch[j] <= 'z') {
					j++;
					if (j > len) {
						tmp = String.copyValueOf(ch, i, j - i);
					}
				}

				// ���ʷ���map
				word = tmp + String.copyValueOf(ch, i, j - i);

				if (map.containsKey(word)) {
					map.put(word, map.get(word) + 1);
				} else {
					map.put(word, 1);
				}

				while (j < len && (ch[j] < 'A' || ch[j] > 'z')) {
					j++;
				}

			}
			tmp = "";
			ch = new char[16];
		}

		fr.close();
		for (String key : map.keySet()) {
			System.out.println(key + ":" + map.get(key));
		}

	}

	// �ƴ�Ѷ��
	/*
	 * ��n �����ų���һ�ж��У�ÿ���˶���һ��վ���ķ���������������ҡ�������n������ÿ���˶��������������ˣ�
	 * ���Ե������������վ��ʱ�����ǻᷢ��������Ȼ������һ���˾ͻᱻ�߳����У�˭���߳����ж����п��ܵġ� �������ַ�L ����ʾһ��������վ�����ˣ����ַ�R
	 * ����ʾһ��������վ�����ˣ���ô������п�����һ���ַ��������� ����RLLR���ͱ�ʾһ���ĸ��˵Ķ��У����е�һ���˺͵ڶ������������վ���ġ�
	 * ���Ƿ�����������п��ܻ���LLR��Ҳ���ܱ��RLR�������RLR�� ���һ������ڶ����˻��ᷢ�����������л��һ�����LR ����RR��
	 * ����ĳ��ʱ��ͬʱ�����кܶ�������ᷢ��ʱ�������������裩ֻ�ᷢ�����е�һ����������һ�������п��ܷ����ġ�
	 * ����֪������һϵ�е�����������������ٻ�ʣ�¶����ˣ� ���� ��һ�а���һ�����ַ�L ��R ���ɵ��ַ����� 1 ���ַ������ȡ� 10^5
	 * ������������ٻ�ʣ�¶����ˡ� �������� LRRLRL ������� 2 Hint һ�ֿ��ܵı仯�����������: LRRLRL -> LRLRL ->
	 * LRRL-> LRL -> LR
	 */
	public static void f3() {

	}

	// ��������2016
	public static void f2() {
		List<Integer> dataList = new ArrayList<Integer>(Arrays.asList(10, 20, 30, null));
		resetList(dataList);
		setOne(dataList);
		int sum = 0;
		for (Integer v : dataList) {
			sum += v;
		}
		System.out.println(sum);
	}

	public static void resetList(List<Integer> dataList) {
		dataList.subList(2, 4).set(0, 40);
		dataList = new ArrayList<Integer>(dataList);
		dataList.add(50);
	}

	public static void setOne(List<Integer> dataList) {
		dataList.set(3, 100);
	}

	// ��������2018
	public static void f1() {

		String str = "ABC137GMNQQ2049PN5FFF";

		TreeSet<Integer> ts = new TreeSet<Integer>();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch >= '0' && ch <= '9') {
				ts.add(ch - '0');
			}
		}

		for (Integer i : ts) {
			System.out.print(i + " ");
		}
	}
}
