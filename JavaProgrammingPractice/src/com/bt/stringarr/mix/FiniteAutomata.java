package com.bt.stringarr.mix;

import java.util.Arrays;

public class FiniteAutomata {

	public static int numberOfChar(String pat){
		int num=1;
		if(pat==null)
			return 0;
		boolean[] flag=new boolean[256];
		Arrays.fill(flag, false);
		char[] arr=pat.toCharArray();
		flag[arr[0]]=true;
		for(int i=0;i<arr.length-1;i++){
			if((arr[i]!=arr[i+1])&&!flag[arr[i+1]])
			{
				flag[arr[i+1]]=true;
				num++;
			}
		}
		return num;
	}
	public static void createFiniteTable(int[][] ft,char[] pat,char[] characters,int patlen,int chrlen){
		int st=0;
		for(int state=0;state<=patlen;state++){
			for(int x=0;x<chrlen;x++){
				
				if((state!=patlen)&&(pat[state]==characters[x]))
				{
					ft[state][x]=++st;
				}
				else
				{
					String pt=String.valueOf(pat);
					String str=pt.substring(0, state).concat(characters[x]+"");
					String str1=str.substring(0,str.length()-1);
					String str2=str.substring(1,str.length());
					//System.out.println("Str1"+str1);
					//System.out.println("Str2"+str2);
					while(str1!=null&&str2!=null)
					{
						if(!str1.equals(str2)&&(str1!=null)&&(str2!=null)){
							str1=str1.substring(0,str1.length()-1);
							if(str2.length()!=1)
								str2=str2.substring(1,str2.length());
							else
							{
								ft[state][x]=0;
								break;
							}
						}
						else
						{
							ft[state][x]=str1.length();
							break;
						}
					}
				}
			}
		}
	}
	public static void searchPattern(String text,String pat){
		int textlen=text.length();
		int patlen=pat.length();
		int numOfChar=numberOfChar(pat);
		String chrs="abc";
		System.out.println(numOfChar);
		int[][] Ft=new int[patlen+1][numOfChar];
		createFiniteTable(Ft, pat.toCharArray(), chrs.toCharArray(), patlen, chrs.length());
		
		for(int j=0;j<=patlen;j++){
			for(int i=0;i<numOfChar;i++){
				System.out.print(Ft[j][i]+" ");
			}
			System.out.println();
		}
		int state=0;
		for(int i=0;i<textlen;i++){
			state=Ft[state][text.charAt(i)-'a'];
			if(state==patlen){
				System.out.print("pattern found at index:"+(i-patlen+1)+"  ");
			}
			System.out.println();
		}
		
	}
	public static void main(String[] args) {
		String text="abacbaababacababacaba";
		String pat="ababaca";
		searchPattern(text, pat);
		
		
	}
}
