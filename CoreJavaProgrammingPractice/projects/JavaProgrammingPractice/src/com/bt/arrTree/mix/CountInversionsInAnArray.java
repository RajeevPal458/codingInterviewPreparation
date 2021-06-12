package com.bt.arrTree.mix;

public class CountInversionsInAnArray {

	public static int boubbleSort(int[] arr,int n){
		int inversion=0,temp;
		
		for(int i=0;i<n-1;i++){
			for(int j=0;j<n-i-1;j++){
				
				if(arr[j]>arr[j+1]){
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					inversion++;
				}
			}
		}
		return inversion;
	}
	
	public static void main(String[] args) {
		int[] arr= {8, 4, 2, 1};
		int n=arr.length;
		int inversions=boubbleSort(arr, n);
		System.out.println(inversions);
	}
}
