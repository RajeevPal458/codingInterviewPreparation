package com.bt.stringarr.mix;
import java.util.Arrays;

public class OptimalBinarySearchTree {

	public static int obstDP(int[] cost,int i,int j){
		
		if(i>j) return 0;
		if(i==j)
				return cost[i];
		int fsum=sum(cost, i, j);
		int min=9999999;
		for(int r=i;r<=j;r++){
			int cst=obstDP(cost,i,r-1)+obstDP(cost,r+1,j);
			if(cst<min){
				min=cst;
		}
		}
		
		return min+fsum;
	}
	//dp approach.........
	public static int obst(int[] keys,int[] cost,int len){
		int[][] dp=new int[len][len];
		
		for(int i=0;i<len;i++)
			dp[i][i]=cost[i];
		int min;
		
		for(int cur=2;cur<=len;cur++){
			for(int i=0;i<len-cur+1;i++)
			{
				int j=i+cur-1;
				dp[i][j]=99999999;
				for(int r=i;r<=j;r++){
					int c=((r>i)?dp[i][r-1]:0) +((r<j)?dp[r+1][j]:0)+sum(cost,i,j);
					if(c<dp[i][j])
						dp[i][j]=c;
				}
			}
		}
		
		
		for(int i=0;i<len;i++)
		{
			System.out.print(Arrays.toString(dp[i])+" ");
			System.out.println();
		}
		return dp[0][len-1];
	}
	static int sum(int freq[], int i, int j)
	{
	    int s = 0;
	    for (int k = i; k <=j; k++)
	       s += freq[k];
	    return s;
	}
	public static void main(String[] args) {
		int[] keys={10,12,16,21};
		int[] cost={4,2,6,3};
		int len=keys.length;
		System.out.println();
		System.out.println(obst(keys, cost, len));
		System.out.println();
		System.out.println(obstDP(cost, 0, len-1));
	}
}
