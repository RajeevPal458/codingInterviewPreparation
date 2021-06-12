package com.bt.arrTree.mix;
import java.util.Arrays;

public class RangeMinimumQueryST {
	
	public static int RMQUtil(int[] st,int ss,int se,int qs ,int qe,int index){
		if (qs <= ss && qe >= se)
	        return st[index];
	 
	    // If segment of this node is outside the given range
	    if (se < qs || ss > qe)
	        return 9999;
	 
	    // If a part of this segment overlaps with the given range
	    int mid = ss+(se-ss)/2;
	    return min(RMQUtil(st, ss, mid, qs, qe, 2*index+1),
	                  RMQUtil(st, mid+1, se, qs, qe, 2*index+2));
	}
	public static int getMinInRangeGiven(int[] st,int n,int qs ,int qe){
		if (qs < 0 || qe > n-1 || qs > qe)
	    {
	        System.out.println("Invalid Input");
	        return -1;
	    }
		return RMQUtil(st,0,n-1,qs ,qe,0);
	}
	public static int min(int f,int s){
		return (f<s)?f:s;
	}
	public static int constructSTUtil(int[] arr,int ss,int se,int[] st,int si){
		if(ss==se){
			st[si]=arr[ss];
			return arr[ss];
		}
		int mid =ss+(se-ss)/2;
		st[si]=min(constructSTUtil(arr,ss,mid,st,2*si+1), constructSTUtil(arr,mid+1,se,st,2*si+2));
		return st[si];
	}
	
	public static int[] constructST(int[] arr,int n){
		System.out.println("1");
		int leafNode=n+1;
		int internal=n;
		int total=2*n+1;
		int[] st=new int[total+4];
		constructSTUtil(arr,0,n-1,st,0);
		return st;
	}
	
	public static void main(String[] args) {
		int arr[] = {1, 3, 5, 7, 9, 11,13,15,17,18};
	    int n = arr.length;
	 
	    // Build segment tree from given array
	    int[] st = constructST(arr, n);
	    System.out.println("2");
	    System.out.println(Arrays.toString(st));
	    System.out.println();
	    // Print Min value in array from index 1 to 3
	    System.out.println("Min value in given range:"+getMinInRangeGiven(st, n, 1, 3));
	}
}
