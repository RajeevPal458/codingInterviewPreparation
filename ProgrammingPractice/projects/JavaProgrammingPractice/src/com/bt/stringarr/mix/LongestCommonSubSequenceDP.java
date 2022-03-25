package com.bt.stringarr.mix;
import java.util.ArrayList;
import java.util.Arrays;

public class LongestCommonSubSequenceDP {
	static int[][] dp;
	static int[][] pointer;
	static final int s1=1,s2=2;
	public static void lcsubSequence(char[] col,char[] row,int clen,int rlen){
		dp=new int[rlen][clen];
		pointer=new int[rlen][clen];
		dp[0][0]=0;
		//pointer[0][0]=-1;
		
		System.out.println(":"+clen+":"+Arrays.toString(col));
		System.out.println("rlen:"+rlen+":"+Arrays.toString(row));
		System.out.println();
		for(int i=0;i<rlen;i++){
			for(int j=0;j<clen;j++){
				System.out.print("i:"+i+"j:"+j);
				if(row[i]==col[j]){
					
					if(i==0&&j==0)
						dp[i][j]=1;
					else
						if(i>0&&j>0)
							dp[i][j]=dp[i-1][j-1]+1;
					pointer[i][j]=s1/s2;
				}
				else{
					if(i>0&&j>0){
						if(dp[i][j-1]>dp[i-1][j]){
							dp[i][j]=dp[i][j-1];
							pointer[i][j]=s1;
						}
						else{
							dp[i][j]=dp[i-1][j];
							pointer[i][j]=s2;
						}
					}
					if((i==0)&&(j>0)){
						dp[i][j]=dp[i][j-1];
						pointer[i][j]=s1;
					}
					else if((j==0)&&(i>0)){
						dp[i][j]=dp[i-1][j];
						pointer[i][j]=s2;
					}	
				}
			}
		}
		for(int i=0;i<rlen;i++)
		{
			System.out.print(Arrays.toString(dp[i]));
			System.out.println();
		}
		System.out.println();
		for(int i=0;i<rlen;i++)
		{
			System.out.print(Arrays.toString(pointer[i]));
			System.out.println();
		}
		int i=rlen-1;
		int j=clen-1;
		StringBuffer sb=new StringBuffer();
		while(i>=0&&j>=0){
			switch(pointer[i][j]){
			
				case s1/s2:sb.append(col[j]);
							i--;j--;break;
				case s1: j--;break;
				
				case s2: i--;break;
			}
		}
		System.out.println(sb.toString());
		
	}
	public static void main(String[] args) {
		String str1="DCBEA";
		String str2="ADCA";
		lcsubSequence(str2.toCharArray(),str1.toCharArray(),str2.length(),str1.length());
		
	}
	
}
