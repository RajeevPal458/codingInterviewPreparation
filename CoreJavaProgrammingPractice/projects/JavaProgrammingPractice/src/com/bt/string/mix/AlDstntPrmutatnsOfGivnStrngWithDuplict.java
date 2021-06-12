package com.bt.string.mix;

import java.util.Arrays;

public class AlDstntPrmutatnsOfGivnStrngWithDuplict {

	public static int findCeil(char[] arr,char first,int low,int len){
		int ceilInd=low;
		for(int i=low+1;i<len;i++){
			if(arr[i]>first&&arr[i]<arr[ceilInd])
				ceilInd=i;
		}
		return ceilInd;
	}
	public static int findLargestCharSmallFromNext(char[] arr,int len){
		int i;
		for(i=len-2;i>=0;i--){
			if(arr[i]<arr[i+1])
				break;
		}
		return i;
	}
	private static void swap(char[] arr,int c, int d) {
		char temp=arr[c];
		arr[c]=arr[d];
		arr[d]=temp;
		
	}
	public static void distPermutation(char[] arr,int n){
		Arrays.sort(arr);
		int first,second;
		boolean isFinished=false;
		while(!isFinished){
			
			System.out.println(Arrays.toString(arr));
			first=findLargestCharSmallFromNext(arr,n);
			if(first==-1)
				break;
			second=findCeil(arr, arr[first],first+1,n);
			
			swap(arr,first,second);
			Arrays.sort(arr,first+1,n);
		}
	}
	public static void main(String[] args) {
		char[] arr={'a','b','a'};
		distPermutation(arr,arr.length);
	}
}
