package com.gfg.problems;

import java.util.Scanner;

public class FindAllPossibleSubsetsIteration {

	public static void printSubset(int[] arr,int n){
		
		for(int i=0;i<(1<<n);i++){
			System.out.print("[");
			for(int j=0;j<n;j++){
				if((i&(1<<j))>0)
					System.out.print(arr[j]+" ");
				
			}
			System.out.print("]");
			System.out.println();
		}
	}
	public static void main(String[] args) {
		
		int[] arr={1,2,2};
		int n=arr.length;
		printSubset(arr, n);
		
	}
}
