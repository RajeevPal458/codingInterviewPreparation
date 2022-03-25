package com.gfg.microsoft;
//Given a number n, generate bit patterns from 0 to 2^n-1 such that successive patterns differ by one bit.
public class Generate_N_BitGrayCodes {
	
	public static void generateNBitGrayCode(int n){
		
		for(int i=0;i<(1<<n);i++){
			
			for(int j=n-1;j>=0;j--){
				if((i&(1<<j))>=1){
					System.out.print("1");
				}
				else{
					System.out.print("0");
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		generateNBitGrayCode(2);
		generateNBitGrayCode(4);
		
	}
}
