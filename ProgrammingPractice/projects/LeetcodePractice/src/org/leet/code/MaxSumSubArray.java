package org.leet.code;

// kadanes Algorithms Largest Sum Contiguous Subarray
public class MaxSumSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
		
		maxSumSubArray(arr,arr.length);
	}

	private static void maxSumSubArray(int[] arr, int length) {
		// TODO Auto-generated method stub
		int sum =0;
		int maxSum =Integer.MIN_VALUE;
		int start=0;
		int stInd =0;
		int end=0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if(sum<0) {
				sum =0;
				stInd=i;
			}
			
			if(maxSum < sum) {
				maxSum = sum;
				
				start =stInd+1;
				end=i;
			}
		}
		
		System.out.println("Ans :maxSum=>"+maxSum +":subArray:("+start+","+end+")");
		
	}

}
