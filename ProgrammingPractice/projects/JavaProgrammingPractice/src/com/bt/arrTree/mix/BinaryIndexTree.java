package com.bt.arrTree.mix;

import java.util.Arrays;

public class BinaryIndexTree {
	static int size;
	static int bit[]=new int[6];
	
	private static int getSum(int index) {
		int sum=0;
		index+=1;
		while(index!=0){
			sum+=bit[index];
			index-=index &(-index);
		}
		return sum;
	}
	private static void updateBIT(int index, int val, int n) {
		index+=1;
		while(index<=n){
			bit[index]+=val;
			index+=index &(-index);
		}
	}
	private static void constructBIT(int[] arr, int n) {
		for(int i=0;i<n;i++)
		{
			updateBIT(i,arr[i],n-1);
		}
	}

	public static void main(String[] args) {
		
		 int arr[] = {1, 3, 5, 7, 9, 11};
		    int n = arr.length;
		    Arrays.fill(bit,0);
		    // Build segment tree from given array
		    constructBIT(arr, n);
		    System.out.println(Arrays.toString(bit));
		    System.out.println();
		    // Print sum of values in array from index 1 to 3
		    System.out.println("Sum of values in given range:"+getSum(3));
		 
		    // Update: set arr[1] = 10 and update corresponding 
		    // segment tree nodes
		    updateBIT(0,6,6);
		    System.out.println(Arrays.toString(bit));
		    // Find sum after the value is updated
		    System.out.println("Updated sum of values in given range:"+getSum(4));
	}

}
