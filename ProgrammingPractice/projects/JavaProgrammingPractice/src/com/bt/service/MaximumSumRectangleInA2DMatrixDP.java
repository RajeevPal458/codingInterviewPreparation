package com.bt.service;
import java.util.Arrays;

public class MaximumSumRectangleInA2DMatrixDP {
	static class Top{
		int top;
	}
	static class Down{
		int down;
	}
	public static int kadanes(int[] arr,Top t,Down d){
		int curSum,maxSum=arr[0],prevSum=arr[0];
		t.top=0;d.down=0;
		for(int i=1;i<arr.length;i++){
			curSum=arr[i];
			if((curSum+prevSum)<=curSum &&(maxSum<=curSum)){
				maxSum=curSum;prevSum=curSum;
				t.top=i;d.down=i;
			}
			else if((curSum+prevSum)<=prevSum || (curSum+prevSum)<maxSum){
				prevSum=(curSum+prevSum);
			}
			else {
				d.down=i;
				prevSum=curSum+prevSum;
				maxSum=prevSum;
			}
		}
		return maxSum;
	}
	public static void findMaxSum(int[][] arr,int M,int N){
		int[] dp=new int[M];
		Top t=new Top();
			t.top=0;
		Down d=new Down();
		d.down=0;
		int currMaxSum=0;
		int globalMaxSum=0;
		
		int finalLeft =0;
		int finalRight = 0;
		int finalTop = 0;
		int finalBottom = 0;
		for(int left=0;left<N;left++){
			Arrays.fill(dp,0);
			for(int right=left;right<N;right++){
				
				for(int row=0;row<M;row++){
					dp[row]+=arr[row][right];
				}
				
				currMaxSum=kadanes(dp, t, d);
				
				if(globalMaxSum<currMaxSum){
					globalMaxSum=currMaxSum;
					 finalLeft = left;
		             finalRight = right;
		             finalTop = t.top;
		             finalBottom = d.down;
				}
			}
		}
		
		System.out.println("Maximum Sum is:"+globalMaxSum);
		System.out.println("TopLeft:"+finalLeft+" TopRight:"+finalTop);
		System.out.println("DownLeft:"+finalRight+" DownRight:"+finalBottom);
		
		// for 1D sub arra
	}
	public static void main(String[] args) {
		 int[][] M= {	{1, 2, -1, -4, -20},
                 		{-8, -3, 4, 2, 1},
                 		{3, 8, 10, 1, 3},
                 		{-4, -1, 1, 7, -6}
                	};

		 findMaxSum(M,4,5);

	}
}
