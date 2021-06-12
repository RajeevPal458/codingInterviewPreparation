package com.bt.stringarr.mix;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class NumberOfEncodingOfAGivenDigitString {
static int count=0;
//A Dynamic Programming based function to count decodings

public static int countDecodingDP(char[] digits, int n)
{
    int count[]=new int[n+1]; // A table to store results of subproblems
    count[0] = 1;
    count[1] = 1;
 
    for (int i = 2; i <= n; i++)
    {
        count[i] = 0;
 
        // If the last digit is not 0, then last digit must add to
        // the number of words
        if (digits[i-1] > '0')
            count[i] = count[i-1];
 
        // If second last digit is smaller than 2 and last digit is
        // smaller than 7, then last two digits form a valid character
        if (digits[i-2] < '2' || (digits[i-2] == '2' && digits[i-1] < '7') )
            count[i] += count[i-2];
    }
    return count[n];
}
public static int countDecoding(char[] digits, int n)
{
    // base cases
    if (n == 0 || n == 1)
        return 1;
 
    int count = 0;  // Initialize count
 
    // If the last digit is not 0, then last digit must add to
    // the number of words
    System.out.println(n);
    if (digits[n-1] > '0')
        count =  countDecoding(digits, n-1);
    // If the last two digits form a number smaller than or equal to 26,
    // then consider last two digits and recur
    if (digits[n-2] < '2' || (digits[n-2] == '2' && digits[n-1] < '7') )
        count +=  countDecoding(digits, n-2);
 
    return count;
}
	public static void encodings(String str,int n){
		
	}
	public static void main(String[] args) {
		String str="314";
		int n=str.length();
		System.out.println(countDecoding(str.toCharArray(), n));;
		
	}
}
