package com.gfg.practice_mix;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class LargestPrimeFactor {
	static Queue<Integer> ts=new PriorityQueue(10,new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			if(o1>o2) return 1;
			else if(o1<o2) return -1;
			else return 0;
		}
	});
	public static void PrimeFctors(int num){
		int i=2;
		int count=0;
		while(num>1){
			if(num%i==0)
				ts.add(i);
			while(num!=0&&num%i==0){
				num=num/i;
			}
			i++;
		}
		System.out.println(ts.toString());
	}
	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		
		System.out.println("Enter possitive number for largest prime factor ");
		int num= Integer.parseInt(sc.nextLine());
		PrimeFctors(num);
		
		
	}
}
