package org.hacker.rank;

import java.util.Stack;
/**
 * 
 * 
 * Maximum Sum Rectangular Submatrix in Matrix dynamic programming/2D kadane
 * Maximum Size Rectangle of All 1's Dynamic Programming
 * Egg Dropping Dynamic Programming
 * Palindrome Partition Dynamic Programming
 * Longest Palindromic Subsequence DP
 * longest increasing subsequence
 * max sum increasing subsequence
 * Burst Balloon Dynamic Programming
 * longest common subsequence
 * cutting a rod to maximise profit
 * edit distance between two string
 * maximum edit distance
 * coin change problem
 * rabin karp
 * Longest Palindromic Sub-string
 * maximum sum square matrix
 * 
 */
public class MaximumRactangleArea {
	
	public static void main(String[] args) {
		int R = 4;
        int C = 4;

        int A[][] = {
            { 0, 1, 1, 0 },
            { 1, 1, 1, 1 },
            { 1, 1, 1, 1 },
            { 1, 1, 0, 0 },
        };
        /**
         * 
   
        
        
        
        
         */
        
        
        
        System.out.print("Area of maximum rectangle is "
                         + maxRectangle(R, C, A));
	}
	public static int maxRectangle(int R,int C,int[][] A) {

        int result = maxHist(C, A[0]);

        // iterate over row to find maximum rectangular area
        // considering each row as histogram
        for (int i = 1; i < R; i++) {

            for (int j = 0; j < C; j++){
                if (A[i][j] == 1)
                    A[i][j] += A[i - 1][j];
            }
            result = Math.max(result, maxHist(C, A[i]));
        }

        return result;
    }

    public static int maxHist(int n,int[] arr){
        Stack<Integer> s = new Stack<>();
        int max =0;
        int i=0;
        while(i<n){

            if(s.isEmpty() || arr[s.peek()]<=arr[i]){
                s.push(i++);
            }else{
                int top = s.pop();
                int currsum = s.isEmpty()?arr[top]*i: arr[top]*(i-arr[s.peek()]-1);
                if(max<currsum){
                    max = currsum;
                }

            }
        }

        while(!s.isEmpty()){
            int top = s.pop();
            int currsum = s.isEmpty()?arr[top]*i: arr[top]*(i-arr[s.peek()]-1);
            if(max<currsum){
                max = currsum;
            }
        }
        return max;
    }

}
