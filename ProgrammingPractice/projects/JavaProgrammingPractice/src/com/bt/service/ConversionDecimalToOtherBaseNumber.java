package com.bt.service;

public class ConversionDecimalToOtherBaseNumber{
	
	public static String Hexa(String s) {
	    String result = "";
	    int n = Integer.parseInt(s);
	    int remainder = n % 16;

	    if (n == 0) {
	        return Integer.toString(0);
	    } else {
	        switch (remainder) {
	            case 10:
	                result = "A" + result;
	                break;
	            case 11:
	                result = "B" + result;
	                break;
	            case 12:
	                result = "C" + result;
	                break;
	            case 13:
	                result = "D" + result;
	                break;
	            case 14:
	                result = "E" + result;
	                break;
	            case 15:
	                result = "F" + result;
	                break;
	            default: result = Integer.toString(remainder) + result; break;
	        }
	        System.out.println(result);
	        return Hexa(Integer.toString(n/16)) + result;
	    }
	}
	public static String decimalToAnyBase(int num,int base){
		
		if(num<base)
			return num+"";
		String result="";
		int rem=num%base;
		String str=decimalToAnyBase(num/base, base);
			result=str+((rem>=10)? (char)(rem-10+'A')+"":rem);
		return result;
		
	}
	public static void main(String[] args) {
		System.out.println(decimalToAnyBase(28,2));
		System.out.println(decimalToAnyBase(28,8));
		System.out.println(decimalToAnyBase(30,16));
		
		
	}
}
