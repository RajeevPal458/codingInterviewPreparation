package com.bt.stringarr.mix;
import java.util.Scanner;

public class SpecialKeyboardProblems {
	
//multiplier*f(N-3)
	public int printAs(int N){
		if(N<=6)
			return N;
		int max=0;
		for(int i=N-3;i>=0;i--){
			int As=(N-i-1)*printAs(i);
			System.out.println(N-i-1+"  "+i);
			if(max<As)
				max=As;
		}
		return max;
	}
	public static void main(String[] args) {
		//keys A ctrlA,ctrlC,ctrlV.........enter  value of N and maximum number of A's
		System.out.println("enter number N:");
		Scanner sc=new Scanner(System.in);
		int N=Integer.parseInt(sc.nextLine());
		SpecialKeyboardProblems skp=new SpecialKeyboardProblems();
		System.out.println("Max Number of As:"+skp.printAs(N));
		
	}
}
