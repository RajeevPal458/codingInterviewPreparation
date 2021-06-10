package org.algo.sort;

public class SelectionSort {

	public static void sort(int[] arr){
		
		for (int i = 0; i < arr.length; i++) {
			int min =arr[i];
			for (int j = i+1; j < arr.length-1; j++) {
				if(arr[j] <min){
					min =arr[j];
				}
			}
			arr[i]=min;
		}
	}
}
