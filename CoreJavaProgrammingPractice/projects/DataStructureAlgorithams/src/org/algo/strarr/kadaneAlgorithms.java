package org.algo.strarr;

public class kadaneAlgorithms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		
		int max = maxSumSubArray2(arr , arr.length);
		System.out.println();
		System.out.println(max);
	}

	private static int maxSumSubArray(int[] arr, int length) {
		// TODO Auto-generated method stub
		int max = 0;
		int max_so_far=0;
		//{-2, 1, -3, 4, -1, 2, 1, -5, 4};
		for(int i=0;i<arr.length;i++) {
			max_so_far +=arr[i];
			
			if(max_so_far>max) {
				max = max_so_far;
				System.out.println(i);
			}
			if(max_so_far<0)
				max_so_far = 0;
		}
		return max;
	}
	private static int maxSumSubArray2(int[] arr, int length) {
		// TODO Auto-generated method stub
		int max = 0;
		int max_so_far=0;
		//{-2, 1, -3, 4, -1, 2, 1, -5, 4};
		for(int i=0;i<arr.length;i++) {
			max_so_far +=arr[i];
			max_so_far = Math.max(max_so_far,arr[i]);
			
			max = Math.max(max_so_far, max);
			//max_so_far = Math.max(max_so_far, 0);
		}
		return max;
	}
	
	 static void maxSubArraySum(int a[], int size)
	    {
	        int max_so_far = Integer.MIN_VALUE,
	        max_ending_here = 0,start = 0,
	        end = 0, s = 0;
	 
	        for (int i = 0; i < size; i++)
	        {
	            max_ending_here += a[i];
	 
	            if (max_so_far < max_ending_here)
	            {
	                max_so_far = max_ending_here;
	                start = s;
	                end = i;
	            }
	 
	            if (max_ending_here < 0)
	            {
	                max_ending_here = 0;
	                s = i + 1;
	            }
	        }
	        System.out.println("Maximum contiguous sum is "
	                           + max_so_far);
	        System.out.println("Starting index " + start);
	        System.out.println("Ending index " + end);
	    }
	 
}
