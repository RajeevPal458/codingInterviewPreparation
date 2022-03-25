package com.bt.stringarr.mix;
import java.util.Arrays;

public class MinimumEditDistance {

	public static int minEditDist(char[] arr1,char[] arr2,int m1,int m2){
		int[][] dp=new int[m2+1][m1+1];
		dp[0][0]=0;
		for(int i=1;i<=m1;i++)
			dp[0][i]=dp[0][i-1]+1;
		for(int i=1;i<=m2;i++)
			dp[i][0]=dp[i-1][0]+1;
		
		for(int i=1;i<=m2;i++)
		{
			for(int j=1;j<=m1;j++){
				if(arr1[j-1]!=arr2[i-1])
					dp[i][j]=Math.min(Math.min(dp[i][j-1],dp[i-1][j]),dp[i-1][j-1])+1;
				else
					dp[i][j]=dp[i-1][j-1];
			}
		}
		for(int i=0;i<=m2;i++)
		{
			System.out.print(Arrays.toString(dp[i])+" ");
			System.out.println();
		}
		return dp[m2][m1];
	}
	public static void main(String[] args) {
		String str="kitten";
		String str1="sitting";
		int minEdtDis=minEditDist(str.toCharArray(),str1.toCharArray(),str.length(),str1.length());
		System.out.println(minEdtDis);
		
	}
}
