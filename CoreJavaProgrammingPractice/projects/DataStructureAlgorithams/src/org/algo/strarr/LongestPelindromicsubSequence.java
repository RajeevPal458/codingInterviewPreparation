package org.algo.strarr;

import java.util.Arrays;

public class LongestPelindromicsubSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "agbdba";
		int n = str.length();
		System.out.println("lpa:--"+lpsubSequenceString(str.toCharArray(),n));;

	}

	private static int lpsubSequenceString(char[] str, int n) {
		// TODO Auto-generated method stub
		int[][] arr = new int[n][n];
		System.out.println("len:"+n);
		int lpa=1;
		for(int i=0;i<n;i++) {
			arr[i][i]=1;
		}
		
		for(int i=2;i<=n;i++) {
			
			for(int j=0;j<n-i+1;j++) {
				int k=j+i-1;
				if(str[j]==str[k]) {
					arr[j][k] = arr[j+1][k-1]+2;
				}else {
					
					arr[j][k] = Math.max(arr[j+1][k], arr[j][k-1]);
					//System.out.print("arr["+j+"]["+k+"]:"+arr[j][k]+":arr["+(j+1)+"]["+k+"]:"+arr[j+1][k]+":arr["+j+"]["+(k-1)+"]:"+arr[j][k-1]+":--:");
				}
			}
			System.out.println();
		}
		for(int i=0;i<n;i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		return arr[0][n-1];
	}

}
