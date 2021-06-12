package com.bt.stringarr.mix;

import java.util.Arrays;

public class KnuthMirrorPatternSearchinglgorithm {
	private int[] lps;
	private int m;
	public KnuthMirrorPatternSearchinglgorithm(int m){
		this.m=m;
		lps=new int[m];
		Arrays.fill(lps, 0);
	}
	public void lps(char[] arr,int m){
		int l=0;
		for(int i=1;i<m;i++){
			if(arr[i]==arr[l]){
				l++;
				lps[i]=l;
			}
			else{
				if(l==0)
					lps[i]=0;
				else
					{l=lps[l-1]; i--;}
					
			}
		}
	}
	public void kmpSearch(char[] text,char[] pat,int n,int m){
		int j=0,i=0;
		while(i<n){
			
			while(j<m&&i<n&&text[i]==pat[j]){
				i++;
				j++;
			}
			if(j==m){
				System.out.print("pattern found at:"+(i-j)+" ");
				j=lps[j-1];
			}
			else if(i<n&&(text[i]!=pat[j])){
					if(j==0)
						i++;
					else
						j=lps[j-1];
			}
				
			
		}
	}
	public static void main(String[] args) {
		String str="abcdabcxabxabcdabcdabcy";
		String pat="abcdabcy";
		int n=str.length();
		int m=pat.length();
		KnuthMirrorPatternSearchinglgorithm kmp=new KnuthMirrorPatternSearchinglgorithm(m);
		kmp.lps(pat.toCharArray(),m);
		System.out.println(Arrays.toString(kmp.lps));
		kmp.kmpSearch(str.toCharArray(), pat.toCharArray(),n,m);
		
	}
	
}
