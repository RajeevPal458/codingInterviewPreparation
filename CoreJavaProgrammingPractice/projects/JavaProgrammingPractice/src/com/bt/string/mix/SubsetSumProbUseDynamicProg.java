package com.bt.string.mix;

public class SubsetSumProbUseDynamicProg {
	
	public static boolean isSumAvail(int arr[],int n,int sum){
		boolean flage=false;
		boolean dp[][]=new boolean[n+1][sum+1];
		for(int i=0;i<=n;i++)
			dp[i][0]=true;
		for(int j=1;j<=sum;j++)
			dp[0][j]=false;
		
		for(int i=1;i<=n;i++){
			
			for(int j=1;j<=sum;j++){
				dp[i][j]=dp[i-1][j];
				if(j>=arr[i-1])
					dp[i][j]=dp[i][j]||dp[i][j-arr[i-1]];
			}
		}
		return dp[n-1][sum-1];
	}
	public static void main(String[] args) {
		int arr[]={3,34,4,12,5,2};
		System.out.println(isSumAvail(arr,arr.length,7));;
		
	}

}
