package com.ap.service;

import java.util.Arrays;

public class MaxAccuredIntInGivenRang {

	public static int[] maxAccourInt(int a[],int b[],int m,int n){
		int mx=(m>n)?m:n;
		int max[]=new int[mx];
		int l1=a[0],r1=a[m-1];
		int l2=b[0],r2=b[n-1];
		int start,end;
		if(l1>l2)
			start=l1;  //...............
		else
			start=l2;
		if(r1<r2)
			end=r1;  //.................
		else
			end=r2;
		if(start==l1&&end==r1)
			return a;
		else if(start==l2&&end==r2)
			return b;
		else if(start==l1&&end==r2)
		{
			for(int i=0;a[i]<=r2;i++){
				max[i]=a[i];
			}
		}
		else if(start==l2&&end==r1)
		{
			for(int i=0;b[i]<=r1;i++){
				max[i]=b[i];
			}
		}
		
		return max;
	}
	public static void main(String[] args) {
		
		int a[]={9,10,11,12,13,14,15,16,17,18,19,20};
		int b[]={4,5,6,7,8,9,10,11,12,13,14,15};
		int m=a.length;
		int n=b.length;
		System.out.println(Arrays.toString(maxAccourInt(a,b,m,n)));
	}
}
