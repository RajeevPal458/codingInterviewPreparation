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
	
	
	public static int lps_recursive(String str,int i,int j,int n) {
		if(i==j) return 1;
		
		if(str.charAt(i)==str.charAt(j) && i+1==j) return 2;
		
		if(str.charAt(i)==str.charAt(j)){
			return 2+ lps_recursive(str, i+1, j-1, n);
		}
		
		return Math.max(lps_recursive(str, i+1, j, n), lps_recursive(str, i, j-1, n));
		
	}
	
	
	public static void main(String[] args) {
		String str="lpaspal";
		
		LongestPelindromicSubsequence lps=new LongestPelindromicSubsequence();
		
		System.out.println("Longest Pelindromic sub sequence length:"+lps.lps(str.toCharArray(),str.length()));;
		
		
		System.out.println("Longest Pelindromic sub sequence length:"+lps_recursive(str,0,str.length()-1,str.length()));;
		
	}
}
