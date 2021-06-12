package com.gfg.matrix;

import java.util.Arrays;

public class FormCoilsInAMatrix {
	
	public static void printMatInCoilsForm(int n){
		
		int m=8*n*n;
		int[] coil1=new int[m];
		int[] coil2=new int[m];
		int curr,index=0,flage=1,step=2;
		
		curr=8*n*n+2*n;
		coil1[index++]=curr;
		
		while(index<m){
			
			for(int i=1;i<=step;i++){
				
				curr=coil1[index++]=curr-4*n*flage;
				if(index>=m) break;
			}
			if(index>=m) break;
			
			for(int j=1;j<=step;j++){
				curr=coil1[index++]=curr+flage;
				if(index>=m) break;
			}
			flage=(-1)*flage;
			step=step+2;
			
		}
		
		for(int i=0;i<m;i++){
			coil2[i]=16*n*n+1-coil1[i];
		}
		
		System.out.println(Arrays.toString(coil1));
		System.out.println(Arrays.toString(coil2));
	}
	
	public static void main(String[] args) {
		
		/*
		 * Given a positive integer n that represents dimensions of a 4n x 4n matrix
		 *  with values from 1 to n filled from left to right 
		 * and top to bottom. Form two coils from matrix and print the coils
		 * */
		
		int n=2;
		int dimension=4*n * 4*n;
		printMatInCoilsForm(n);
		
	}
}
