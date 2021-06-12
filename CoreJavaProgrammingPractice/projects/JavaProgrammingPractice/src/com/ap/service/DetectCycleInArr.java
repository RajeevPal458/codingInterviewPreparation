package com.ap.service;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleInArr {

	public static void main(String[] args) {
		 int arr[] = {1, 1, 1, 1, 1, 1};
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



