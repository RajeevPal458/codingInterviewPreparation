package org.algo.strarr;

public class CheckIfFirstStringIsSubSquenceOfSecond {

	public static void main(String[] args) {
		String s1="AXY";
		String s2="ADXCPY";
		System.out.println("Str1 is subString of str2:"+check(s1, s2));
	}

	private static Boolean check(String s1, String s2) {
		Boolean flag =false;
		int searchInd = 0;
		for(int i=0;i<s2.length()&&searchInd<s1.length();i++) {
			if(s2.charAt(i)==s1.charAt(searchInd)) {
				searchInd++;
			}
		}
		if(searchInd==s1.length())
			flag=true;
		return flag;
	}

}
