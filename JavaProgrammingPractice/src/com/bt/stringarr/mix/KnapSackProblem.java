package com.bt.stringarr.mix;

public class KnapSackProblem {
	private static int knapSack(int w, int[] wt, int[] val, int n) {
		// TODO Auto-generated method stub
		int[][] dp=new int[n][w+1];
		
		for(int i=0;i<n;i++)
			dp[i][0]=0;
		for(int j=10;j<=w;j+=j)
			dp[0][j]=val[0];
		for(int i=1;i<n;i++){
			for(int j=10;j<=w;j+=10){
				if(j<wt[i])
					dp[1][j]=dp[i-1][j];
				else{
					dp[i][j]=Math.max(val[i]+dp[i-1][j-wt[i]],dp[i-1][j]);
				}
			}
		}
		return dp[n-1][w];
	}
	/*  0 10 20 30 40 50
	10  0 60 60 60 60 60
	20  0 60    
	30  0
	*/
	public static void main(String[] args) {
		int val[] = {60, 100, 120};
	    int wt[] = {10, 20, 30};
	    int  W = 50;
	    int n = val.length;
	    System.out.println(knapSack(W, wt, val, n));
	    
	}
}
