package com.gfg.practice_mix;

import java.util.Arrays;

public class CountOfAPArithmeticProgressionSubsequencesInAnArray {
	static int d,count=0, minarr=99999,maxarr=0;
	public static void combinationUtill(int[] arr,int[] data,int start,int end,int index,int r){
		if(index==r){
			boolean flage=true;
			int diff=0;
			for(int i=0;i<r-1;i++){
				d=data[i]-data[i+1];
				if(diff==0) diff=d;
				if(d!=diff){flage=false; break;}
				if(!(d>=(minarr-maxarr)&&d<=(maxarr-minarr)))
				{
					flage=false;
					break;
				}
			}
			if(flage)
			{ 
				System.out.print("  "+Arrays.toString(data));
				System.out.println();
				count++;
				flage=false;
			}
			return;
		}
		for(int i=start;i<=end&&index<r;i++){
			data[index]=arr[i];
			combinationUtill(arr,data,i+1,end,index+1,r);

		}
		
	}
	public static void combination(int[] arr,int len){
		int[] data;
		count=0;
		for(int i=0;i<=len;i++)
		{
			data=new int[i];
			combinationUtill(arr,data,0,len-1,0,i);
		}
	}
	public static void main(String[] args) {
		int[] arr={1,2,3,4,5};
		for(int i=0;i<arr.length;i++){
			minarr=(minarr<arr[i])?minarr:arr[i];
			maxarr=(maxarr>arr[i])?maxarr:arr[i];
		}
		combination(arr,arr.length);
		System.out.println(count);
	}
}
