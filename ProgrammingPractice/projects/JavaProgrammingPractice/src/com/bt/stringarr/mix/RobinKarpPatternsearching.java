package com.bt.stringarr.mix;

import java.math.BigInteger;
import java.util.Random;

public class RobinKarpPatternsearching {
	private static final int d=256;
	private static final int q=101;
	private static int p,t,h=1;
	public RobinKarpPatternsearching(){
	}
	public void robinKarp(char[] txt,char[] pat,int M,int N){
		
		for (int i = 0; i <M-1; i++)
	        h = (h*d)%q;
		//h=(d^(M-1))%q;
		System.out.println(h);
		for (int i = 0; i < M; i++)
		{
			p=d*p+pat[i]%q;
			t=d*t+txt[i]%q;
		}
		//abc => p=a,p=a*d+b,p=a*d^2 +b*d +c;
		System.out.println(p+" "+t);
		int j;
		for (int i = 0; i <= N - M; i++)
	    {
	 
	        // Check the hash values of current window of text
	        // and pattern. If the hash values match then only
	        // check for characters on by one
	        if ( p == t )
	        {
	            /* Check for characters one by one */
	            for (j = 0; j < M; j++)
	            {
	                if (txt[i+j] != pat[j])
	                    break;
	            }
	 
	            // if p == t and pat[0...M-1] = txt[i, i+1, ...i+M-1]
	            if (j == M)
	                System.out.println("Pattern found at index %d \n"+i);
	        }
	 
	        // Calculate hash value for next window of text: Remove
	        // leading digit, add trailing digit
	        if ( i < N-M )
	        {
	            t = (d*(t - txt[i]*h) + txt[i+M])%q;
	 
	            // We might get negative value of t, converting it
	            // to positive
	            if (t < 0)
	            t = (t + q);
	        }
	    }
	}
	/* other way to find hash value is: Let pat="abc"; =>h(abc)=a+b*q+c*q^2 where q is prime;
	 * next hash value we can find useing h(bcd)=[(h(abc)-a)%3 +d*q^2]
	 * */
	public static void main(String[] args) {
		String txt="abcdabxabxabcdabcdabcy";
		String pat="abcdabc";
		int n=txt.length();
		int m=pat.length();
		RobinKarpPatternsearching searcher = new RobinKarpPatternsearching();
        searcher.robinKarp(txt.toCharArray(),pat.toCharArray(),m,n);
	}
}
