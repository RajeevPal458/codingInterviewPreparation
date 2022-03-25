package org.algo.sort;

public class BubbleSort {

	public static void sort(int[] arr){
		
		for(int i=0 ; i<arr.length;i++){
			for (int j = 0; j < arr.length-i-1; j++) {
				if(arr[j]>arr[j+1]){
					SwapInArray.swapIndexValue(arr, j, j+1);
				}
			}
		}
	}
}
