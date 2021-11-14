package org.algo.strarr;

public class AllSubArraysOfGivenArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4};
		
		//subsetArray(arr , arr.length);
		printSubArrays(arr, 0, 0);
	}
	
	//Time Complexity: O(n^3)   
	private static void subsetArray(int[] arr, int len) {
		// TODO Auto-generated method stub
		
		 for( int i=0; i<len; i++ ){
		        for( int j=i; j<len; j++ ){   // Now A[i..j] is the subarray
		            for( int k=i; k<=j; k++ )
		               System.out.print(arr[k]+" ");
		            System.out.println();
		        }
		 }
	}
	
	//Time Complexity: O(n^2)   
	static void printSubArrays(int []arr, int start, int end)
	{    
	    // Stop if we have reached the end of the array    
	    if (end == arr.length)
	        return;
	     
	    // Increment the end point and start from 0
	    else if (start > end)
	        printSubArrays(arr, 0, end + 1);
	         
	    // Print the subarray and increment the starting point
	    else
	    {
	        System.out.print("[");
	        for (int i = start; i < end; i++){
	            System.out.print(arr[i]+", ");
	        }
	         
	        System.out.println(arr[end]+"]");
	        printSubArrays(arr, start + 1, end);
	    }
	     
	    return;
	}

}
