package com.bt.string.mix;

import java.util.Arrays;

public class PrintAllPermutationOfStringInLexicographicOrder{
	public static int findCeilIndex(char[] arr,int first,int l,int n){
		int ceilindex=l;
		for(int i=l+1;i<=n;i++){
			if(arr[i]>arr[first]&&arr[i]<arr[ceilindex])
				ceilindex=i;
		}
		return ceilindex;
	}
	public static void findpermutation(char[] arr,int n ,int k){
		Arrays.sort(arr);
		boolean isFinished=false;
		while(!isFinished){
			int i;
			System.out.println(Arrays.toString(arr));
			// find find fist largest char which is smaller then its next char from the last
			for(i=n-2;i>=0;i--)
				if(arr[i]<arr[i+1])
					break;
			if(i==-1)
				break;
			else{
				char first=arr[i];
				int second=findCeilIndex(arr,i,i+1,n-1);
				swap(arr,i,second);
				Arrays.sort(arr,i+1,n);
			}
		}
	}
	private static void swap(char[] arr, int i, int j) {
		char temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	public static void main(String[] args) {
		String str="aaa";
		int n=str.length();
		findpermutation(str.toCharArray(),n,3);
	}
}
