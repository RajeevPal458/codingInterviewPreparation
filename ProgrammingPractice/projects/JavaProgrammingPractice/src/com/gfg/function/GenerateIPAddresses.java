package com.gfg.function;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GenerateIPAddresses {
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        StringBuilder sb = new StringBuilder(s);
        print(sb, 0);
    }

    private static boolean print(StringBuilder sb, int d) {
        if(d==3) return isvalidIpAddress(sb.toString());
        
        int len=sb.length();
        //System.out.print(len);
        //System.out.println();
        int i=sb.lastIndexOf(".")+2;
        for( ;i<len;i++){
        	sb.insert(i, ".");
        	if(print(sb, d+1)){
        		System.out.println(sb.toString());
        	}
        	sb.deleteCharAt(i);
        }
        return false;
    }

    public static boolean isvalidIpAddress(String s){
		int num;
		if(s==null)
			return false;
		StringTokenizer tokens=new StringTokenizer(s, ".");
		while(tokens.hasMoreTokens()){
			try{
				num=Integer.parseInt(tokens.nextToken());
				if(num>256||num<0)
					return false;
			}catch(NumberFormatException e){
				e.printStackTrace();;
				return false;
			}
		}
		return true;
	}
}
