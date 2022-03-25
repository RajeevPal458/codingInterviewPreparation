package com.gfg.problems;

public class CombinationSumProblem {

	public static void printData(int[] arr,int n){
		System.out.print("( ");
		for(int i=0;i<n;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.print(")");
		System.out.print(" ");
	}
	public static void findCombinationUtil(int[] arr,int[] data,int start,int index,int sum,int t_sum,int n){
		if(sum==t_sum){
			printData(data,index);
		}
		for(int i=start;i<=n&&index<=n;i++){
			data[index]=arr[i];
			findCombinationUtil(arr,data,i,index+1,sum+arr[i],t_sum,n);
		}
	}
	public static void findCombination(int[] arr,int n,int t_sum){
		int[] data=new int[20];
		findCombinationUtil(arr,data,0,0,0,t_sum,n-1);
	}
	public static void main(String[] args) {
		int[] arr={2,4,6,8};
		int n=arr.length;
		int sum=8;
		findCombination(arr, n, sum);

}
}
