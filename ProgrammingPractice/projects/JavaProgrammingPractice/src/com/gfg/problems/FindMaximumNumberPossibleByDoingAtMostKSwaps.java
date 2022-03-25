package com.gfg.problems;

public class FindMaximumNumberPossibleByDoingAtMostKSwaps {
	 static String max;
	public static void findMaximumNum(String str,int k){
		if(k==0)
			return ;
		int n=str.length();
		 for (int i = 0; i < n - 1; i++) 
		 {
		        for (int j = i + 1; j < n; j++)
		        {
		        	if(str.charAt(i)<str.charAt(j))
		        	{
		        		str=swap(str.toCharArray(),i,j);
		        		if (str.compareTo(max) > 0)
		                    max = str;
					
		        		findMaximumNum(str, k-1);
					
		        		str=swap(str.toCharArray(),i,j);
				}
			}
		}
	}
	public static String swap(char[] arr ,int i,int j){
		char temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
		String str=new String(arr);
		return str;
	}
	public static void main(String[] args) {
		String str = "129814999";
		 
	    int k = 4;
	 
	   max = new String("129814999");
	   findMaximumNum(str, k);
	   System.out.println(max);
	}
}
