package com.bt.string.mix;

import java.util.Arrays;

public class PrintAllPossibleCombination {

	public static void combinationUtill(int[] arr,int[] data,int start,int end,int index,int r){
		if(index==r){
			for(int i=0;i<r;i++)
				System.out.print(data[i]);
			System.out.println();
			return;
		}
		if(start>=end&&index>=r)
			return ;
		
		if(start<end&&index<r)
			data[index]=arr[start];
		combinationUtill(arr,data,start+1,end,index+1,r);
		
		
		combinationUtill(arr,data,start+1,end,index,r);
	}
	public static void combinationUtill1(int[] arr,int[] data,int start,int end,int index,int r){
		if(index==r){
			for(int i=0;i<data.length;i++)
				System.out.print(data[i]);
			System.out.println();
			return;
		}
		
		for(int j=start;j<=end&&end-j+1 >= r-index;j++){
			data[index]=arr[j];
			combinationUtill1(arr,data,j+1,end,index+1,r);
			
			try{
				while((j+1<=end)&&arr[j] == arr[j+1])
							j++;
					
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	public static void combination(int[] arr,int len ,int r){
		int data[]=new int[r];
		combinationUtill1(arr,data,0,len-1,0,r);
	}
	public static void main(String[] args) {
		int[] arr={1,1,1,4,5};
		for(int i=1;i<arr.length;i++)
		combination(arr,arr.length,i);
	}
}
