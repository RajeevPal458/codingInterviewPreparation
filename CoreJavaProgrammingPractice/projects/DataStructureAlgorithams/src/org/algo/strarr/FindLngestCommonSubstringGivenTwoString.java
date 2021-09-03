package org.algo.strarr;

import java.util.Arrays;

public class FindLngestCommonSubstringGivenTwoString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x = "epsgeeksforgeeksas", y = "psageeksquiz";
		
		int lenx = x.length() , leny=y.length();
		
		//commonsubstring(x,y,lenx,leny);
		commonsubstringDynamic(x,y,lenx,leny);
	}
	
	private static void commonsubstringDynamic(String x, String y, int lenx, int leny) {
		int[][]  temp= new int[lenx+1][leny+1];
		int count=0;
		int p=0,q=0;
		for(int i=1;i<lenx;i++) {
			
			for(int j=1;j<leny;j++) {
				
				if(x.charAt(i-1)==y.charAt(j-1)) {
					temp[i][j] = temp[i-1][j-1]+1;
					if(count< temp[i][j]) {
						count = temp[i][j];
						p=i;q=j;
					}
				}
			}
		}
		for(int i=0;i<lenx;i++) {
			System.out.println(Arrays.toString(temp[i]));
		}
		
		System.out.println(":Len:"+count+"::( "+p+","+q+" )="+temp[p][q]);
		String sb= "";
		while (temp[p][q]!=0) {
			sb = y.charAt(q-1)+""+sb ;
			p--;
			q--;
		}
		System.out.println(sb);
	}

	private static void commonsubstring(String x, String y, int lenx, int leny) {
		StringBuffer maxstr=new StringBuffer();
		for(int i=0;i<lenx;i++) {
			
			for(int j=0;j<leny;j++) {
				int ai=i;
				int aj =j;
				StringBuffer str = new StringBuffer();
				System.out.println("Start -  :ai:"+ai+":aj:"+aj);
				boolean flag=false;
				while (ai<lenx && aj<leny && x.charAt(ai)==y.charAt(aj)) {
					System.out.println(":ai:"+ai+":aj:"+aj+"::str::"+str);
					str.append(x.charAt(ai));
					flag=true;
					ai++;
					aj++;
				}
				if(flag &&(maxstr.length() < str.length())) {
					maxstr = str;
				}
			}
			System.out.println("-----------------");
		}
		
		System.out.println(maxstr.toString());
	}
	

}
