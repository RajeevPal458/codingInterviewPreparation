package com.bt.string.mix;

public class FindFirstStringIsSubSequenceOfSecond {

	public static boolean check(String s1,String s2){
		boolean flage=true;
		char[] arr=s1.toCharArray();
		int onlIndex =-1;
		for(char ch:arr){
			
			int ind=s2.indexOf(ch);
			if(ind<0 || ind<onlIndex ){
				flage=false;
				break;
			}
			onlIndex =ind;
		}
		
		return flage;
	}
	
	public static boolean check1(String s1,String s2){
		boolean flage=false;
		char[] arr=s1.toCharArray();
		int onlIndex =-1;
		int i=0;
		int countflag=0;
		for(char ch:arr){
			
			while(i<s2.length()) {
				if(ch==s2.charAt(i)) {
					countflag++;
					System.out.println(ch+":count:"+countflag+":i:"+i);
					break;
				}
				i++;
			}
		}
		if(s1.length()==countflag) flage=true;
		
		return flage;
	}
	
	
	public static void main(String[] args) {
		String s1="AXY";
		String s2="ADXCPY";
		System.out.println("Str1 is subString of str2:"+check1(s1, s2));
		
	}
}
