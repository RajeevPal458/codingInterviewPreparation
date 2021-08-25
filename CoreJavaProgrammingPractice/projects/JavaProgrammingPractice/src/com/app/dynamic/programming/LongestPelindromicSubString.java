package com.app.dynamic.programming;

import java.util.Arrays;

public class LongestPelindromicSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "afsrsfsrsrs";
		int n = str.length();
		System.out.println("lpa:--"+lpsubstring(str.toCharArray(),n));;
		
	}

	private static int lpsubstring(char[] str, int n) {
		// TODO Auto-generated method stub
		boolean[][] arr = new boolean[n][n];
		int lpa=1;
		for(int i=0;i<n;i++) {
			arr[i][i]=true;
		}
		for(int i=n-2;i>=0;i--) {
			for(int j=i+1;j<n;j++) {
				if(str[i]==str[j]) {
					if(arr[i+1][j-1]) {
						arr[i][j]=true;
						lpa=Math.max(lpa,j-i+1);
					}else {
						arr[i][j]=false;
					}
				}
			}
		}
		for(int i=0;i<n;i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		
		return lpa;
	}

}
