package com.gfg.problems;

import java.util.Arrays;

public class WordBreakProblemusingBacktracking {
	private static String dictionary[] = {"mobile","samsung","sam","sung",
            "man","mango", "icecream","and",
            "go","i","love","ice","cream"};
	private static boolean isContains(String st){
		for(int i=0;i<dictionary.length;i++){
			if(dictionary[i].equals(st))
				return true;
		}
		return false;
	}
	private static void wordBreakUtil(String str,int len,String res) {
		/*System.out.println(str);;
		System.out.println(len);*/
		for(int i=1;i<=len;i++){
			
			String prefix =str.substring(0,i);
			//System.out.println(prefix);
			if(isContains(prefix)){
				if(i==len){
					res+=prefix;
					System.out.println(res);
					return ;
				}
				wordBreakUtil(str.substring(i,len),len-i,res+prefix+" ");
			}
		}
	}
	private static void wordBreak(String string) {
		wordBreakUtil(string,string.length(), "");
	}
	
	public static void main(String[] args) {
		System.out.println("First Test:");
		wordBreak("iloveicecreamandmango");
		
		System.out.println("Second Test:");
	    wordBreak("ilovesamsungmobile");
	}

}
