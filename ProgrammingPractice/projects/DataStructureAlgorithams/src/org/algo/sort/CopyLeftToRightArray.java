package org.algo.sort;

public class CopyLeftToRightArray {

	public static void copyFromRange(int[] arr, int start, int end, int len, int[] temp) {
		for(int i =0 ; (i< len) && (start <= end) ; i++){
			temp[i] = arr[start++];
		}
		
	}

}
