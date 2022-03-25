package org.algo.strarr;

import java.util.Arrays;

public class PrintAllPossibleCombinationsInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4};
		int n = arr.length;
		printAllCombinations(arr,n);
	}

	private static void printAllCombinations(int[] arr, int n) {
		// TODO Auto-generated method stub
		for(int r=1;r<=n;r++) {
			int[] data = new int[r];
			 printAllCombinationsUtill(arr, 0, n, r, data, 0);
		}
	}

	private static void printAllCombinationsUtill(int[] arr,int start ,int n, int r,int[] data ,int index) {
		// TODO Auto-generated method stub
		if(index==r) {
			System.out.println(Arrays.toString(data));
		}
		
		for(int i=start;i<n&&index<r;i++) {
			data[index] = arr[i];
			printAllCombinationsUtill(arr, i+1, n, r, data, index+1);
			while((i+1<n)&&arr[i] == arr[i+1])
				i++;
		}
	}
}






