package com.gfg.microsoft;

public class BinaryRepresentationOfAGivenNumber {

	public static void decimalToBinary1(int n){
		System.out.println("sgdhf");
		    /* step 1 */
		    if (n > 1)
		    	decimalToBinary1(n/2);
		 
		    /* step 2 */
		    System.out.print( n % 2+" ");
		
	}
	public static void decimalToBinary2(int n){
		if(n>1)
			decimalToBinary2(n/2);
		
		System.out.print(n%2);
	}
	public static void main(String[] args) {
		BinaryRepresentationOfAGivenNumber g=new BinaryRepresentationOfAGivenNumber();
		g.decimalToBinary1(22);
		g.decimalToBinary2(22);
	}
}
