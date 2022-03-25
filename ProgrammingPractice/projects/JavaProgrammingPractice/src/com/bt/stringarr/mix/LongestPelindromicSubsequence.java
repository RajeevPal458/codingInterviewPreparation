package com.bt.stringarr.mix;

public class LongestPelindromicSubsequence {

	public int lps(char[] arr,int n){
		int[][] dp=new int[n][n];
		
		for(int i=0;i<n;i++)
			dp[i][i]=1;
		
		for(int cur_len=2;cur_len<=n;cur_len++){
			for(int i=0;i<n-cur_len+1;i++){
				int j=i+cur_len-1;
				if(arr[i]!=arr[j])
					dp[i][j]=Math.max(dp[i][j-1],dp[i+1][j]);
				else
					dp[i][j]=dp[i+1][j-1]+2;
			}
		}
		return dp[0][n-1];
	}
	public static void main(String[] args) {
		String str="lpaspal";
		LongestPelindromicSubsequence lps=new LongestPelindromicSubsequence();
		System.out.println("Longest Pelindromic sub sequence length:"+lps.lps(str.toCharArray(),str.length()));;
		
	}
}
