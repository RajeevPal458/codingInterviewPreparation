package org.algo.common;

/**
 * Largest Sum Contiguous Subarray
Difficulty Level : Medium
Last Updated : 27 May, 2021
Write an efficient program to find the sum of contiguous subarray within a one-dimensional array of numbers that has the largest sum. 
 * @author rajpal
 *
 */
public class KadaneAlgorithm {

	
	public static void main (String[] args)
    {
        int [] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum contiguous sum is " +
                                       maxSubArraySum(arr));
    }

	/**
	 * if not all elements of array are Negative
	 * @param arr
	 * @return
	 */
	private static int maxSubArraySum(int[] arr) {

		int res_max_sum=0;
		int current_max_sum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			current_max_sum +=arr[i];
			
			if(current_max_sum < 0){
				current_max_sum = 0;
			}else{
				if(current_max_sum > res_max_sum){
					System.out.println("index:"+i);    // this describe the sub array
					res_max_sum = current_max_sum;
				}
			}
		}
		return res_max_sum;
	}
}










