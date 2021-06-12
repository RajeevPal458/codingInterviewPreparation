package com.bt.arrTree.mix;

import java.util.Arrays;

public class BinaryIndexTree1 {
	
	public static void updateBit(int[] bit,int i,int n,int val){
		int index=i+1;
		while(index<=n){
			
			bit[index]+=val;
			index +=index&(-index);
		}
	}
	public static int[] constructBIT(int[] arr,int n){
		 int[] bit=new int[n+1];
		 
		 for(int i=1;i<=n;i++)
			 bit[i]=0;
		 for(int i=0;i<n;i++)
			 updateBit(bit,i,n,arr[i]);
		 return bit;
	}
	public static int getSum(int[] bit,int rang){
		int sum=0;
		int index=rang+1;
		
		while(index>0){
			sum+=bit[index];
			index -=index&(-index);
		}
		return sum;
	}
	
	public static void main(String[] args) {
		int arr[] = {1, 3, 5, 7, 9, 11};
	    int n = arr.length;
	    int[] bit=constructBIT(arr, n);
	    System.out.println(Arrays.toString(bit));
	    System.out.println();
	    // Print sum of values in array from index 1 to 3
	    System.out.println("Sum of values in given range:"+getSum(bit,3));
	 
	    // Update: set arr[1] = 10 and update corresponding 
	    // segment tree nodes
	    updateBit(bit,4,6,6);
	    System.out.println(Arrays.toString(bit));
	    // Find sum after the value is updated
	    System.out.println("Updated sum of values in given range:"+getSum(bit,3));
	}
}
