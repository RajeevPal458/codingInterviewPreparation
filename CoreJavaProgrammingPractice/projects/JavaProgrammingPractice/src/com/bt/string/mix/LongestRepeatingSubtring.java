package com.bt.string.mix;

import java.util.Arrays;

import javax.sound.midi.SysexMessage;

public class LongestRepeatingSubtring {
	
	 public static String lrs(String s){
	        int N = s.length();
	        String[] suffixes = new String[N];
	        
	        System.out.println("Suffixes: ");
	        for(int i=0;i<suffixes.length;++i){
	            suffixes[i] = s.substring(i);
	            System.out.println(suffixes[i]);
	        }
	        
	        System.out.println();
	        Arrays.sort(suffixes);
	        System.out.println("Sorted Suffixes: ");
	        for(String sss:suffixes)System.out.println(sss);
	        
	        String lrs = "";
	        System.out.println(suffixes.length);
	        System.out.println();
	        for(int i=0;i<suffixes.length-1;++i){
	            int len = lcp(suffixes[i], suffixes[i+1]);
	            System.out.print(" Len:"+len+" i:"+i+" , "+lrs.length());
	            
	            if(len>=0&& len>lrs.length()){
	            	//System.out.print(" "+i+" ");
	                lrs = suffixes[i].substring(0, len);
	            }
	            System.out.println();
	        }
	        return lrs;        
	    }
	    
	    public static int lcp(String s, String ss){
	        int i=0;
	        for(;i<s.length();++i){
	            if(s.charAt(i)!=ss.charAt(i))break;
	        }
	        return i;
	    }
	    
	    static int findLongestRepeatingSubSeq(String str)
	    {
	        int n = str.length();
	  
	        // Create and initialize DP table
	        int[][] dp = new int[n+1][n+1];
	  
	        // Fill dp table (similar to LCS loops)
	        for (int i=1; i<=n; i++)
	        {
	            for (int j=1; j<=n; j++)
	            {
	                // If characters match and indexes are not same
	                if (str.charAt(i-1) == str.charAt(j-1) && i!=j)
	                    dp[i][j] =  1 + dp[i-1][j-1];         
	                       
	                // If characters do not match
	                else
	                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
	            }
	        }
	        return dp[n][n];
	    }
	    
	    static int findLongestRepeatingSubString(String str)
	    {
	        int n = str.length();
	  
	        // Create and initialize DP table
	        int[][] dp = new int[n+1][n+1];
	  
	        // Fill dp table (similar to LCS loops)
	        for (int i=1; i<=n; i++)
	        {
	            for (int j=1; j<=n; j++)
	            {
	                // If characters match and indexes are not same
	                if (str.charAt(i-1) == str.charAt(j-1) && i!=j)
	                    dp[i][j] =  1 + dp[i-1][j-1];         
	                       
	                // If characters do not match
	                else
	                    dp[i][j] = 0;
	            }
	        }
	        return dp[n][n];
	    }
	    
	    public static void main(String[] args){
	        String s = "aabbcdee";
	        
	        //Include overlapping substrings
	        System.out.println("\n\nLongest Repeated Substring -> "+findLongestRepeatingSubString(s));
	    }
}
