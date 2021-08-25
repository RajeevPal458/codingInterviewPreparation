package com.bt.string.mix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckIfTwoStringsArekAnagrams {

	public static boolean checkKAnagram(String str1,String str2,int k){

	    int flag = 0;
	     
	    List<Character> list = new ArrayList<>();
	     
	    // First Condition: If both the
	    // strings have different length ,
	    // then they cannot form anagram
	    if (str1.length() != str2.length())
	        System.exit(0);
	     
	    // Converting str1 to Character Array arr1
	    char arr1[] = str1.toCharArray();
	     
	    // Converting str2 to Character Array arr2
	    char arr2[] = str2.toCharArray();
	     
	    // Sort arr1 in increasing order
	    Arrays.sort(arr1);
	     
	    // Sort arr2 in increasing order
	    Arrays.sort(arr2);
	     
	    // Iterate till str1.length()
	    for (int i = 0; i < str1.length(); i++)
	    {
	         
	        // Condition if arr1[i] is
	        // not equal to arr2[i]
	        // then add it to list
	        if (arr1[i] != arr2[i])
	        {
	            list.add(arr2[i]);
	        }
	    }
	     
	    // Condition to check if
	    // strings for K-anagram or not
	    if (list.size() <= k)
	        flag = 1;
	 
	    if (flag == 1)
	        return true;
	    else
	        return false;
	}
	
	static final int MAX_CHAR = 26;
    
    // Function to check if str1 and str2 are k-anagram
    // or not
    static boolean areKAnagrams(String str1, String str2,
                                                  int k)
    {
        // If both strings are not of equal
        // length then return false
        int n = str1.length();
        if (str2.length() != n)
            return false;
      
        int[] hash_str1 = new int[MAX_CHAR];
      
        // Store the occurrence of all characters
        // in a hash_array
        for (int i = 0; i < n ; i++)
            hash_str1[str1.charAt(i)-'a']++;
      
        // Store the occurrence of all characters
        // in a hash_array
        int count = 0;
        for (int i = 0; i < n ; i++)
        {
            if (hash_str1[str2.charAt(i)-'a'] > 0)
                hash_str1[str2.charAt(i)-'a']--;
            else
                count++;
      
            if (count > k)
                return false;
        }
      
        // Return true if count is less than or
        // equal to k
        return true;
    }
    
	public static void main(String[] args) {
		String str1="geeks";
		String str2="eggkf";
		int k=2;
		System.out.println("str1:"+str1+" and str2:"+str2+"  are k "+k+" anagram :"+checkKAnagram(str1, str2,k));
	}

}
