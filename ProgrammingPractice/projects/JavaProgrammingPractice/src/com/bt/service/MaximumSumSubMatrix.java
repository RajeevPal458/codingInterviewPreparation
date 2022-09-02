package com.bt.service;

public class MaximumSumSubMatrix {
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
	public static void main(String[] args) {
		int[] arr={4,-2,3,1,-6,-2,3,0};
		/* t d maxSum preSum curSum
		 * 0 0    -1    -1     -1
		 * 1 1	   3	 3	    3
		 * 1 1     3     1     -2
		 * 	                   1
		 * 
		 * 
		 * 
		 */
		
		
		
		Top t=new Top();
		Down d=new Down();
		int sum=kadanes(arr, t, d);
		
		System.out.println("Maximum Sum is:"+sum+" From:"+t.top+" To:"+d.down);
		
	}
}
