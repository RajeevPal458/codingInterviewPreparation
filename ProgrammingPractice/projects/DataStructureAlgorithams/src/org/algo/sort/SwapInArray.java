package org.algo.sort;

public class SwapInArray {

	public static void  swapIndexValue(int[] arr , int l , int r){
		int temp = arr[l];
		arr[l] = arr[r];
		arr[r] = temp;
	}
}
