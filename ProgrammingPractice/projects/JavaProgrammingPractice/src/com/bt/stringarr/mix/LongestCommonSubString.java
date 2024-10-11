package com.bt.stringarr.mix;

public class LongestCommonSubString {
	static int[][] dp;
	static int max=0,end=0;
	private static void lcsubSequence(char[] row, char[] col, int rlen, int clen) {
		// TODO Auto-generated method stub
		dp=new int[rlen][clen];
		for(int i=0;i<rlen;i++){
			for(int j=0;j<clen;j++){
				
				if(row[i]==col[j]){
					
					if(i==0||j==0)
						dp[i][j]=1;
					else
						dp[i][j]=dp[i-1][j-1]+1;
					if(max<dp[i][j])
						max=dp[i][j];
					end=j;
				}
			}
		}
	}

	public static int lcss(String str1,String str2,int m,int n) {
		if(m==0 || n==0 || str1.charAt(m-1)!=str2.charAt(n-1)) return 0;
		
		
		return 1+ lcss(str1, str2, m-1, n-1);
		
	}
	
	static int maxCommStr(String s1, String s2) {
        int res = 0;
        int m = s1.length();
        int n = s2.length();

        // Find the longest common substring ending
        // at every pair of characters and take the 
        // maximum of all.
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                res = Math.max(res, lcss(s1, s2, i, j));
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
		String str1="LCLC";
		String str2="CLACL";
		lcsubSequence(str1.toCharArray(),str2.toCharArray(),str1.length(),str2.length());
		System.out.println(str2.substring(end-max+1, end+1)+"  " +max);
		
		int len = maxCommStr(str1, str2);
		System.out.println("LCSS:-"+len);
		
	}

}/*
  L C L C
C
L
C
L
*/