package com.yang.Recruit.NowCoder.Other;

public class HuiXingFill {
	
	/*
	  n = 3, 4, 5...
	  1 8 7
	  2 9 6
	  3 4 5
	*/
	
	public static void main(String[] args) {
		
		int n = 9; //边长
		
		int a[][] = new int[n][n];
		
		int curNum = 0; //累加变量
		int c = (n + 1) / 2; //圈数
		
		for( int r = 0; r < c; r++) {
			
			int m = n - 2 * r; //第r圈 - 边长m
			
			int x = r; // (x, y):左上角起点
			int y = r;
			
			a[r][r] = ++curNum;
			
			
			// m-1>0 && m-2>0 == m-1>0
			// 指针移动次数 D R U:m-1  L:m-2
			if(m - 1 > 0) { // D R U
				
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
