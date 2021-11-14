package org.algo.sort;

import java.util.Arrays;

public class HeapSort {

	public static void sort(int[] heapArr) {
		int len = heapArr.length;
		
		for (int i =(len/2)-1; i >=0 ; i--) {
			HeapSort.hippyfy(heapArr ,i ,len);
		}
		System.out.println("Heap created !");
		for(int i=len-1;i >0;i--){
			int  lastnum =heapArr[i];
			heapArr[i] = heapArr[0];
			heapArr[0] = lastnum ;
			HeapSort.hippyfy(heapArr ,0 ,i);
		}
	}

	private static void hippyfy(int[] arr, int i, int len) {
		int max = i;
		int left=2*i+1;
		int right=2*i+2;
		
		System.out.println("arr :"+Arrays.toString(arr) + " :i: "+i+" : len: "+len+":left:"+left+":right:"+right);
		if(left < len && arr[left]  > arr[max]){
			max=left;
		}
		
		if(right < len && arr[right]  > arr[max]){
			max=right;
		}
		
		System.out.println("max:"+max);
		if(max !=i){
			int temp  =arr[i];
			arr[i] =arr[max];
			arr[max] = temp;
			HeapSort.hippyfy(arr, max, len);
		}
		
	}

	
	
}
