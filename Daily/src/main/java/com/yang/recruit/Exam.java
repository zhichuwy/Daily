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

	// double溢出
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

	// 10进制<==>36进制
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

	// src.txt 不同单词出现次数统计

	public static void f4() throws IOException {

		TreeMap<String, Integer> map = new TreeMap<String, Integer>();

		File file = new File("src/main/resources/src.txt");
		FileReader fr = new FileReader(file);

		int len = 0;
		char[] ch = new char[16];// size过小，单词被分割！！！
		String tmp = "";// 单词被分割
		String word = "";

		while ((len = fr.read(ch)) != -1) {

			// String word = "";// null被当作字符串"null"

			// 提取单词 i..j
			int i = 0;
			int j = 0;

			for (; j < len; i = j) {

				while (j < len && ch[j] >= 'A' && ch[j] <= 'z') {
					j++;
					if (j > len) {
						tmp = String.copyValueOf(ch, i, j - i);
					}
				}

				// 单词放入map
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

	// 科大讯飞
	/*
	 * 有n 个人排成了一行队列，每个人都有一个站立的方向：面向左或面向右。由于这n个人中每个人都很讨厌其他的人，
	 * 所以当两个人面对面站立时，他们会发生争吵，然后其中一个人就会被踢出队列，谁被踢出队列都是有可能的。 我们用字符L 来表示一个面向左站立的人，用字符R
	 * 来表示一个面向右站立的人，那么这个队列可以用一个字符串描述。 比如RLLR，就表示一个四个人的队列，其中第一个人和第二个人是面对面站立的。
	 * 他们发生争吵后队列可能会变成LLR，也可能变成RLR；若变成RLR， 则第一个人与第二个人还会发生争吵，队列会进一步变成LR 或者RR。
	 * 若在某个时刻同时可能有很多的争吵会发生时，接下来（假设）只会发生其中的一个，且任意一个都是有可能发生的。
	 * 你想知道经过一系列的争吵后，这个队列最少会剩下多少人？ 输入 第一行包含一个有字符L 和R 构成的字符串。 1 ≤字符串长度≤ 10^5
	 * 输出队列中最少会剩下多少人。 样例输入 LRRLRL 样例输出 2 Hint 一种可能的变化情况是这样的: LRRLRL -> LRLRL ->
	 * LRRL-> LRL -> LR
	 */
	public static void f3() {

	}

	// 恒生电子2016
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

	// 恒生电子2018
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
