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
	
	static int MAX = 50;
	 
    // Return the maximum occurred element in all ranges.
    static int maximumOccurredElement1(int[] L, int[] R, int n)
    {
        // Initialising all element of array to 0.
        int[] arr = new int[MAX];
 
        System.out.println(Arrays.toString(L));
        System.out.println(Arrays.toString(R));
        System.out.println("-------");
        // Adding +1 at Li index and
        // subtracting 1 at Ri index.
        int maxi=-1;
        for (int i = 0; i < n; i++) {
            arr[L[i]] += 1;
            arr[R[i] + 1] -= 1;
            if(R[i]>maxi){
            	maxi=R[i];
            }
            System.out.println(Arrays.toString(arr));
        }
 
        System.out.println("----");
        // Finding prefix sum and index
        // having maximum prefix sum.
        int msum = arr[0];
        int ind = 0;
        for (int i = 1; i < maxi+1; i++) {
            arr[i] += arr[i - 1];
            System.out.println(Arrays.toString(arr));
            if (msum < arr[i]) {
                msum = arr[i];
                ind = i;
            }
        }
 
        return ind;
    }
	
	private static void maximumOccurredElement(int[] l, int[] r, int n) {
		// TODO Auto-generated method stub
		int maxr = 0;
		for(int i=0;i<r.length;i++) {
			if(maxr < r[i]) maxr = r[i];
		}
		int[] temp = new int[maxr+1];
		
		int i=0;
		while (i<n) {
			for(int j=l[i] ; j<=r[i];j++) {
				//System.out.println(":i:"+i+":j:"+j);
				temp[j]++;
			}
			i++;
			System.out.println(Arrays.toString(temp));
		}
		
		int maxvalue =-1;
		
		for(i=0;i<temp.length;i++) {
			if(temp[i]>maxvalue) maxvalue = temp[i];
		}
		
		System.out.println("max occured elements - ");
		for(i=0;i<temp.length;i++) {
			if(temp[i]==maxvalue) {
				System.out.print((i)+" ");
				break;
			}
		}
		
		
		
	}
	
	public static void main(String[] args) {
		/*
		int a[]={9,10,11,12,13,14,15,16,17,18,19,20};
		int b[]={4,5,6,7,8,9,10,11,12,13,14,15};
		int m=a.length;
		int n=b.length;
		System.out.println(Arrays.toString(maxAccourInt(a,b,m,n)));
		
		*/
		
		 int[] L = { 1, 4, 3,1 };
	     int[] R = { 15, 8,5,4 };
	     int n = L.length;
	     maximumOccurredElement1(L, R, n);
	}
}
