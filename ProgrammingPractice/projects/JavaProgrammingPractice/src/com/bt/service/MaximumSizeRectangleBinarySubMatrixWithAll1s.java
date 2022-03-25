package com.bt.service;
import java.util.Arrays;
import java.util.Stack;

public class MaximumSizeRectangleBinarySubMatrixWithAll1s {

	
	public static int maxAreaRactangleUsingHistogram(int[] arr,int len){
		int max=0,gmax=0;
		int top;
		Stack<Integer> stack=new Stack<>();
		int i;
		for(i=0;i<len;i++){
			
			if(stack.isEmpty()||(arr[i]>=arr[stack.peek()])){
				stack.push(i);
				continue;
			}
			while(!stack.isEmpty()&&(arr[i]<arr[stack.peek()])){
				top=stack.pop();
				if(!stack.isEmpty())
					max=arr[top]*(i-stack.peek()-1);
				else
				{
					max=arr[top]*i;
					i--;
				}
				if(gmax<max)
					gmax=max;
			}
		}
		while(!stack.isEmpty()) {
			top=stack.pop();
			if(!stack.isEmpty())
				max=arr[top]*(i-stack.peek()-1);
			else
				max=arr[top]*i;
			if(gmax<max)
				gmax=max;
		}
		
		
		return gmax;
	}
	public static void maxRectangle(int[][] arr,int row,int col){
		int	max=0;
		int[] dp=new int[col];
		Arrays.fill(dp,0);
		int globalMax=0;
		for(int i=0;i<row;i++){
			
			for(int j=0;j<col;j++){
				if(arr[i][j]!=0)
					dp[j]+=arr[i][j];
				else
					dp[j]=0;
			}
			System.out.println(Arrays.toString(dp));
				max=maxAreaRactangleUsingHistogram(dp, col);
				System.out.println("MAX:"+max);
				if(globalMax<max)
					globalMax=max;
				System.out.println("GLOBAL MAX:"+globalMax);
				
		}
		System.out.println("MaximumSizeRectangleBinarySubMatrixWithAll1s:"+globalMax);
	}
	public static void main(String[] args) {
		int[][] A = { {0, 1, 1, 0},
                	  {1, 1, 1, 1},
                	  {1, 1, 1, 1},
                	  {1, 1, 0, 0},
              		};
		maxRectangle(A,4,4);
	}
}
