package com.ap.service;

import java.util.Arrays;

public class FindMaxProduct2Arr {

	public static int maxProduct(int A[],int B[],int m,int n){
		int maxProd=1,maxprodsum=0,prod=1;
		
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				prod=B[i]*A[j];
				if(maxProd<prod)
				{
					maxProd=prod;
					break;
				}
			}
			maxprodsum +=maxProd;
		}
		return maxprodsum;
	}	
	public static void main(String[] args) {
		int A[] = { 2, 3 , 1, 7, 8 } ;
	    int B[] = { 3, 6, 7 } ;
	    int m = A.length;
	    int n = B.length;
	    System.out.println(maxProduct(A, B,m, n));
	}
}
