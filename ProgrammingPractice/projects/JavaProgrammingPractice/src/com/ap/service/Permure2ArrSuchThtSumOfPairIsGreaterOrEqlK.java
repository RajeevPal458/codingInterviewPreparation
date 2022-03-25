package com.ap.service;

public class Permure2ArrSuchThtSumOfPairIsGreaterOrEqlK {
	
	public static boolean permute1(int B[],int A[],int n,int m,int num){
		int knt=0,B1[]=new int[n];
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				
				if(B[i]+A[j]>=num){
					B1[i]=A[j];
					A[j]=-1;
					knt++;
					break;
				}
			}
		}
		for(int i=0;i<n;i++)
			System.out.print(B1[i]+" ");
		
		return (knt==n)?true:false;
	}
	public static void main(String[] args) {
		
		int A[]={1,2,2,1};
		int B[]={3,3,3,4};
		int m=A.length;
		int n=B.length;
		int num=10;
		System.out.println(""+permute1(B,A,m,n,num));
		
		
	}
}
