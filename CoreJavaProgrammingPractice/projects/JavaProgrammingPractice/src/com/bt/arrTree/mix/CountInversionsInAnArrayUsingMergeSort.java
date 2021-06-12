package com.bt.arrTree.mix;

import java.util.Arrays;

public class CountInversionsInAnArrayUsingMergeSort {
	static int max=10;
	static int[] temp=new int[max];
	public static int merge(int[] arr,int[] temp,int low1,int up1,int low2,int up2){
		int i=low1,j=low2,k=low1;
		int inv=0;
		while(i<=up1&&j<=up2){
			if(arr[i]<=arr[j]){
				temp[k++]=arr[i++];
				System.out.println("default:"+inv);
			}
			else{
				temp[k++]=arr[j++];   //{1, 20, 6, 4, 5};
				inv+=(low2-i);
				System.out.println("low1:"+low1+" low2:"+low2+" up2: "+up2+" i "+i+"  inv:"+inv);
			}
		}
		while(i<=up1)
			temp[k++]=arr[i++];
		while(j<=up2)
			temp[k++]=arr[j++];
		return inv;
		
	}
	public static void copyArr(int[] arr,int[] temp,int low,int up){
		
		for(int i=low;i<=up;i++)
			arr[i]=temp[i];
	}
	public static int merge_sort(int[] arr,int low,int high){
		int inv=0;
		if(low<high){
			int mid=(low+high)/2;
			System.out.println("1:"+inv);
			inv=merge_sort(arr, low, mid);
			System.out.println("2:"+inv);
			inv+=merge_sort(arr, mid+1, high);
			System.out.println("3:"+inv);
			System.out.println("before :"+Arrays.toString(arr));
			inv+=merge(arr,temp,low,mid,mid+1,high);
			copyArr(arr,temp, low, high);
			System.out.println("after :"+Arrays.toString(arr));
			System.out.println("4:"+inv);
		}
		return inv;
	}
	public static void mergeSort(int[] arr){
		int n=arr.length;
		System.out.println("Inversions:"+merge_sort(arr,0,n-1));
	}
	public static void main(String[] args) {
		int arr[] = {1, 20, 6, 4, 5};
		mergeSort(arr);
		
		System.out.println(Arrays.toString(arr));
		
	}
}
