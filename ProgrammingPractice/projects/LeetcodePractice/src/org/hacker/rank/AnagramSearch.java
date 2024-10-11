package org.hacker.rank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnagramSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String txt = "BACDGABCDA";
        String pat = "ABCD";
        List<Integer> result = search(pat, txt);
        System.out.println(result);
        txt="AAABABAA";
        pat = "AABA";   
        result = search(pat, txt);
        System.out.println(result);
	}

	private static List<Integer> search(String pat, String txt) {
		int m = pat.length(), n = txt.length();
		
        List<Integer> res = new ArrayList<>();
        int[] countP = new int[256];
        int[] countTW = new int[256];

        // Initialize countP and countTW arrays
        for (int i = 0; i < m; i++) {
            countP[pat.charAt(i)]++;
            countTW[txt.charAt(i)]++;
        }

        // Traverse through remaining characters of text
        for (int i = m; i < n; i++) {

            // Compare counts of current window 
            // of text with counts of pattern.
            if (Arrays.equals(countP, countTW)) {
                res.add(i - m);
            }

            // Add current character to current window
            countTW[txt.charAt(i)]++;

            // Remove the first character of previous window
            countTW[txt.charAt(i - m)]--;
        }

        // Check for the last window in text
        if (Arrays.equals(countP, countTW)) {
            res.add(n - m);
        }

        return res;
	}

}
