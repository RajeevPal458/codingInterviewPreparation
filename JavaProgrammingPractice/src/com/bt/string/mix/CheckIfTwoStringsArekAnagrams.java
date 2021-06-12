package com.bt.string.mix;

public class CheckIfTwoStringsArekAnagrams {

	public static boolean checkKAnagram(String str1,String str2,int k){
		boolean flage=false;
		char[] arr=str1.toCharArray();
		String str=str2;
		System.out.println(str1.length()+"  " +str2.length());
		if(str1.length()!=str2.length())
			return flage;
		
		for(char ch:arr){
			int ind=str.indexOf(ch);
			if(ind>=0){
				str=str.substring(0,ind)+str.substring(ind+1,str.length());
			}
		}
		System.out.println(str+"  strlen  :"+str.length()+" K "+k);
		
		if(str.length()<=k)
			flage=true;
		return flage;
	}
	public static void main(String[] args) {
		String str1="geeks";
		String str2="eggkf";
		int k=2;
		System.out.println("str1:"+str1+" and str2:"+str2+"  are k "+k+" anagram :"+checkKAnagram(str1, str2,k));
	}

}
