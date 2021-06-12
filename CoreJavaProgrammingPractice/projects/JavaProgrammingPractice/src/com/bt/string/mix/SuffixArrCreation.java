package com.bt.string.mix;

import java.util.Arrays;
import java.util.Comparator;

public class SuffixArrCreation {

	 class Suffix implements Comparable<Suffix>{
		int ind;
		String str;
		public Suffix() {
			super();
		}

		public Suffix(int ind,String str){
			this.ind=ind;
			this.str=str;
		}
		
		@Override
		public int compareTo(Suffix o) {
			return this.ind-o.ind;
		}
		class MyComparator implements Comparator<Suffix>{

			@Override
			public int compare(Suffix o1, Suffix o2) {
				return o1.str.compareTo(o2.str);
			}
		
		}
		@Override
		public String toString() {
			return "Suffix [ind=" + ind + ", str=" + str + "]";
		}
	}

	public  void creatSA(String text,Suffix[] arr,int len){

		for(int i=0;i<len;i++){
			arr[i]=new Suffix(i,text.substring(i));
		}
		Arrays.sort(arr);
		
		System.out.println(Arrays.toString(arr));
		
		Suffix sf=new Suffix();
		Arrays.sort(arr,sf.new MyComparator());
		System.out.println(Arrays.toString(arr));
		System.out.println();
		
		
	}
	public static void binarySearch(Suffix[] arr,String pat,int start,int end){
		int m=pat.length();
		int l=start,r=end;
		if(l>r)
			return;
		else{
			
			int mid=(l+r)/2;
			int res=arr[mid].str.compareTo(pat);
			//System.out.println("Mid"+mid+" Res "+res);
			if(res>0)
			{
				if(arr[mid].str.startsWith(pat))
					System.out.println("Found at Index: "+arr[mid].ind);
				binarySearch(arr,pat,l,mid-1);
			}
			else if(res<0)
			{
				if(arr[mid].str.startsWith(pat))
					System.out.println("Found at Index: "+arr[mid].ind);
				binarySearch(arr,pat,mid+1,r);
			}
			else
			{
				System.out.println("Found at Index: "+arr[mid].ind);
				return;
			}
			
			}
	}
	public static void main(String[] args) {
		SuffixArrCreation sc=new SuffixArrCreation();
		String text="abacbaababacababacaba";
		String pat="ababaca";
		Suffix arr[]=new Suffix[text.length()];
		sc.creatSA(text,arr,text.length());
		binarySearch(arr, pat,0,arr.length-1);
	}
}
