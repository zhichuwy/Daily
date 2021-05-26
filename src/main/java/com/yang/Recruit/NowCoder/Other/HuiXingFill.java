package com.yang.Recruit.NowCoder.Other;

public class HuiXingFill {
	
	
	public static void main(String[] args) {
		
		fun();
	}
	
	
	
	/*
	  n = 3, 4, 5...
	  1 8 7
	  2 9 6
	  3 4 5
	*/
	
	public static void fun() {
		// 改进：m-1 m-1 m-1 m-1
		int n = 9;
		int a[][] = new int[n][n];
		int count = n * n; 
		int row = n, col = n;
		int cur = 1;
		int i = 0, j = 0;
		
		while (count > 0) {
		// for (int s=0; s<5; s++) { 调试用
			for (int m = 1; m < col; m++) { a[i][j] = cur++; count -= 1; j++;}
			for (int m = 1; m < row; m++) { a[i][j] = cur++; count -= 1; i++;}
			for (int m = 1; m < col; m++) { a[i][j] = cur++; count -= 1; --j;}
			for (int m = 1; m < row; m++) { a[i][j] = cur++; count -= 1; --i;}
			i++;
			j++;
			System.out.println("(" + i + "," + j + ")");
			
			if (count == 1) {
				a[i][j] = cur++;
				break;
			}
			
			
			row -= 2;
			col -= 2;
			System.out.println("row= " + row + ",col=" + col);
			System.out.println("count=" + count);
		}
		
		//print
		for (int x = 0; x < n; x++) {
			for (int y = 0; y < n; y++) {
				System.out.print(a[x][y] + "  ");
			}
			System.out.println();
		}
	}
	
	
	public static void fun1() {
		int n = 9; //边长
		int a[][] = new int[n][n];
		int curNum = 0; //累加变量
		int c = (n + 1) / 2; //圈数
		
		for (int r = 0; r < c; r++) {
			int m = n - 2 * r; //第r圈 - 边长m
			int x = r; // (x, y):左上角起点
			int y = r;
			a[r][r] = ++curNum;
			
			// m-1>0 && m-2>0 == m-1>0
			// 指针移动次数 D R U:m-1  L:m-2
			if (m - 1 > 0) { // D R U
				
				for (int dd = 1; dd <= m - 1; dd++) {
					a[++x][y] = ++curNum; 
				}
				
				for (int rr= 1; rr <= m - 1; rr++) {
					a[x][++y] = ++curNum; 
				}
				
				for (int uu = 1; uu <= m - 1; uu++) {
					a[--x][y] = ++curNum; 
				}
				
			} else {
				break;
			}
			
			// if(m - 2 > 0) { // L
			for (int l = 1; l <= m - 2; l++) {
				a[x][--y] = ++curNum; 
			}
			
		}
		
		
		//print
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(a[i][j] + "  ");
			}
			System.out.println();
		}
	}
	
}
