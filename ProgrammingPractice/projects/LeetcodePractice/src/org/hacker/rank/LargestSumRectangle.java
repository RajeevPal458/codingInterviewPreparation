package org.hacker.rank;

import java.util.Arrays;

public class LargestSumRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int arr[][] = new int[][] { { 1, 2, -1, -4, -20 },
			 						 { -8, -3, 4, 2, 1 },
			 						 { 3, 8, 10, 1, 3 },
			 						 { -4, -1, 1, 7, -6 } };
             
        int m = arr.length;
        int n = arr[0].length;
        
        maxMatrixSum(arr, m, n);
	}

	private static void maxMatrixSum(int[][] arr,int m ,int n) {
		// TODO Auto-generated method stub
		int resMaxSum =0;
		int resmaxtop=0, resmaxbottom=0,resmaxleft=0,resmaxright=0;
	
		for(int top=0;top<m;top++) {
			int[] temp = new int[n];
			int maxbottom=0,maxleft=0,maxright=0;
			int max=0;
			
			for(int i=top;i<m;i++) {
				
				for(int j=0;j<n;j++) {
					temp[j] += arr[i][j]; 
				}
				
				int[] res = maxsumKadanes(n,temp);
				int currMax =res[2];
				if(max<currMax) {
					maxleft =res[0];
					maxright = res[1];
					maxbottom =i;
					max =currMax;
				}
			}
			if(resMaxSum<max) {
				resMaxSum = max;
				resmaxtop = top;
				resmaxleft =maxleft;
				resmaxright = maxright;
				resmaxbottom =maxbottom;
			}
			
		}
		System.out.println(resMaxSum+" "+resmaxtop+" "+resmaxbottom+"  "+resmaxleft+" "+resmaxright);
		for(int i=resmaxtop;i<=resmaxbottom;i++) {
			for(int j=resmaxleft;j<=resmaxright;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		
	}
	
	public static int[] maxsumKadanes(int n, int[] arr) {
		int s=0,start=0,end=0;
		int max=0;
		int currmax = 0;
		for(int i=0;i<n;i++) {
			currmax = currmax +arr[i];
			
			if(currmax<0) {
				currmax=0;
				s=i+1;
			}
			
			if(currmax >= max) {
				start=s;
				end=i;
				max = currmax;
			}
		}
		return new int[] {start,end,max};
		
	}

}
