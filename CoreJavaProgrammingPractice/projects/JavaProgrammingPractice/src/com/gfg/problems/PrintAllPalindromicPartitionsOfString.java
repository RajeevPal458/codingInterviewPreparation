package com.gfg.problems;

public class PrintAllPalindromicPartitionsOfString {
	public static boolean isPelindrome(String str){
		if(str==null)
			return false;
		int len=str.length();
		if(len==1) return true;
		for(int i=0,j=len-1;i<len;i++,j--)
			if(str.charAt(i)!=str.charAt(j))
				return false;
		return true;
	}
	public static void partition(String s,int start,StringBuffer res){
		if(isPelindrome(res.toString())){
			System.out.print(res.toString()+" ");
		}
		for(int i=start;i<s.length();i++){
			res.append(s.charAt(i));
			partition(s,i+1,res);
			if(res.length()>0)
				res.deleteCharAt(res.length()-1);
		}
	}
	public static void main(String[] args) {
		StringBuffer sb=new StringBuffer();
		String s = "geeks";
	    partition(s,0,sb);
	}
}
