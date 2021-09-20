package org.algo.strarr;

import java.util.Arrays;

public class ZeroOneKnapshakProblem {

	public static void main(String args[])
    {
        int val[]=new int[]  { 1, 4,5,7};
        int wt[] = new int[] {1,3,4,5};
        int W = 7;
        System.out.println(knapSack(W, wt, val));
    }

	private static int knapSack(int w, int[] wt, int[] val) {
		
		int wtlen = wt.length;
		
		int[][] temp = new int[wtlen+1][w+1];
		
		for(int i=1;i<=wtlen;i++) {
			
			for(int j=1;j<=w;j++) {
				
				if(j>=wt[i-1]) {
					temp[i][j] = Math.max(temp[i-1][j],val[i-1]+temp[i-1][j-wt[i-1]]);
				}else {
					temp[i][j] = temp[i-1][j];
				}
			}
		}
		
		for(int i=0;i<=wtlen;i++) {
			
			for(int j=0;j<=w;j++) {
				
				System.out.print(temp[i][j]+" ");
			}
			System.out.println();
		}
		return temp[wtlen][w];
	}

}
