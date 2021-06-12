package com.bt.string.mix;

public class FindFirstStringIsSubSequenceOfSecond {

	public static boolean check(String s1,String s2){
		boolean flage=true;
		char[] arr=s1.toCharArray();
		
		for(char ch:arr){
			
			int ind=s2.indexOf(ch);
			if(ind<0){
				flage=false;
			}
		}
		
		return flage;
	}
	public static void main(String[] args) {
		String s1="AXY";
		String s2="ADXCPY";
		System.out.println("Str1 is subString of str2:"+check(s1, s2));
		
	}
}
