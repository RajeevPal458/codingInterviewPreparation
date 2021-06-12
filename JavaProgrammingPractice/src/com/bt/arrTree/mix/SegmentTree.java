package com.bt.arrTree.mix;
import java.util.Arrays;

public class SegmentTree {
	
	public static void updateValueUtill(int[] st,int ss,int se,int i,int diff,int si){
		if(i<ss||i>se)
			return;
		st[si]=st[si]+diff;
		if(se!=ss){
			int mid=ss+(se-ss)/2;
			updateValueUtill(st,ss,mid,i,diff,2*si+1);
			updateValueUtill(st,mid+1,se,i,diff,2*si+2);
		}
	}
	public static void updateValue(int[] arr,int[] st,int n,int i,int newval){
		if (i < 0 || i > n-1)
	    {
	        System.out.println("Invalid Input");
	        return;
	    }
		int diff=newval-arr[i];
		arr[i]=newval;
		updateValueUtill(st,0,n-1,i,diff,0);
	}
	public static int getSumUtil(int[] st,int ss,int se,int from,int to,int si){
		if(ss>=from&&se<=to)
		{ 
			System.out.print (" SS "+ss+" SE "+se+ " si: "+si+" "+st[si]+" , ");
			return st[si];
		}
		if(from>se||to<ss)
			return 0;
		int mid=ss+(se-ss)/2;
		System.out.print (" si: "+si+" ");
		
		return getSumUtil(st,ss,mid,from,to,2*si+1)+
				getSumUtil(st,mid+1,se,from,to,2*si+2);
	}
	public static int getSum(int[] st,int n,int from,int to){
		if (from < 0 || to > n-1 || from > to)
	    {
	        System.out.print("Invalid Input");
	        return -1;
	    }
		return getSumUtil(st,0,n-1,from,to,0);
	}
	public static int constructSTUtil(int[] arr,int ss,int se,int[] st,int si){
		if(ss==se){
			st[si]=arr[ss];
			return arr[ss];
		}
		int mid =ss+(se-ss)/2;
		st[si]=constructSTUtil(arr,ss,mid,st,2*si+1)+constructSTUtil(arr,mid+1,se,st,2*si+2);
		return st[si];
	}
	public static int[] constructST(int[] arr,int n){
		int leafNode=n+1;
		int internal=n;
		int total=2*n+1;
		int[] st=new int[total];
		constructSTUtil(arr,0,n-1,st,0);
		return st;
	}
	public static void main(String[] args) {
		
		 int arr[] = {1, 3, 5, 7, 9, 11};
		    int n = arr.length;
		 
		    // Build segment tree from given array
		    int[] st = constructST(arr, n);
		    System.out.println(Arrays.toString(st));
		    System.out.println();
		    // Print sum of values in array from index 1 to 3
		    System.out.println("Sum of values in given range:"+getSum(st, n, 1, 3));
		 
		    // Update: set arr[1] = 10 and update corresponding 
		    // segment tree nodes
		    updateValue(arr, st, n, 1, 10);
		 
		    // Find sum after the value is updated
		    System.out.println("Updated sum of values in given range:"+getSum(st, n, 1, 3));
	}
}
