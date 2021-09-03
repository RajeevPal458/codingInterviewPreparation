package org.algo.strarr;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class PrintAllPairsWithGivenSumInArray {

	public static void main(String[] args) {
		int arr[] = {1, 5, 7, -1, 5};
		int sum = 6;
		int len = arr.length;
		allpairs(arr ,len , sum );
		System.out.println();
		allpairs2(arr ,len , sum );
	}

	private static void allpairs(int[] arr, int len, int sum) {

		for(int i=0;i<len;i++) {
			
			for(int j=i+1;j<len;j++) {
				if(arr[i]+arr[j] == sum) {
					System.out.print("( "+arr[i] +" ,"+arr[j]+" ) ");
				}
			}
		}
	}
	
	private static void allpairs2(int[] arr, int len, int sum) {
		
		Set<Integer> set = new LinkedHashSet<Integer>();
		set.add(arr[0]);
		
		for(int i=1;i<len;i++) {
			if(set.contains(sum-arr[i])) {
				System.out.print("( "+(sum-arr[i]) +","+arr[i]+" ) ");
			}
			set.add(arr[i]);
		}
	}
}





