package com.gfg.microsoft;
public class HowToTurnOffAParticularBitInANumber {

	public static int turnOfPerticulerBit(int num,int n){
		
		if( n<=0)
			return num;
		
		return num&~(1<<(n-1));
	}
	public static void main(String[] args) {
		System.out.println(turnOfPerticulerBit(15, 1));
		System.out.println(turnOfPerticulerBit(15, 2));
		System.out.println(turnOfPerticulerBit(15, 5));
	}
}
