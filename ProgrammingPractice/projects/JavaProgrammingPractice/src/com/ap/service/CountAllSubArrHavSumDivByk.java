package com.ap.service;

//Count all sub-arrays having sum divisible by k

public class CountAllSubArrHavSumDivByk {

	public static void main(String[] args) {
		int arr[] = {4, 5, 0, -2, -3, 1};
	    int k = 5;
	    int n = arr.length;
	    System.out.println(subCount(arr, n, k));
	    
	    int arr1[] = {4, 5, 0, -12, -23, 1};
	    int k1 = 5;
	    int n1 = arr1.length;
	    //System.out.println(subCount(arr1, n1, k1));
	}

	private static int subCount(int[] arr, int n, int k) {
		int sum=0,count=0;
		
		for(int i=0;i<n;i++){
			
			for(int j=i;j<n;j++){
				
				sum +=arr[j];
				if(sum%k==0)
				{
					count++;
					System.out.print(" i"+i+" " +count);
				}
			}
			sum=0;
			System.out.println();
		}
		return count;
	}
}
