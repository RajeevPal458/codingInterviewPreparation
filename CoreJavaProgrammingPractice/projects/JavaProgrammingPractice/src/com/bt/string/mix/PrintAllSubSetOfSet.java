package com.bt.string.mix;

import javax.sound.midi.SysexMessage;

public class PrintAllSubSetOfSet {

	public static void allSubset(int[]  arr,int n){
		for(int i=0;i<1<<n;i++){
			System.out.print("{ ");
			for(int j=0;j<n;j++){
				if(( i & (1 << j) )>0)
					System.out.print(arr[j]+" ");
			}
			if(i<(1<<n)-1)
				System.out.println("}");
		}		
	}
	public static void main(String[] args){
		int arr[]={1,2,3,4};
		allSubset(arr,arr.length);
		
		System.out.println("Left Shift:"+(1<<1));
	}
}
