package com.gfg.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class FindAllPossibleSubsets {
	static Set<String> set;
	public FindAllPossibleSubsets(){
		set=new TreeSet<String>();
	}
	public static void printSet(Set<String> set){
		Iterator<String> it=set.iterator();
		System.out.println("[");
		while(it.hasNext()){
			String st=it.next();
			System.out.println(Arrays.toString(st.toCharArray()));
		}
		System.out.println("]");
	}
	public static void printData(int[] data,int n){
		StringBuffer sb=new StringBuffer();
		if(n==0)
			set.add("");
		else
		{
			for(int i=0;i<n;i++){
				sb.append(data[i]);
			}
			set.add(sb.toString());
		}
	}
	public static void printDataSet(int[] data,int n){
		System.out.print("[");
			for(int i=0;i<n;i++){
				System.out.print(data[i]+" ");
			}
			System.out.print("]");
			System.out.println();
	}
	public static void subSetsUtil(int[] arr,int[] data,int start,int index,int len){
		printDataSet(data,index);
		for(int i=start;i<len&&index<len;i++){
			data[index]=arr[i];
			subSetsUtil(arr,data,i+1,index+1,len);
			if((i<len-1)&&(arr[i]==arr[i+1])){
				i++;
			}
		}
		
	}
	public static void subSets(int[] arr,int len){
		int[] data=new int[len];
		subSetsUtil(arr,data,0,0,len);
	}
	public static void main(String[] args) {
		int[] arr={1,2,2};
		int n=arr.length;
		FindAllPossibleSubsets sb=new FindAllPossibleSubsets();
		System.out.println("[");
			subSets(arr,n);
		System.out.print("]");
	}
}
