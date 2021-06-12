package com.bt.stringarr.mix;

import java.util.Arrays;

public class BoyerMooreAlgorithm {
	private static final int char_size=26;
	int[] bad_char;
	public BoyerMooreAlgorithm(){
		bad_char=new int[char_size];
	}
	public void badcharHuristic(char[] pat,int m){
		
		for(int i=0;i<char_size;i++){
			bad_char[i]=-1;
		}
		for(int i=0;i<m;i++){
			bad_char[pat[i]-'a']=m-i-1;
		}
	}
	public void horspoolSearch(char[] text,char[] pat,int n,int m){
		int s=0,i=0,j=0;
		while(s<=n-m){
			j=m-1;
			while((j>=0)&&text[s+j]==pat[j])
				j--;
			if(j<0){
				System.out.println("pattern match found at:"+s);
				s+=(s+m<n)?bad_char[text[s+m]-'a']:1;
			}
			else
				s+=Math.max(1, bad_char[text[s+j]-'a']);
		}
	}
	public static void main(String[] args) {
		String str="abcdabcxabxabcdabcdabcy";
		String pat="abcdabcy";
		int n=str.length();
		int m=pat.length();
		BoyerMooreAlgorithm hrsp=new BoyerMooreAlgorithm();
		hrsp.badcharHuristic(pat.toCharArray(),m);
		System.out.println(Arrays.toString(hrsp.bad_char));
		hrsp.horspoolSearch(str.toCharArray(), pat.toCharArray(),n,m);
	}
}
