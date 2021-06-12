package com.bt.string.mix;

import java.util.Arrays;

public class PermutationUsingIteration {

	public static int fact(int num){return (num==1)?1:num*fact(num-1);}
	public static void permute(char[] arr,int len){
		int ft=fact(len),m=0,j=1;
		for(int i=0;i<ft;){
			char[] str=arr;
			int k=0;
			while(k!=ft/len){
				
				while(j!=len-1){
					
					
					System.out.println(Arrays.toString(str));
					swap(str,j,j+1);
					k++;
					j++;
					i++;
				}
				j=1;
			}
			m++;
			if(m==len)
				break;
			swap(arr,0,m);
		}
	}
	
	private static void swap(char[] arr,int c, int d) {
		char temp=arr[c];
		arr[c]=arr[d];
		arr[d]=temp;
		
	}
	
	public static void main(String[] args) {
		char arr[]={'a','c','a'};
		permute(arr,arr.length);
	}
}
