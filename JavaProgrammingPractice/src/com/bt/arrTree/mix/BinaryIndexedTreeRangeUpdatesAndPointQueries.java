package com.bt.arrTree.mix;

import java.util.Arrays;

public class BinaryIndexedTreeRangeUpdatesAndPointQueries {

	// Updates such that getElement() gets an increased
	// value when queried from l to r.
	public static void update(int arr[],int n, int l, int r, int val)
	{
	    arr[l] += val;
	    if(r+1<n)
	    	arr[r+1] -= val;
	}
	 
	// Get the element indexed at i
	public static int getElement(int arr[], int i)
	{
	    // To get ith element sum of all the elements
	    // from 0 to i need to be computed
	    int res = 0;
	    for (int j = 0 ; j <= i; j++)
	        res += arr[j];
	 
	    return res;
	}
	 
	// Driver program to test above function
	public static void main(String[] args){
	    int arr[] = {0, 0, 0, 0, 0};
	    int n = arr.length;
	 
	    int l = 2, r = 4, val = 2;
	    update(arr,n, l, r, val);
	    System.out.println(Arrays.toString(arr));
	    //Find the element at Index 4
	    int index = 4;
	    System.out.println("Element at index "+index +" is " +getElement(arr, index));
	    l=0;r=3;val=4;
	    update(arr,n,l,r,val);
	    System.out.println(Arrays.toString(arr));
	    //Find the element at Index 3
	    index = 3;
	    System.out.println("Element at index "+index +" is "+getElement(arr, index) );
	    
	    index = 4;
	    System.out.println("Element at index "+index +" is "+getElement(arr, index) );
	    
	    //O(q*n) where q is number of queries.
	}
}
