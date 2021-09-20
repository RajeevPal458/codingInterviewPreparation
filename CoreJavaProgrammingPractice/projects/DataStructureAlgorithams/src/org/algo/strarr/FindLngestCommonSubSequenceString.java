package org.algo.strarr;

import java.util.Arrays;

public class FindLngestCommonSubSequenceString {

	public static void main(String[] args) {
		String str1= "rajeevkumarpal";
		String str2= "jremkcmarnldra";
		int len1 = str1.length();
		int len2 = str2.length();
		String str=lcsubsequencestr(str1,str2,len1,len2);
		System.out.println("Longest common sub sequence string : "+str);
	}

	private static String lcsubsequencestr(String str1, String str2, int len1, int len2) {
		// TODO Auto-generated method stub
		
		int[][] temp= new int[len1+1][len2+1];
		
		int maxcount = 0;
		int maxindx =0;
		int maxindy =0;
		for(int i=1;i<len1;i++) {
			
			for(int j=1;j<len2;j++) {
				if(str1.charAt(i-1)==str2.charAt(j-1)) {
					temp[i][j] = temp[i-1][j-1]+1;
					if(maxcount<temp[i][j]) {
						maxcount =temp[i][j];
						maxindx =i;
						maxindy =j;
					}
				}else {
					temp[i][j] = Math.max(temp[i][j-1], temp[i-1][j]);
				}
			}
		}
		
		System.out.println(":maxindx:"+maxindx);
		System.out.println(":maxindy:"+maxindy);
		System.out.println(":maxcount:"+maxcount+"temp[maxindx-1][maxindy-1]:"+temp[maxindx-1][maxindy-1]);
		
		for(int i=0;i<len1+1;i++) {
			System.out.println(Arrays.toString(temp[i]));
		}
		String subseq ="";
		while (temp[maxindx][maxindy]!=0) {
			if(temp[maxindx-1][maxindy-1]+1==temp[maxindx][maxindy]&&str1.charAt(maxindx-1) == str2.charAt(maxindy-1)) {
				subseq =str1.charAt(maxindx-1)+subseq;
				System.out.println(subseq);
				maxindx--;
				maxindy--;
			}else {
				if(temp[maxindx][maxindy-1] > temp[maxindx-1][maxindy]) {
					maxindy--;
				}else {
					maxindx--;
				}
			}
		}
		
		return subseq;
	}

}
