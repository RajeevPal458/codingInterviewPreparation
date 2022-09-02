package com.app.dynamic.programming;

import java.util.Arrays;

/**
 * Longest Common Subsequence | DP-4
 * 
 * @author rajeevkumar.pal
 *
 */
public class LonggestCommonSubSequenceStringFromTwoGivenString {

	public static void main(String[] args) {
		String str1="adqhecf";
		String str2 ="gdahexfc";
		int len1 = str1.length();
		int len2 = str2.length();
		
		int lcss = lcsubString(str1.toCharArray() ,str2.toCharArray(),len1,len2);
		System.out.println("lcss::"+lcss);
	}

	private static int lcsubString(char[] str1, char[] str2, int len1, int len2) {
		// TODO Auto-generated method stub
		int[][] arr = new int[len1+1][len2+1];
		int count=0;
		int max=0;
		for(int i=0;i<=len1;i++)
			arr[i][0]=0;
		for(int i=0;i<=len1;i++)
			arr[0][1]=0;
		for(int i=1;i<=len1;i++) {
			for(int j=1;j<=len2;j++) {
				if(str1[i-1]==str2[j-1]) {
					count = arr[i-1][j-1]+1;
				}else {
					count = Math.max(arr[i-1][j], arr[i][j-1]);
				}
				arr[i][j]=count;
				if(count>max)
					max=count;
			}
		}
		for(int i=0;i<len1+1;i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		return max;
	}
}
