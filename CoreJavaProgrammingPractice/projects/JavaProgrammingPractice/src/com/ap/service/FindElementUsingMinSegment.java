package com.ap.service;

import java.util.Arrays;

public class FindElementUsingMinSegment {

	static int seg[]={6,2,5,5,4,5,6,3,7,6};
	public static int findminseg(int num){
		int sum=0;
		int rem;
		while(num>0){
				rem=num%10;
				sum +=seg[rem];
				num=num/10;
			}
		return sum;
	}
	public static int findElement(int arr[],int n){
		int elmWithMinSeg=99999999,seg;
		int num,sumseg=0,trackIndex=-1;
		int rem=0;
		System.out.print("(ArrElem,minSeg):");
		for(int i=0;i<n;i++){
			num=arr[i];
			sumseg=findminseg(num);
			if(sumseg<elmWithMinSeg)
			{
				elmWithMinSeg=sumseg;
				trackIndex=i;
			}
			System.out.print("  ("+arr[i]+","+sumseg+")  ");
		}
		System.out.println();
		return arr[trackIndex];
	}
	public static void main(String[] args) {
		int arr[]={489, 206, 745, 123, 756};
		int len=arr.length;
		System.out.println();
		System.out.print("(ArrElem With Min Segment:"+findElement(arr,len));
		
	}
}
