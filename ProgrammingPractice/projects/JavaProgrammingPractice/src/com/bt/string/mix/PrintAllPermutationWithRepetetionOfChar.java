package com.bt.string.mix;

public class PrintAllPermutationWithRepetetionOfChar{

	public static void findPermutationWithRepetetionOfChar(char[] arr,int len,String data){
		if(data.length()==len){
			System.out.println(data);
			return;
		}
		for(int i=0;i<len;i++){
			 String str=data+arr[i];
			findPermutationWithRepetetionOfChar(arr,len,str);
			//System.out.println(":i:"+i+"-------"+str);
		}
	}
	
	public static void findPermutation(char[] arr,int start,int len){
		if(start==len){
			System.out.println(arr);
			return;
		}
		for(int i=start;i<len;i++){
			swap(arr,i,start);
			findPermutation(arr,start+1,len);
			swap(arr,i,start);
		}
	}
	
	private static void swap(char[] arr, int i, int start) {
		char ch = arr[i];
		arr[i]=arr[start];
		arr[start] = ch;
	}

	public static void findPermutation(String str,String data){
		if(str.length()==0){
			System.out.println(data);
			return;
		}
		for(int i=0;i<str.length();i++){
			 char ch = str.charAt(i);
			 String st = str.substring(0,i)+str.substring(i+1);
			 findPermutation(st,data+ch);
			//System.out.println(":i:"+i+"-------"+str);
		}
	}
	
	public static void main(String[] args) {
		char[] arr={'A','B','C'};
		findPermutationWithRepetetionOfChar(arr,arr.length,"");
		System.out.println("==========");
		findPermutation("ABC","");
		
		System.out.println("==========");
		findPermutation("ABC".toCharArray(),0,3);
	}
}
