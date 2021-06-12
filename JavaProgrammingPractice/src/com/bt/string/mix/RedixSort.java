package com.bt.string.mix;
import java.util.Arrays;

public class RedixSort {
	public static int max(int arr[]){
		int max=0;
		for(int i=0;i<arr.length;i++)
			if(arr[i]>max)
				max=arr[i];
		return max;
	}
	public static void count(int[] arr,int k,int n){
		int C[]=new int[13],B[]=new int[n];
		Arrays.fill(C,0);
		for(int i=0;i<n;i++)
			C[(arr[i]/k)%10]++;
		System.out.println(Arrays.toString(C));
		for(int i=1;i<C.length;i++)
			C[i]+=C[i-1];
		for(int l=arr.length-1;l>=0;l--){
			//System.out.println("1");
			B[C[(arr[l]/k)%10]-1]=arr[l];
			C[(arr[l]/k)%10]--;
		}
		
		for(int i=0;i<n;i++)
			arr[i]=B[i];
	}
	public static void main(String[] args) {
		int arr[]={334,211,576,123,74,6,6,6,6,6,6,6};
		int k=max(arr);
		for(int exp=1;k/exp>0;exp*=10){
			count(arr,exp,arr.length);
		}
		System.out.println(Arrays.toString(arr));
	}
}
