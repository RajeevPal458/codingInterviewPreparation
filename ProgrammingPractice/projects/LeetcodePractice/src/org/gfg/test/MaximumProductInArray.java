package org.gfg.test;

import java.util.Arrays;
/*
 * [1, 2, 3, -5, -4, -2, 6, 7, 9]
 * 
 */
public class MaximumProductInArray {
	
	public static void main(String[] args) {
		int[] array = {3,1,2,-5,-2,-4,9,6,7};
		int l=4,r=6,n=array.length;
		Arrays.sort(array, 0, l-1);
		Arrays.sort(array, l-1, r);
		Arrays.sort(array, r, n);
		long max1=-999999999;
		long max2=-999999999;
		if(l>r||l<=1&&r==n || l<1 || r<1 || l>n||r>n)
			return;
		if(r>=n) {
			if(l>=2)
				max1 = array[l-2];
			else
				max1=0;
		}else {
			max1 = array[n-1];
		}
		max2 = array[r-1];
		if(max1<0 && max2>0) {
			max2 = array[l-1];
		}
		if(max2<0 && max1>0) {
			max1 = array[0];
		}
		
		
		System.out.println(max1+" "+max2);
		
		
		
		System.out.println(Arrays.toString(array));
	}

	
}