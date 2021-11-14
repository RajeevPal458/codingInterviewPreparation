package org.algo.strarr;

public class SlidingWindowMaximum {

	public static void findMaxOfSegment(int arr[],int k,int n){
		int max1=arr[0];
		for(int i=0;i<k;i++)
			if(max1<arr[i])
				max1=arr[i];
		System.out.print(max1+" ");
		for(int i=0;i<n-k;i++){
			if(max1<arr[i+k])
				max1=arr[i+k];
			System.out.print(max1+" ");
		}
	}
	
	public static void main(String[] args) {
		int arr[] = {12, 1, 78, 90, 57, 89, 56};
		int k = 3;
		findMaxOfSegment(arr, k,arr.length);
	}
}
