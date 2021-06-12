package com.bt.string.mix;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SortestSuperStringProb {

	public static int longestCommnsuffixOrPrifix(String str1,String str2){
		//System.out.println("1");
		int count=0;
		if(str1==null || str2==null)
			return -2;
		int i=str1.length()-1,j=0,len2=str2.length();
		while(i>=0&&j<len2){
			if(str1.charAt(i)==str2.charAt(j)){
				count++;
			}
			i--;
			j++;
		}
		//System.out.print(count);
		return count;
	}
	public static  void superString(String[] str){
		int len=str.length;
		int p=7;
		while(true){
			
			int max=0,maxcomn=-1;
			int first=-1,second=-1;
			
			for(int i=0;i<len;i++){
				for(int j=0;j<len;j++){
					System.out.println();
					System.out.print("i "+i+" j "+j +" max ");
					if(i==j)
						continue;
				max=longestCommnsuffixOrPrifix(str[i], str[j]);
					if(max>maxcomn)
					{
						maxcomn=max;
						first=i;
						second=j;
					}
				}
			}
			//System.out.println("maxcomn:"+maxcomn+" first "+first+" second "+second);
			//System.out.print("pp ");
			if(maxcomn==0){
				
				str[first]=str[first].concat(str[second]);
				//System.out.print("2 ");
				str[second]=null;
			}
			else if(maxcomn<0){
				//System.out.print("3 ");
				Set<String> set=new HashSet<String>();
				int n=str.length;
				for(int k=0;k<n;k++){
					set.add(str[k]);
				}
				set.remove(null);
				if(set.size()==1)
				{
					System.out.println(set.toString());
					break;
				}
			}
			else if(maxcomn>0){
				//System.out.print("2 ");
				int m=str[first].length();
				str[first]=str[first].substring(0,m-maxcomn).concat(str[second]);
				str[second]=null;
			}
		}
	}
	public static void main(String[] args) {
		
		String arr[]={"geeks","quiz","for"};
		superString(arr);
		System.out.println();
		String arr1[]={"catg","ctaagt","gcta","ttca","atgcatc"};
		superString(arr1);
		
	}
}
