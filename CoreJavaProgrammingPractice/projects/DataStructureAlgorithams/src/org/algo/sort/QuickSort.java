package org.algo.sort;

import java.util.Arrays;

public class QuickSort {

	public static void sort(int[] quickArr) {

		int n = quickArr.length-1;
		
		quickSort(quickArr , 0 ,n) ;
	}

	private static void quickSort(int[] quickArr, int l, int r) {
		// TODO Auto-generated method stub
		if(l<r){

			int pivot = findPivot(quickArr ,l ,r);
			quickSort(quickArr, l, pivot-1);
			quickSort(quickArr, pivot+1, r);
		}
		
	}

	private static int findPivot(int[] arr, int low, int high) {
	    int pivot = arr[high];
	    int i = (low - 1);
	    System.out.println(":pivot:"+pivot+":low:"+low+":high:"+high+": arr :"+Arrays.toString(arr));
	    for(int j = low; j < high; j++)
	    {
	        if (arr[j] <= pivot)
	        {
	            i++;
	            System.out.println(":i:"+i+":j:"+j);
	            SwapInArray.swapIndexValue(arr, i, j);
	        }
	    }
	    SwapInArray.swapIndexValue(arr, i + 1, high);
	    System.out.println(":pivot:"+(i+1)+": arr :"+Arrays.toString(arr));
	    System.out.println(); System.out.println();
	    return (i + 1);  //[3, 2, 5, 4, 7, 6, 9, 1, 8, 10]
	}

}
