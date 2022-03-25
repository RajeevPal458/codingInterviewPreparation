package org.algo.strarr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllUniqueCombinationsWhoseSumEqualsToK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2, 2, 2};
		int k = 4 ;
		int len = arr.length;
		combinations(arr,len ,k);
	}

	private static void combinations1(int[] arr, int len, int sum) {
		// TODO Auto-generated method stub
		int subsetSum=0;
		List<Integer> list = null;
		for(int i=0;i<len;i++) {
			
			for(int j=i;j<len;j++) {
				list = new ArrayList<Integer>();
				subsetSum=0;
				for(int k=i;k<=j;k++) {
					subsetSum +=arr[k];
					list.add(arr[k]);
				}
				if(subsetSum==sum) {
					System.out.println(list);
				}
			}
		}
	}

	private static void combinations(int[] arr, int n,int sum) {
		// TODO Auto-generated method stub
		/*
		 * for(int r=1;r<=n;r++) { int[] data = new int[r];
		 * printAllCombinationsUtill(arr, 0, n, r, data, 0,sum); }
		 */
		int[] data = new int[n];
		findCombinationUtil(arr, data, 0,0, 0, sum, n);
		
	}
	public static void printData(int[] arr,int n){
		System.out.print("( ");
		for(int i=0;i<n;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.print(")");
		System.out.print(" ");
	}
	public static void findCombinationUtil(int[] arr,int[] data,int start,int index,int sum,int t_sum,int n){
		if(sum==t_sum){
			printData(data,index);
		}
		for(int i=start;i<n&&index<n;i++){
			data[index]=arr[i];
			findCombinationUtil(arr,data,i,index+1,sum+arr[i],t_sum,n);
			while(i+1<n && arr[i]==arr[i+1]) {
				i++;
			}
		}
	}
	
	private static void printAllCombinationsUtill(int[] arr,int start ,int n, int r,int[] data ,
			int index,int sum) {
		// TODO Auto-generated method stub
		if(index==r) {
			int subsetsum=0;
			for(int i=0;i<r;i++) {
				subsetsum +=data[i];
			}
			if(subsetsum==sum)
				System.out.println(Arrays.toString(data));
			return;
		}
		
		for(int i=start;i<n&&index<r;i++) {
			data[index] = arr[i];
			printAllCombinationsUtill(arr, i+1, n, r, data, index+1,sum);
			while((i+1<n)&&arr[i] == arr[i+1])
				i++;
		
		}
	}
	
}
