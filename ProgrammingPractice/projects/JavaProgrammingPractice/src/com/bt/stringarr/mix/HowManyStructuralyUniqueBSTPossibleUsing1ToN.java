package com.bt.stringarr.mix;
import java.util.Scanner;

public class HowManyStructuralyUniqueBSTPossibleUsing1ToN {
	
	public int uniquBSTs(int N){
		if(N<0)
			return 0;
		if(N==1||N==0)
			return 1;
		int max=0;
		for(int i=1;i<=N;i++){
			 max+=uniquBSTs(i-1)*uniquBSTs(N-i);
		}
		return max;
	}
	public static void main(String[] args) {
		System.out.println("enter number N:");
		Scanner sc=new Scanner(System.in);
		int N=Integer.parseInt(sc.nextLine());
		HowManyStructuralyUniqueBSTPossibleUsing1ToN skp=new HowManyStructuralyUniqueBSTPossibleUsing1ToN();
		System.out.println("Max Number of As:"+skp.uniquBSTs(N));
		
	}
}
