package com.gfg.microsoft;

public class CheckIfBinaryRepresentationOfANumberIsPalindrome {
	
	public static int findDigitAtIndex(int n,int i){
		System.out.println("1<<(i-1)"+(1<<(i-1)));
		
		return n&(1<<(i-1));
	}
	public static boolean isPelindrome(int n){
		int l=1;
		int r=(String.valueOf(n)).length()+1;
		
		
		while(l<r){
			System.out.println("l "+l+": r "+r);
			System.out.println("Left "+findDigitAtIndex(n,l)+": Right "+findDigitAtIndex(n,r)+" "+(n&512));
			if(findDigitAtIndex(n,l)!=findDigitAtIndex(n,r))
				return false;
			l++; r--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		int i=1<<31 + 1;
		if(isPelindrome(i))
			System.out.println("Number is pelindrome");
		else
			System.out.println("Number is not pelindrome");
	}
}
