package com.ap.service;

import java.util.Arrays;
import java.util.Comparator;

//https://www.geeksforgeeks.org/kasais-algorithm-for-construction-of-lcp-array-from-suffix-array/
public class LongestCommonPreffixArrayUsingSuffixArray {

	static class Suffix{
		int index;
		String suff;
		Suffix(int index,String suff){
			this.index=index;
			this.suff=suff;
		}
	}
	public static int[] createSuffixArray(String text,int n){
		
		int[] suffix =new int[n];
		
		Suffix[] suffixes=new Suffix[n];
		
		for(int i=0;i<n;i++){
			suffixes[i]=new Suffix(i, text.substring(i));
			System.out.print(text.substring(i)+"  ");
		}
		
		Arrays.sort(suffixes, new Comparator<Suffix>() {

			@Override
			public int compare(Suffix o1, Suffix o2) {
				// TODO Auto-generated method stub
				return (o1.suff).compareTo(o2.suff);
			}
		});
		System.out.println();
		for(int i=0;i<n;i++){
			suffix[i]=suffixes[i].index;
			System.out.print(suffixes[i].suff+"  ");
		}
		System.out.println();
		return suffix;
	}
	
	public static int[] kasaisAlgorithmLcp(String text,int[] suff,int n){
		
		int[] invSuff=new int[n];
		int[] lcp=new int[n];
		for(int i=0;i<n;i++)
			invSuff[suff[i]]=i;
		System.out.println("inverse:"+" "+Arrays.toString(invSuff));
		
		int k=0;
		for(int i=0;i<n;i++){
			
			if(invSuff[i]==n-1){
				k=0;
				continue;
			}
			int j=suff[invSuff[i]+1];
			System.out.print(text.substring(i)+"   "+text.substring(j));
			
			while(i+k<n&&i+j<n&&(text.charAt(i+k)==text.charAt(j+k)))
				k++;
			lcp[invSuff[i]]=k;
			System.out.print("  "+k);
			System.out.println();
			if(k>0)
				k--;
		}
		return lcp;
	}
	//-------------------------------
	//Longest Common Prefix using Word by Word Matching
	// A Utility Function to find the common prefix between
	// strings- str1 and str2
	    static String commonPrefixUtil(String str1, String str2) {
	        String result = "";
	        int n1 = str1.length(), n2 = str2.length();
	 
	        // Compare str1 and str2
	        for (int i = 0, j = 0; i <= n1 - 1 && j <= n2 - 1; i++, j++) {
	            if (str1.charAt(i) != str2.charAt(j)) {
	                break;
	            }
	            result += str1.charAt(i);
	        }
	 
	        return (result);
	    }
	 
	// A Function that returns the longest common prefix
	// from the array of strings
	    static String commonPrefix(String arr[], int n) {
	        String prefix = arr[0];
	 
	        for (int i = 1; i <= n - 1; i++) {
	            prefix = commonPrefixUtil(prefix, arr[i]);
	        }
	 
	        return (prefix);
	    }
	    
	 //---------------------------   
	    
	
	
	public static void main(String[] args) {
		String text="banana";
		int len=text.length();
		int[] suffixArr=createSuffixArray(text, len);
		System.out.println(Arrays.toString(suffixArr));
		
		int[] lcp=kasaisAlgorithmLcp(text, suffixArr, len);
		System.out.println(Arrays.toString(lcp));
	}
}
