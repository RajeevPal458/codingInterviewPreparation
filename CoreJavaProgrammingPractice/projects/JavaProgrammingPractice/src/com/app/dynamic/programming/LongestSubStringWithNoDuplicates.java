package com.app.dynamic.programming;

import java.util.LinkedHashMap;
import java.util.Map;

public class LongestSubStringWithNoDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abrexrzx" ;
		char[] arr=str.toCharArray();
		int n = arr.length;
		int maxlen=0;
		int[] count = new int[300];
		int i=0;
		int j=0;
		count[arr[j]]++;
		
		while(j<n-1) {
			
			if(count[arr[j+1]]==0) {
				j++;
				maxlen =Math.max(maxlen, j-i+1);
				count[arr[j]]++;
			}
			else {
				count[arr[i]]--;
				i++;
			}
		}
		
		System.out.println(maxlen);
		
	}

}
