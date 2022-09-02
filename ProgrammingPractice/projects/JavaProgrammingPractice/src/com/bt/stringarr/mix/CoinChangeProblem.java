package com.bt.stringarr.mix;

public class CoinChangeProblem {
	public int coinChange(int[] coin,int n,int sum){
		int dp[][] =new int[n+1][sum+1];
		for(int i=0;i<=n;i++)
			dp[i][0]=0;
		for(int i=0;i<=n;i++)
			dp[0][i]=0;
		for(int i=1;i<=n;i++){
			for(int j=1;j<=sum;j++){
				
				if(j<coin[i-1])
					dp[i][j]=dp[i-1][j];
				else
					dp[i][j]=Math.max(1+dp[i-1][j-coin[i-1]],dp[i-1][j]);
			}
		}
		
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=sum;j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		return dp[n][sum];
	}
	
	
	public int coinChange2(int[] coin,int n,int sum){
		int dp[][] =new int[sum+1][n+1];
		for(int i=0;i<=n;i++)
			dp[0][i]=1;
		for(int i=0;i<=sum;i++)
			dp[i][0]=0;
		for(int i=1;i<=sum;i++){
			for(int j=1;j<=n;j++){
		
				dp[i][j]=dp[i][j-1];
				if(i>=coin[j-1])
					dp[i][j]+=dp[i-coin[j-1]][j];
			}
		}
		
		for(int i=0;i<=sum;i++) {
			for(int j=0;j<=n;j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		return dp[sum][n];
	}
	
	
	public static void main(String[] args) {
		int[] coin={1,2,3};
		int total=4;
		CoinChangeProblem cp=new CoinChangeProblem();

		System.out.println(cp.coinChange2(coin,coin.length,total));
	}
	
	
}
