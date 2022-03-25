package com.bt.string.mix;

import java.util.Arrays;

public class PrintAllPermutationWithRepetetionOfChar{

	public static void findPermutationWithRepetetionOfChar(char[] arr,int len,String data,int r){
		if(r==0){
			System.out.println(data);
			return;
		}
		for(int i=0;i<len;i++){
			 String str=data+arr[i];
			findPermutationWithRepetetionOfChar(arr,len,str,r-1);
			System.out.println(":i:"+i+"-------"+str);
		}
	}
	public static void main(String[] args) {
		char[] arr={'A','B','C'};
		findPermutationWithRepetetionOfChar(arr,arr.length,"",3);
		
	}
}
