package com.yang.Recruit.NowCoder.Other;

public class ShellSort {

	public void sort(int[] a) {
		int N = a.length;
		int h = 1;
		while (h < N / 3) {
			h = 3 * h + 1; // 1, 4, 13, 40, ...
		}
		while (h >= 1) {
			for (int i = h; i < N; i++) {
				for (int j = i; j >= h && compareElement(a[j], a[j - h]); j -= h) {
					exch(a, j, j - h);
				}
			}
			h = h / 3;
		}
	}

	public boolean compareElement(int v, int w) {
		return v - w < 0;
	}

	public void exch(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void main(String[] args) {
		int[] a = { 15, 0, 6, 9, 3 };
		ShellSort t = new ShellSort();
		t.sort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}