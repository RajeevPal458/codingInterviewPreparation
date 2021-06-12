package com.bt.string.mix;

import java.util.Arrays;

public class TwosComplementOfBinaryString {

	public static String onsComplement(String str,int n){
		char[] arr=str.toCharArray();
		for(int i=0;i<n;i++){
			if(arr[i]=='1')
				arr[i]='0';
			else
				arr[i]='1';
		}
		
		return new String(arr);
	}
	public static String twosComplement(String str,int n){
		
		String ones=onsComplement(str, n);
		char[] arr=ones.toCharArray();
		int cary=0;
		if(arr[n-1]=='1'){
			arr[n-1]='0';
			cary=1;
		}
		else{
			arr[n-1]='1';
		}
		for(int i=n-2;i<0;i++){
			
			if(cary==1){
				if(arr[i]=='1'){
					arr[n-1]='0';
					cary=1;
				}
				else{
					arr[n-1]='1';
				}
			}
		}
		return new String(arr);
	} 
	public static void main(String[] args) {
		
		String str="101110100011101";
		System.out.println(twosComplement(str,str.length()));
	}
}
