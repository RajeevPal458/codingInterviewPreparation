package com.gfg.problems;

import java.util.Arrays;

public class NumberOfSwapsToSortWhenOnlyAdjacentSwappingAllowed {
	
	public static int requiredSwap(int [] arr,int n){
		int count=0;
		for(int i=0;i<n-1;i++){
			for(int j=0;j<n-i-1;j++){
				if(arr[j]>arr[j+1])
				{
					swap(arr,j,j+1);
					count++;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		return count++;
	}
	static int temp=0;
	public static void swap(int[] arr ,int i,int j){
		temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	public static void main(String[] args) {
		int arr[] = {3, 2, 1};
		System.out.println(requiredSwap(arr,arr.length));
	}
}
