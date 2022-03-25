package com.bt.stringarr.mix;
import java.util.Arrays;

public class SumOfSubsetsDP {
	boolean[][] dp;
	int len;
	boolean T=true,F=false;
	
	SumOfSubsetsDP(int len,int t_sum){
		this.len=len;
		dp=new boolean[len+1][t_sum+1];
	}
	public boolean checkSubsets(int[] weights,int size,int t_sum){
		
		for(int i=0;i<=len;i++)
			dp[i][0]=T;
		for(int i=1;i<=len;i++)
			dp[0][i]=F;
		for(int i=1;i<=len;i++){
			for(int j=1;j<=t_sum;j++){
				dp[i][j]=dp[i-1][j];
				
				if(j>=weights[i-1]&&(dp[i][j]==F)){
					dp[i][j]=dp[i-1][j-weights[i-1]];
				}
			}
		}
		for(int i=0;i<=len;i++){
			for(int j=0;j<=t_sum;j++){
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		return dp[len][t_sum];
	}
	public static void main(String[] args) {
		int weights[] = {10, 7, 5, 18, 12, 20, 15};
	    int size =weights.length;
	    SumOfSubsetsDP gs=new SumOfSubsetsDP(size,35);
	    if(gs.checkSubsets(weights, size, 35))
	    	System.out.println("subset is available with sum:35");
	    else
	    	System.out.println("subset is not available with sum:35");
	}
}
