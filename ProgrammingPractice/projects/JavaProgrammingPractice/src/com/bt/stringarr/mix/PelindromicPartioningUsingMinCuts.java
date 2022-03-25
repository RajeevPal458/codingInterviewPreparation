package com.bt.stringarr.mix;
import java.util.Arrays;

public class PelindromicPartioningUsingMinCuts {
boolean T=true;
boolean F=false;
boolean[][] dp;
	public void pelindromicPartitioningTable(char[] arr,int n){
		dp=new boolean[n][n];
		
		for(int i=0;i<n;i++){
			dp[i][i]=T;
		}
		
		for(int cur=2;cur<=n;cur++){
			for(int i=0;i<n-cur+1;i++){
				int j=cur+i-1;
				if((arr[i]==arr[j])&&(dp[i+1][j-1]==T))
					dp[i][j]=T;
				else
					dp[i][j]=F;
			}
		}
	}
	public int findMinCuts(int n){
		int[] cuts=new int[n];
		
		for(int i=0;i<n;i++){
			int temp=99999;
			if(dp[0][i])
				cuts[i]=0;
			else
			{
				for(int j=0;j<i;j++)
					if(dp[j+1][i]&&temp>(cuts[j]+1))
						temp=cuts[j]+1;
				cuts[i]=temp;
			}
			System.out.print(Arrays.toString(cuts));
			System.out.println();
		}
		return cuts[n-1];
	}
	public static void main(String[] args) {
		String str="banana";
		int n=str.length();
		PelindromicPartioningUsingMinCuts pp=new PelindromicPartioningUsingMinCuts();
		pp.pelindromicPartitioningTable(str.toCharArray(), n);
		for(int i=0;i<n;i++){
			System.out.print(Arrays.toString(pp.dp[i])+" ");
			System.out.println();
		}
		System.out.println("Minimum cuts:"+pp.findMinCuts(n));
		
	}
}
