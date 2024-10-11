package org.leet.code.goldmansachs;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// sliding window technic
public class FindSubArrayOfSize3HavingMaxSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = {3,2,4,5,3,2,1,6,12,3,11,2};
//		int subarrSize=3;
//		maxSumSubArray(arr,arr.length,subarrSize);
		List<Integer> list =Arrays.asList(5,3,67,4,3,5);
		Collections.sort(list,Comparator.reverseOrder());
		System.out.println(list);
	}

	private static void maxSumSubArray(int[] arr, int length,int subarrSize) {
		
		int maxSum = Integer.MIN_VALUE;
		int sum=0;
		int i=0;
		
		while (i<subarrSize) {
			sum +=arr[i++];
		}
		System.out.println(sum +":i:"+i);
		if(sum>maxSum) maxSum = sum;
		
		while (i<length) {
			 sum = sum - arr[i-subarrSize] + arr[i];
			 
			 if(sum>maxSum) maxSum = sum;
			 System.out.println(sum+":i:"+i+":maxSum:"+maxSum);
			 i++;
		}
		
		System.out.println("Ans: max sum=> "+maxSum);
		
	}

}
