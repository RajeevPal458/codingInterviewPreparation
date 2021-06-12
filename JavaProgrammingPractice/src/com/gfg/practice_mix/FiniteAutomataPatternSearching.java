package com.gfg.practice_mix;

import java.util.Arrays;

public class FiniteAutomataPatternSearching {
static int k=0;
	public static char[] charArray(String pat){
		int len=pat.length();
		char[] arr=new char[len];
		arr[k]=pat.charAt(0);
		int j;
		for(int i=1;i<len;i++){
			char ch=pat.charAt(i);
			
			for(j=k;j>=0;j--){
				if(ch==arr[j]){
					break;
				}
			}
			if(j==-1){
				arr[++k]=ch;
			}
		}
		
		return arr;
	}
	public static int[][] finteAutomataTable(String ch,String pat){
		int patlen=pat.length();
		int chlen=ch.length();
		int count=0;
		int[][] arr=new int[patlen][chlen];
		for(int state=0;state<patlen;state++){
			for(int x=0;x<chlen;x++){
				
				if(ch.charAt(x)==pat.charAt(state))
					arr[state][x]=++count;
				else{
					String str=pat.substring(0,state)+ch.charAt(x);
					System.out.println("str:"+str);
					String substr1=str.substring(0,str.length()-1);
					String substr2=str.substring(1,str.length());
					System.out.println("substr1:"+substr1+" substr2:"+substr2);
					while((substr1.length()!=1)&&(!substr1.equals(substr2))){
						System.out.println("substr1:"+substr1+" substr2:"+substr2);
						substr1=substr1.substring(0,substr1.length()-1);
						substr2=substr2.substring(1,substr2.length());
					}
					if(substr1==null){
						arr[state][x]=0;
					}
					else if((substr1.equals(substr2))){
						arr[state][x]=substr1.length();
					}
					else if((substr1.length()==1)&&(substr1.equals(substr2))){
						arr[state][x]=1;
					}
					else
						arr[state][x]=0;
				}
			}
		}
		return arr;
	}
	public static void main(String[] args) {
		String text="ababaababacabbcaabacbaababacadasanababacaca";
		String pattern="ababaca";
		int n=text.length();
		int m=pattern.length();
		// fined array of different characters from pattern String
		char[] arr=charArray(pattern);
		char[] characters=new char[k+1];
		for(int i=0;i<=k;i++)
			characters[i]=arr[i];
		System.out.println();
		System.out.println(Arrays.toString(characters));
		System.out.println();
		int[][] FAT=finteAutomataTable(String.valueOf(characters), pattern);
		for(int i=0;i<pattern.length();i++){
			System.out.println(Arrays.toString(FAT[i]));
		}
		
		int state=0;
		for(int i=0;i<n;i++){
			if((text.charAt(i)-'a')<3)
			state=FAT[state][(text.charAt(i)-'a')];
			if(state==m)
			{
				state=0;
				System.out.println("pattern found At:"+(i-m+1));
			}
		}
		
		
	}
}
