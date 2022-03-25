package org.algo.stack;

public class MinimumSwapsforBracketBalancing {
//Java Program to count swaps required to balance string
	
	static long swapCount(String s)
	{
		char[] chars = s.toCharArray();
		
		// stores total number of Left and Right
		// brackets encountered
		int countLeft = 0, countRight = 0;
				// swap stores the number of swaps required
		//imbalance maintains the number of imbalance pair
		int swap = 0 , imbalance = 0;
		
		for(int i =0; i< chars.length; i++)
		{
			if(chars[i] == '[')
			{
				// increment count of Left bracket
				countLeft++;
				if(imbalance > 0)
				{
					// swaps count is last swap count + total
					// number imbalanced brackets
					swap += imbalance;
					// imbalance decremented by 1 as it solved
					// only one imbalance of Left and Right
					imbalance--;	
				}
			} else if(chars[i] == ']' )
			{
				// increment count of Right bracket
				countRight++;
				// imbalance is reset to current difference
				// between Left and Right brackets
				imbalance = (countRight-countLeft);
			}
		}
		return swap;
	}
	
	 public static int minSwaps(String s) {
	        int maxClose = 0, close = 0;
	        
	        for(int i=0; i<s.length(); i++) {
	            if(s.charAt(i) == ']') {
	                close++;
	            } else {
	                close--;
	            }
	            maxClose = Math.max(maxClose, close);
	        }
	        if(close==0)
	        	return (maxClose + 1) / 2;
	        else 
	        	return -1;
	    }

//Driver code
	public static void main(String args[])
	{
		String s = "[]][][";
		System.out.println(minSwaps(s) );

		s = "[[][]]";
		System.out.println(minSwaps(s) );
		
	}
}
//This code is contributed by Janmejaya Das.
