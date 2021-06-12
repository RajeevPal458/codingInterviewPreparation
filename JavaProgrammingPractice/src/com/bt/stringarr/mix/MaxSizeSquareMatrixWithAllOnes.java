package com.bt.stringarr.mix;
import java.util.Arrays;

public class MaxSizeSquareMatrixWithAllOnes {

	public static int maxSizeMatx(int[][] arr,int n){
		int[][] dp=new int[n][n];
		int max=0,x;
		for(int i=0;i<n;i++){
			dp[0][i]=arr[0][i];
			dp[i][0]=arr[i][0];
		}
		
		for(int i=1;i<n;i++){
			for(int j=1;j<n;j++){
				if(arr[i][j]!=0)
				{
					x=dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i-1][j-1]),dp[i][j-1])+1;
					if(max<x)
						max=x;
				}
			}
		}
		for(int i=0;i<n;i++)
		{
			System.out.print(Arrays.toString(dp[i]));
			System.out.println();
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[][] arr={{0,1,1,0,1,1},
					 {1,1,0,1,1,1},
					 {0,1,1,1,0,0},
					 {1,1,1,1,0,0},
					 {1,1,1,1,1,0},
					 {0,1,1,1,0,1}
					};
		System.out.println(maxSizeMatx(arr,arr[0].length));
	}
}
