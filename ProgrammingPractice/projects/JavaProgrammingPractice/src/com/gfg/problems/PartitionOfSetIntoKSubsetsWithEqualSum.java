package com.gfg.problems;

public class PartitionOfSetIntoKSubsetsWithEqualSum {

	public static void printData(int[] arr,int n){
		System.out.print("( ");
		for(int i=0;i<n;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.print(")");
		System.out.print(" ");
	}
	static int count=0;
	public static void findCombinationUtil(int[] arr,int[] data,int start,int index,int sum,int t_sum,int n){
		if(sum==t_sum){
			printData(data,index);
			count++;
		}
		for(int i=start;i<=n&&index<=n;i++){
			data[index]=arr[i];
			findCombinationUtil(arr,data,i+1,index+1,sum+arr[i],t_sum,n);
		}
	}
	public static void findCombination(int[] arr,int n,int t_sum){
		int[] data=new int[20];
		findCombinationUtil(arr,data,0,0,0,t_sum,n-1);
	}
	public static void main(String[] args) {
		int[] arr={2, 1, 4, 5, 6};
		int n=arr.length;
		int sum=0,k=3;
		for(int i=0;i<arr.length;i++){
			sum+=arr[i];
		}
		
		findCombination(arr, n, sum/3);
		if(count==k){
			System.out.println("YES-"+k+":equal Partition can be done! ");
		}
		else{
			System.out.println("NO-"+k+":equal Partition can't be done! ");
		}

	}
}
