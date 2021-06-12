package com.bt.arrTree.mix;

import java.util.Arrays;

public class BinaryIndexedTreeRangeUpdatesAndPointQueriesBIT {
	
	private static int getSum(int[] bit, int index) {
		
		int sum=0;
		index=index+1;
		while(index>0){
			sum+=bit[index];
			index-=(index&(-index));
		}
		return sum;
	}
	private static void updateBIT(int[] arr, int n, int l, int val) {

		int index=l+1;
		while(index<=n){
			arr[index]+=val;
			index+=index&(-index);
		}
		
	}
	public static void update(int BITree[], int l, int r, int n, int val)
	{
	    // Increase value at 'l' by 'val'
	    updateBIT(BITree, n, l, val);
	 
	    // Decrease value at 'r+1' by 'val'
	    if(r+1<n)
	    	updateBIT(BITree, n, r+1, -val);
	}
	 
	public static int[] createBit(int[] arr,int n){
		
		int[] bit=new int[n+1];
		Arrays.fill(bit,0);
		
		for (int i=0; i<n; i++)
	        updateBIT(bit, n, i, arr[i]);
		return bit;
	}
	public static void main(String[] args) {
		int arr[] = {0, 0, 0, 0, 0};
	    int n = arr.length;
	    int[] bit;
	    bit=createBit(arr, n);
	    int l = 2, r = 4, val = 2;
	    update(arr,n, l, r, val);
	    System.out.println(Arrays.toString(arr));
	    //Find the element at Index 4
	    int index = 4;
	    System.out.println("Element at index "+index +" is " +getSum(arr, index));
	    l=0;r=3;val=4;
	    update(arr,n,l,r,val);
	    System.out.println(Arrays.toString(arr));
	    //Find the element at Index 3
	    index = 3;
	    System.out.println("Element at index "+index +" is "+getSum(arr, index) );
	    
	    index = 4;
	    System.out.println("Element at index "+index +" is "+getSum(arr, index) );
	    
	}

}
