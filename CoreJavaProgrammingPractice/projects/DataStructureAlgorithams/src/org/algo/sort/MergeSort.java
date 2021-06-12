package org.algo.sort;

public class MergeSort {

	public static void sort(int[] mergesortArr) {
		int n=mergesortArr.length-1;
		MergeSort.mergeSort(mergesortArr , 0 ,n);
	}

	private static void mergeSort(int[] mergesortArr, int l, int r) {
		// TODO Auto-generated method stub
		if(l<r){
			int mid  = (l+r)/2 ;
			
			mergeSort(mergesortArr, l, mid);
			mergeSort(mergesortArr, mid+1, r);
			merge(mergesortArr , l , mid , r);
			
		}
	}

	private static void merge(int[] arr, int l, int mid, int r) {
		// TODO Auto-generated method stub
		int leftLen =  mid -l+1;
		int rightLen = r - mid;
		
		int[] left = new int[leftLen];
		int[] right = new int[rightLen];
		
		CopyLeftToRightArray.copyFromRange(arr , l ,mid ,leftLen ,left);
		CopyLeftToRightArray.copyFromRange(arr , mid+1 ,r ,rightLen ,right);
		
		System.out.print("Left Array:");
		PrintArray.printIntArr(left);
		
		System.out.print("right Array: ");
		PrintArray.printIntArr(right);
		
		int leftStart= 0;
		int rightStart= 0;
		
		while(leftStart < leftLen && rightStart <rightLen){
			
			if(left[leftStart] < right[rightStart] && l<=r){
				arr[l++] =left[leftStart++];
			}else if(right[rightStart] < left[leftStart] && l<=r){
				arr[l++] =right[rightStart++];
			}
		}
		
		while (leftStart < leftLen && l<=r) {
			arr[l++] =left[leftStart++];
		}
		
		while (rightStart < rightLen && l<=r) {
			arr[l++] =right[rightStart++];
		}
		
		System.out.print("merged Array: :l :"+l+" r: "+r);
		PrintArray.printIntArr(arr);
		
		System.out.println();System.out.println();

	}

}
