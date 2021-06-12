package com.bt.string.mix;

import java.util.Arrays;
import java.util.Comparator;

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
	public static void main(String[] args) {
		String text="banana";
		int len=text.length();
		int[] suffixArr=createSuffixArray(text, len);
		System.out.println(Arrays.toString(suffixArr));
		
		int[] lcp=kasaisAlgorithmLcp(text, suffixArr, len);
		System.out.println(Arrays.toString(lcp));
	}
}
