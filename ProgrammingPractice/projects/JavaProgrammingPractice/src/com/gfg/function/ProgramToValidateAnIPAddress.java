package com.gfg.function;

import java.util.Scanner;
import java.util.StringTokenizer;

public class ProgramToValidateAnIPAddress {

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
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Please enter Ip Address ");
		String str=sc.nextLine();
		
		if(isvalidIpAddress(str)){
			System.out.println("Ip Address is valid!");
		}
		else{
			System.out.println("Ip Address is not valdate!");
		}
		
	}
}
