package com.bt.string.mix;

import java.util.Arrays;

public class CountNumberOfDiffSubStringUsingSuffixArray {
	public static void main(String[] args) {
		String text="ababa";
		int n=text.length();
		
		int[] suffix=LongestCommonPreffixArrayUsingSuffixArray.createSuffixArray(text, n);
		int[] lcp=LongestCommonPreffixArrayUsingSuffixArray.kasaisAlgorithmLcp(text, suffix, n);
		System.out.println(Arrays.toString(suffix));
		System.out.println(Arrays.toString(lcp));
		int result=n-suffix[0];
		
		for(int  i=1;i<n;i++){
			result +=(n-suffix[i]-lcp[i-1]);
		}
		result++;
		System.out.println(result);
	}
}
