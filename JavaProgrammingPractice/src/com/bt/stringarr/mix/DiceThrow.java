package com.bt.stringarr.mix;
import java.util.Arrays;
import java.util.Scanner;

public class DiceThrow {
	int count=0;
	//Native Approach!
		static long callCount=0;
	    public  int isFromNUtil(int N, int A, int S, int []diceValues)
	    {
	        callCount++;
	 
	        if (N<=0)
	            return 0;
	 
	        if (N==1)
	        {
	            if (S>=1 && S<=A)
	            {
	                diceValues[0] = S;
	                for (int i : diceValues)
	                    System.out.print(i+", ");
	                System.out.println();
	                return 1;
	            }
	            else
	                return 0;
	        }
	 
	        int numSolutions = 0;
	        for(int i=1; i<=A; i++)
	        {
	            diceValues[N-1] = i;
	            numSolutions += isFromNUtil(N-1, A, S-i, diceValues);
	        }
	 
	        return numSolutions;
	    }
	   public void diceThrowNative(int dice,int faces,int t_sum){
	    	int[] data=new int[dice];
	    	count=isFromNUtil(dice,faces,t_sum, data);
	    }
	// DP Approach !
	public int diceThrowDP(int dice,int faces,int t_sum){
		int[][] dp=new int[dice+1][t_sum+1];
		for(int i=0;i<=dice;i++){
			for(int j=0;j<=t_sum;j++){
				dp[i][j]=0;
			}
		}
		
		for(int j=1;j<=faces&&j<=t_sum;j++){
			dp[1][j]=1;
		}
		
		for(int i=2;i<=dice;i++){
			for(int j=1;j<=t_sum;j++){
				for(int k=1;k<=faces&&k<j;k++){
					dp[i][j]+=dp[i-1][j-k];
				}
			}
		}
		for(int i=0;i<=dice;i++){
			for(int j=0;j<=t_sum;j++){
				System.out.print(dp[i][j]+" ");;
			}
			System.out.println();
		}
		return 0;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter number of dice!");
		int dice=Integer.parseInt(sc.nextLine());
		
		System.out.println("Enter number of Dice faces!");
		int faces=Integer.parseInt(sc.nextLine());
		
		System.out.println("Enter Query to get target Sum!");
		int t_sum=Integer.parseInt(sc.nextLine());
		
		DiceThrow dp=new DiceThrow();
		//dp.diceThrowNative(dice, faces,t_sum);
		//System.out.println("(Native Aproach:>)Number of ways To get Sum: "+t_sum+" is:"+dp.count);
		dp.count=0;
		dp.diceThrowDP(dice, faces,t_sum);
		System.out.println("(DP Aproach:>)Number of ways To get Sum: "+t_sum+" is:"+dp.count);
		
	}
}
