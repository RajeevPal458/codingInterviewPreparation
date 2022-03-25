package com.gfg.practice_mix;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

import com.gfg.practice_mix.TapologicalShorting.Graph;

public class FinedOrderOfCharacterUsingDictionaryOfWord {
	
	static Scanner sc=new Scanner(System.in);
	static class Graph{
		static int MAX=100;
		static int initial=0;
		static int visited=2;
		static int n;
		static ArrayList<Integer>[] adj;
		static int NIL=-1;
		static int infinite=999999;
		static int[] toposhort;
		static int[] status;
		public  Graph(int n){
			
			toposhort=new int[n];
			Graph.n=n;
			status=new int[n];
			adj=new ArrayList[n];
			for(int i=0;i<n;i++){
				adj[i]=new ArrayList<>();
				status[i]=initial;
			}
		}
		public static void addEdge(int u,int v){
			adj[u].add(v);
		}
		public static void printGraph(){
			
			for(int i=0;i<adj.length;i++){
				ArrayList<Integer> list=adj[i];
				Iterator<Integer> it=list.listIterator();
				while(it.hasNext()){
					Integer v=it.next();
					System.out.println("Edge:-("+i+" , "+v+")");
				}
			}
		}
		public static void tapologicalShortUtil(int u,Stack<Integer> stack){
			status[u]=visited;
			Iterator<Integer> it=adj[u].listIterator();
			while(it.hasNext()){
				Integer v=it.next();
				if(status[v]==initial)
					tapologicalShortUtil(v, stack);
			}
			stack.push(new Integer(u));
			
		}
		public static void tapologicalShort(){
			
			Stack<Integer> stack=new Stack<>();
			
			for(int i=0;i<n;i++){
				if(status[i]==initial){
					tapologicalShortUtil(i, stack);
				}
			}
			
			System.out.println("shorted Order Of character in dictionary");
			
			while(!stack.isEmpty()){
				System.out.print((char)(stack.pop()+'a')+" ");
			}
		}
	}
	
	public static void main(String[] args) {
		String[] words={"baa","abcd","abca","cab","cad"};
		new Graph(4);
		int len=words.length;
		String word1=null,word2=null;
		for(int i=0;i<len-1;i++){
			word1=words[i];
			word2=words[i+1];
			
			for(int j=0;j<Math.min(word1.length(),word2.length());j++){
				
				if(word1.charAt(j)!=word2.charAt(j)){
					Graph.addEdge(word1.charAt(j)-'a',word2.charAt(j)-'a');
					break;
				}
			}
		}
		Graph.printGraph();
		Graph.tapologicalShort();
	}	
}










