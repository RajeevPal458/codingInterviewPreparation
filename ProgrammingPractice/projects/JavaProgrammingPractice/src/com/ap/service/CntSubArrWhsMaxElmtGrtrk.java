package com.ap.service;

///Count of subarrays whose maximum element is greater than k
public class CntSubArrWhsMaxElmtGrtrk {

	public static void main(String[] args) {
		int arr[] = {1, 2, 3,4};
	    int k = 2;
	    int n = arr.length;
	    System.out.println(countSubarray(arr, n, k));	
	}

	private static int countSubarray(int[] arr, int n, int k) {
		int count=0;
		int totalSubArr=(n*(n+1))/2;
		for(int i=0;i<n;i++){
			
			if(arr[i]<=k)
				count++;
		}
		int smallSubArr=(count*(count+1))/2;
		return totalSubArr-smallSubArr;
	}
}