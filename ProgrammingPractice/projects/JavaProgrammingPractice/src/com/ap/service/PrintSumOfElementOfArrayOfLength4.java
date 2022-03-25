package com.ap.service;

public class PrintSumOfElementOfArrayOfLength4 {

	public static void printSubSet(int[] arr,int n){
		
		for(int i=0;i<n-2;i++){
			
			for(int j=i+1;j<n-1;j++){
				
				for(int k=j+1;k<n;k++){
					System.out.println(arr[i]+" "+arr[j]+" "+arr[k]);
				}
				
			}
			
		}
		
	}
	
	
	public static void main(String[] args) {
		int [] arr={1,2,3,4,5};
		int len=arr.length;
		printSubSet(arr, len);
		
	}
}
