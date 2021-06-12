package com.gfg.microsoft;

public class SwapTwoNibblesInAByte {

	public static void swapNibbles(int n){
		System.out.println(((n&0x0F)<<4)|((n&0xF0)>>4));
	}
	public static void main(String[] args) {
		swapNibbles(100);
	}
}
