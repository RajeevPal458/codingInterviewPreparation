package com.gfg.microsoft;

public class CountSetBitsInAnInteger {

	public static int countOnes(int num){
		
		int count=0;
		while(num!=0){
			count+=num&1;
			num >>=1;
		}
		return count;
	}
	public static int countOnes1(int num){
		
		int count=0;
		while(num!=0){
			num	&=(num-1);
			 count++;
		}
		return count;
	}
	public static void main(String[] args) {
		System.out.println(countOnes(28));
		System.out.println(countOnes(27));
		System.out.println(countOnes(9));
		
		System.out.println();
		
		System.out.println(countOnes1(28));
		System.out.println(countOnes1(27));
		System.out.println(countOnes1(9));
	}
}
