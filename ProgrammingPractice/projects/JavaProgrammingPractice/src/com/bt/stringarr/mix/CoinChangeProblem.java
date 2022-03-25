package com.bt.stringarr.mix;

public class CoinChangeProblem {
	public int coinChange(int[] coin,int n,int sum){
		int dp[][] =new int[n+1][sum+1];
		for(int i=0;i<=sum;i++)
			dp[0][i]=0;
		for(int i=0;i<=n;i++)
			dp[i][0]=0;
		for(int i=1;i<=n;i++){
			for(int j=1;j<=sum;j++){
				if(j<coin[i-1])
					dp[i][j]=dp[i-1][j];
				else
					dp[i][j]=Math.max(1+dp[i-1][j-coin[i-1]],dp[i-1][j]);
			}
		}
		return dp[n][sum];
	}
	public static void main(String[] args) {
		int[] coin={1,5,6,8};
		int total=11;
		CoinChangeProblem cp=new CoinChangeProblem();

		System.out.println(cp.coinChange(coin,coin.length,total));
	}
}
