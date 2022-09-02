package com.ap.service;

import java.util.Arrays;

public class MaxPathSum {

	public static int[] findMaxSum(int A[], int n){
		int dp[]=new int[n];
		
		for(int j=0;j<n;j++)
			dp[j]=0;
		for(int i=0;i<n;i++){
			dp[i]=A[i];
			int maxi=0;
			for(int j=1;j<=Math.sqrt(i+1);j++){
				if((i+1)%j==0&&(i+1)!=j){
					
					if(dp[j-1]>maxi)
						maxi=dp[j-1];
					if(dp[(i+1)/j-1]>maxi&&j!=1)
						maxi=dp[(i+1/j-1)];
				}
			}
			dp[i]+=maxi;
		}
		return dp;
	}
	public static void main(String[] args) {
		int A[]={2,3,1,4,6,5};
		int B[];
		int m=A.length;
		System.out.println(Arrays.toString(findMaxSum(A,m)));
		
	}
}
// we can jums from y to x if y < x  
//print max sum path ending with every position x  where    1<= x <=n. here position is index +1.
//  OutPut:-={2,5,3,9,8,10};