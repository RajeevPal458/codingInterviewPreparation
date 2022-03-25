package com.gfg.problems;

import java.util.Arrays;

public class LargestPermutationAfterAtMostKSwaps {
	static int[] pos;
	//first concept...........
	//here all alement of arr should be less or equal to n
	private static void KswapPermutation(int[] arr, int n, int k) {
		// TODO Auto-generated method stub
		pos=new int[n+1];
		
		for(int i=0;i<n;i++)
			pos[arr[i]]=i;
		
		for(int i=0;i<n;i++){
			
			if(arr[i]==n-i)
				continue;
			int temp=pos[n-i];
			
			pos[arr[i]]=pos[n-i];
			pos[n-i]=i;
			
			swap(arr,temp,i);
			k--;
		}
	}
	private static void swap(int[] arr, int i, int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	//second concept using lexicographic order concept.....
	public static void main(String[] args) {
		int arr[] = {4, 5, 2, 1, 3};
	    int n = arr.length;
	    int k = 3;
	 
	    KswapPermutation(arr, n, k);
	    System.out.println("Largest permutation after "+k +" swaps");
	    for (int i=0; i<n; ++i)
	        System.out.print(arr[i]+" ");
		
	}

}
