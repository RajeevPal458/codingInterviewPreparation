package com.bt.stringarr.mix;

public class LongestPelindromicSubString {
	static boolean[][] dp;
	static int begin=0,end=0;
	public static void lpSubString(char[] arr,int n){
		dp=new boolean[n][n];
		for(int i=0;i<n;i++)
			dp[i][i]=true;
		for(int cur=2;cur<=n;cur++){
			for(int i=0;i<n-cur+1;i++){
				
				int j=i+cur-1;
				if(arr[i]==arr[j]&&dp[i+1][j-1])
				{
					dp[i][j]=true;
					begin=i;
					end=j;
				}
			}
		}
	}
	public static void main(String[] args) {
		String s="bananas";
		lpSubString(s.toCharArray(),s.length());
		System.out.println(s.substring(begin, end+1));
	}
}
