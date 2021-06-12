package com.bt.arrTree.mix;

import java.util.Arrays;

public class SegmentTreeWithLazyPrapogation {
	static int MAX=10;
	static boolean lazy[]=new boolean[MAX];
	static int st[]=new int[MAX];
	public static void toggle (int ss,int se,int qs,int qe,int si){
		if(ss>se||ss>qe||se<qs)
			return;
		if(lazy[si]){
			st[si]=(se-ss+1-st[si]);
			System.out.print(" (se-ss+1)-st[si] "+"("+se+"-"+ss+"+1+)*"+st[si]);
			lazy[si]=false;
			
			if(ss<se){
				lazy[2*si]=!lazy[2*si];
				lazy[2*si+1]=!lazy[2*si+1];
			}
		}
		if(ss>=qs&&se<=qe){
			st[si]=(se-ss+1-st[si]);
			if(ss<se){
				lazy[2*si]=!lazy[2*si];
				lazy[2*si+1]=!lazy[2*si+1];
				System.out.println("LeftLazy:"+lazy[2*si]+"RiLazy:"+lazy[2*si+1]);
			}
			
			return;
		}
		int mid=(ss+se)/2;
		toggle (ss,mid,qs,qe,2*si);
		toggle (mid+1,se,qs,qe,2*si+1);
		if(ss<se)
		{
			System.out.println("Left:"+st[2*si]+ " Right:"+st[2*si+1]);
			st[si]=st[2*si]+st[2*si+1];
		}
	}
	public static int countQuery(int ss, int se, int qs, int qe, int si){
		
		if(ss>se||ss>qe||se<qs)
			return 0;
		
		if(lazy[si]){
			st[si]=(se-ss+1-st[si]);
			lazy[si]=false;
			
			if(ss<se){
				lazy[2*si]=!lazy[2*si];
				lazy[2*si+1]=!lazy[2*si+1];
			}
		}
		if(ss>=qs&&se<=qe)
		return st[si];
		
		int mid=(ss+se)/2;
		return countQuery(ss,mid,qs,qe, 2*si)+countQuery(mid+1, se, qs, qe, 2*si+1);
		
	}
	public static void main(String[] args) {
		int n=5;
		Arrays.fill(lazy,false);
		Arrays.fill(st,0);
		toggle(0, n-1, 1, 2, 1);
		toggle(0, n-1, 2, 4, 1);
		System.out.println(Arrays.toString(st));
		System.out.println(countQuery(0, n-1, 2, 3,1) );
		toggle(0, n-1, 2, 4, 1);
		System.out.println(countQuery(0, n-1, 1, 4,1) );
	}
}
