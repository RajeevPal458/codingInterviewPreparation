package org.hacker.rank;

import java.security.DomainCombiner;
import java.util.Arrays;

public class MaxPalindrome {
	
	public static void main(String[] args) {
		String str ="11331";
		int k=4;
		String result =highestValuePalindrome(str, str.length(), k);
		System.out.println(result);
		
	}
	
	public static String highestValuePalindrome(String s, int n, int k) {
		char[] arr = s.toCharArray();
        int left = 0;
        int right = n - 1;
        int changes = 0;

        while (left < right) {
            if (arr[left] != arr[right]) {
                char maxChar = (char) Math.max(arr[left], arr[right]);
                arr[left] = maxChar;
                arr[right] = maxChar;
                changes++;
            }
            left++;
            right--;
        }

        if (changes > k) {
            return "-1"; 
        }

        left = 0;
        right = n - 1;
        while (left <= right) {
            if (left == right) {
                if (k - changes > 0) {
                    arr[left] = '9';
                }
            } else {
                if (arr[left] < '9') {
                    if (k - changes >= 2 && arr[left] == s.charAt(left) && arr[right] == s.charAt(right)) {
                        
                        arr[left] = '9';
                        arr[right] = '9';
                        changes += 2;
                    } else if (k - changes >= 1 && s.charAt(left) != s.charAt(right)) {
                        
                        arr[left] = '9';
                        arr[right] = '9';
                        changes++;
                    }
                }
            }
            left++;
            right--;
        }

        return new String(arr);
	    }

}
