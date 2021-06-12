package com.bt.string.mix;

import java.util.Arrays;

public class PrintAllPermutationWithRepetetionOfChar{

	public static void findPermutationWithRepetetionOfChar(char[] arr,int ed,String data,int r){
		if(r==0){
			System.out.println(data);
			return;
		}
		for(int i=0;i<ed;i++){
			findPermutationWithRepetetionOfChar(arr,ed,data+arr[i],r-1);
		}
	}
	public static void main(String[] args) {
		char[] arr={'A','B'};
		findPermutationWithRepetetionOfChar(arr,arr.length,"",2);
		
	}
}
