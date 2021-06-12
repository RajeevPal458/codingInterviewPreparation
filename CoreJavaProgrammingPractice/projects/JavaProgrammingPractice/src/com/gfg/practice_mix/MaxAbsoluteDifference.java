package com.gfg.practice_mix;

import java.util.Arrays;

public class MaxAbsoluteDifference {
	static int[] data;
	static int minsum=0,lastIndexmin;
	static int[] minsumarr;
	//..............................
	static int maxsum=-1,lastIndexmax;
	static int[] maxsumarr;;
	public static void combinationUtill(int[] arr,int start,int end,int index,int sum,int t_sum){

		if(index<=end&&data[index]!=0){
			printSubArray(data, index);
			System.out.println();
			return;
		}
		for(int i=start;i<=end&&index<=end;i++){
			data[index]=arr[i];
			combinationUtill(arr,i+1,end,index+1,sum+arr[i],t_sum);
			if(index+1<=end){
				index+=1;
				sum+=arr[i];
			}
		}
		
	}
	public static void printSubArray(int[] arr,int n){
		
		for(int i=0;i<n;i++){
			System.out.print(arr[i]+" ");
		}
	}
	public static void combination(int[] arr,int len){
		// for min sub arr
		data=new int[len];
			combinationUtill(arr,0,len-1,0,0,-1);
//			printSubArray(minsumarr, lastIndexmin);
		// for max sub arr 
			System.out.println();
			data=new int[len];
			//combinationUtill(arr,0,len-1,0,0,1);
			//printSubArray(maxsumarr, lastIndexmax);
			
	}
	  public static void main(String[] args) {
		int[] arr={-2, -3, 4, -1, -2, 1, 5, -3};
		int len=arr.length;
		MaxAbsoluteDifference.combination(arr, len);
		
	}
}
