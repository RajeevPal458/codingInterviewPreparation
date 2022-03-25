package org.algo.strarr;

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
	//https://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
	 public static int longestUniqueSubsttr(String str) {
	        String test = "";
	 
	        // Result
	        int maxLength = -1;
	 
	        // Return zero if string is empty
	        if (str.isEmpty()) {
	            return 0;
	        }
	        // Return one if string length is one
	        else if (str.length() == 1) {
	            return 1;
	        }
	        for (char c : str.toCharArray()) {
	            String current = String.valueOf(c);
	            // If string already contains the character
	            // Then substring after repeating character
	            if (test.contains(current)) {
	                test = test.substring(test.indexOf(current)
	                                      + 1);
	            }
	            test = test + current;
	            maxLength = Math.max(test.length(), maxLength);
	        }
	 
	        return maxLength;
	    }

}
