package com.bt.string.mix;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class TapologicalSorting {

		static class Graph{
		static int v;
		static LinkedList<Integer>[] adjEdg;
		Graph(int V){
			v=V;
			adjEdg=new LinkedList[v];
			for(int i=0;i<v;i++)
				adjEdg[i]=new LinkedList<Integer>();
		}
		
		public static void addEdg(int u,int v){
			adjEdg[u].add(v);
		}
		public static void sortUtill(int k,boolean[] visited,Stack<Integer> stack){
				Integer i;
				visited[k]=true;
				Iterator<Integer> it=adjEdg[k].iterator();
				while(it.hasNext()){
					i=it.next();
					if(visited[i]==false)
					sortUtill(i, visited, stack);
				}
				stack.push(k);
		}
		public static void sort(){
			Stack<Integer> stack=new Stack<>();
			boolean[] visited=new boolean[v];
			for(int i=0;i<v;i++){
				visited[i]=false;
			}
			for(int i=0;i<v;i++){
				if(visited[i]==false){
					sortUtill(i, visited, stack);
				}
			}
			System.out.println();
			while(!stack.isEmpty())
			System.out.print(stack.pop()+" ");
		}
	}
	public static void main(String[] args) {
		
		Graph g=new Graph(6);
		g.addEdg(5, 3);
		g.addEdg(5, 0);
		g.addEdg(3,2);
		g.addEdg(2,1);
		g.addEdg(4,0);
		g.addEdg(4,1);
		g.sort();
	}
}
