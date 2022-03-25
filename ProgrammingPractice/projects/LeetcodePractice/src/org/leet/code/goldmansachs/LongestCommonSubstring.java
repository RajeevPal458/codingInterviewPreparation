package org.leet.code.goldmansachs;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String X = "OldSite:GeeksforGeeks.org";
        String Y = "NewSite:GeeksQuiz.com";
 
        int m = X.length();
        int n = Y.length();
 
        System.out.println(LCSubStr(X,Y, m, n));
	}
	
	// use dynamic aproach
	private static String LCSubStr(String str1, String str2, int m, int n) {
		// TODO Auto-generated method stub
		int[][] temp = new int[m+1][n+1];
		
		String maxString = "" ;
		StringBuffer sb1= new StringBuffer();
		
		for(int i=1;i<=m;i++) {
			
			for(int j=1;j<=n;j++) {
				if(str1.charAt(i-1)==str2.charAt(j-1)) {
					temp[i][j] = temp[i-1][j-1]+1;
					
				}else {
					temp[i][j]=0;
				}
			}
			
		}
		
		int max=0;
		int r=0;
		int c=0;
		for(int i=0;i<m;i++) {
			
			for(int j=0;j<n;j++) {
				if(temp[i][j]>max) {
					max = temp[i][j];
					r=i;
					c=j;
				}
				 
			}
			
		}
		
		while(temp[r][c]>0) {
			sb1.append(str1.charAt(r-1));
			r = r-1;
			c = c-1;
		}
		System.out.println("Max Sub String length:"+max+":max sub string:"+sb1.reverse().toString());
		
		return sb1.toString();
	}

}
