package org.algo.strarr;

import java.util.PriorityQueue;

public class RearrangeStringAsNoAdjacentCharDuplicateGtThenK {

	static int MAX_CHAR = 26;

	// Function to rearrange character of a string
	// so that no char repeat twice
	static String rearrangeString(String str,int p)
	{
		int n = str.length();

		// Store frequencies of all characters in string
		int[] count = new int[MAX_CHAR];

		for (int i = 0; i < n; i++)
			count[str.charAt(i) - 'a']++;

		// Insert all characters with their frequencies
		// into a priority_queue
		PriorityQueue<Key> pq
			= new PriorityQueue<>(new KeyComparator());
		for (char c = 'a'; c <= 'z'; c++) {
			int val = c - 'a';
			if (count[val] > 0)
				pq.add(new Key(count[val], c));
		}

		// 'str' that will store resultant value
		str = "";

		// work as the previous visited element
		// initial previous element be. ( '#' and
		// it's frequency '-1' )
		Key prev = new Key(-1, '#');
		// traverse queue
		while (!pq.isEmpty()) {
			Key k = pq.peek();
			pq.poll();
			int countp=p;
			while (countp>0 && k.freq>0) {
				str = str + k.ch;
				countp--;
				k.freq--;
			}
			if( prev.freq>0)
				pq.add(prev);
			
			prev =k;
		}

		// If length of the resultant string and original
		// string is not same then string is not valid
		
		return str;
	}

	// Driver program to test above function
	public static void main(String args[])
	{
		String str = "zzzzyyyxxa";
		int k=2;
		String rearrangedString =rearrangeString(str,k);
		
		System.out.println(":rearrangedString:"+rearrangedString);
	}
}
