package com.ap.service;

import java.util.ArrayList;
import java.util.List;

/***
 * Check loop in array according to given constraints
 * Given an array arr[0..n-1] of positive and negative numbers we need to find if there is a cycle in array with given rules of movements.
 *  If a number at an i index is positive, then move arr[i]%n forward steps, i.e., next index to visit is (i + arr[i])%n. Conversely, 
 *  if it’s negative, move backward arr[i]%n steps i.e., next index to visit is (i – arr[i])%n. Here n is size of array. If value of arr[i]%n is zero, then 
 *  it means no move from index i.
 * @author rajeevkumar.pal
 *
 */
public class DetectCycleInArr {

	public static void main(String[] args) {
		 int arr[] = {1, 2};
		    int n = arr.length;
		    if (isCycle(arr, n))
		        System.out.println("YES");
		    else
		    	System.out.println("NO");
	}

	private static boolean isCycle(int[] arr, int n) {
		
		List<Integer> list=new ArrayList<Integer>();
		int nextind=0;
		
		for(int i=0;i<n;i++){
			list.add(new Integer(-1));
		}
		list.add(new Integer(nextind));
		for(int i=0;i<n;i=nextind){
			nextind=(i+arr[i]+n)%n;
			if(list.contains(new Integer(nextind)))
			{
				return true;
			}
			list.add(new Integer(nextind));
		}
		return false;
	}
}



