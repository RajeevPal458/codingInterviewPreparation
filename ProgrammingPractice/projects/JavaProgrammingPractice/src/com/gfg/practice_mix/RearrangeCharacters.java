package com.gfg.practice_mix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class RearrangeCharacters {
	private static final int max=26;
	private static int[] ch;
	public RearrangeCharacters(){
		ch=new int[max];
		Arrays.fill(ch,0);
	}
	static class key {
		char c;
		int freq;
		key(char c,int freq){
			this.c=c;
			this.freq=freq;
		}
		@Override
		public String toString() {
			return "key [c=" + c + ", freq=" + freq + "]";
		}
		
	}
	/*static class myComparator implements Comparator<key>{

		@Override
		public int compare(key o1, key o2) {
			if(o1.freq>o1.freq)
				return -1;
			else if(o1.freq<o1.freq)
				return 1;
			else
				return 0;
		}

	}*/
	static String result=new String();
	public static void rearrange(char[] arr){
		int n=arr.length;
		if(n==0) return;
		for(int i=0;i<n;i++){
			ch[arr[i]-'a']++;
		}
		Queue<key> que=new PriorityQueue<>(15,new Comparator<key>(){

			@Override
			public int compare(key k1, key k2) {
				if(k1.freq<k2.freq) return 1;
				else if(k1.freq>k2.freq) return -1;
				else return 0;
			}});
		for(int i=0;i<max;i++){
			if(ch[i]>0){
				que.add(new key((char)(i+'a'),ch[i]));
			}
		}
		
		key prev=new key(' ',0);
		while(!que.isEmpty()){
			key k=que.poll();
			System.out.print(k.c+" "+k.freq+" ");
			result=result.concat(k.c+"");
			if(prev.freq>0){
				que.add(prev);
			}
			k.freq--;
			prev=k;
		}
		System.out.println();
		if(n!=result.length())
			System.out.println("Rearrange of Characters not possible!");
		else{
			System.out.println("Rearrange of Characters possible!");
			System.out.println(result.toString());
		}
	}
	public static void main(String[] args) {
		new RearrangeCharacters();
		String s="geeksforgeeks";
		rearrange(s.toCharArray());
		/*System.out.println();
		new RearrangeCharacters();
		result=new String();
		String s1="bbbabaaacd";
		rearrange(s1.toCharArray());*/
	}
}
