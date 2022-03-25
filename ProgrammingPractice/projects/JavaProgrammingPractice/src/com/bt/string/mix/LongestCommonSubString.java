package com.bt.string.mix;

import java.util.Arrays;

public class LongestCommonSubString {
	
	public static void print(String[] suffixes){
		System.out.println();
		Arrays.sort(suffixes);
        System.out.println("Sorted Suffixes: ");
        for(String sss:suffixes)System.out.println(sss);
        
	}
	public static void getSuffixOfString(String s,String[] suffixes){
		int N = s.length();
        
        System.out.println("Suffixes: ");
        for(int i=0;i<suffixes.length;++i){
            suffixes[i] = s.substring(i);
            System.out.println(suffixes[i]);
        }
	}
	public static int lcp(String s, String ss){
        int i=0;
        for(;i<s.length();++i){
            if(s.charAt(i)!=ss.charAt(i))break;
        }
        return i;
    }
	public static void lcs(String[] suffx,String[] suffy){
		int maxlcp=0,lcp=0;
		String str="";
		int sx=0,sy=0,ex=suffx.length-1,ey=suffy.length-1;
		int min=Math.min(ex,ey);
		while(sx<=min&&sy<=min){
			lcp=lcp(suffx[sx],suffy[sy]);
			if(maxlcp<lcp)
			{
				maxlcp=lcp;
				str=suffx[sx].substring(0, lcp);
			}
			int res=suffx[sx].compareTo(suffy[sy]);
			if(res<0)
				sx++;
			else
				sy++;
		}
		
		System.out.println("LCS_LEN:"+maxlcp+" LCS "+str);
		
	}
	public static void main(String[] args) {
		String x = "epsgeeksforgeeksas", y = "psageeksquiz";
		String[] suffx = new String[x.length()+1];
		String[] suffy = new String[y.length()+1];
		getSuffixOfString(x,suffx);
		getSuffixOfString(y,suffy);
		System.out.println();
		//Arrays.sort(suffx);
		//Arrays.sort(suffy);
		print(suffx);
		print(suffy);
		lcs(suffx,suffy);
	}
	
}
