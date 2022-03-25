package com.bt.stringarr.mix;

public class LongestCommonSubString {
	static int[][] dp;
	static int max=0,end=0;
	private static void lcsubSequence(char[] row, char[] col, int rlen, int clen) {
		// TODO Auto-generated method stub
		dp=new int[rlen][clen];
		for(int i=0;i<rlen;i++){
			for(int j=0;j<clen;j++){
				
				if(row[i]==col[j]){
					
					if(i==0||j==0)
						dp[i][j]=1;
					else
						dp[i][j]=dp[i-1][j-1]+1;
					if(max<dp[i][j])
						max=dp[i][j];
					end=j;
				}
			}
		}
	}
	public static void main(String[] args) {
		String str1="LCLC";
		String str2="CLCL";
		lcsubSequence(str1.toCharArray(),str2.toCharArray(),str1.length(),str2.length());
		System.out.println(str2.substring(end-max+1, end+1)+"  " +max);
		
		
	}

}/*
  L C L C
C
L
C
L
*/