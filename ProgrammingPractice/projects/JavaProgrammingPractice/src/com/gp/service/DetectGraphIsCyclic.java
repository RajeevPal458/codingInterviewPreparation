package com.gp.service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
public class DetectGraphIsCyclic {
	
	static class Graph{
		static int v;
		
		static LinkedList<Integer>[] adjEdg;
		Graph(int V){
			this.v=V;
			adjEdg=new LinkedList[v];
			for(int i=0;i<v;i++)
				adjEdg[i]=new LinkedList<Integer>();
		}
		
		public static void addEdg(int u,int v){
			adjEdg[u].add(v);
		}
		public static boolean isCycleUtill(int v,boolean[] visited,boolean[] st){
			if(!visited[v]){
				visited[v]=true;
				st[v]=true;
				Iterator<Integer> it=adjEdg[v].iterator();
				while(it.hasNext()){
					int x=it.next();
					if(!visited[x]&&isCycleUtill(x, visited, st))
					{
						return true;
					}
					else if(st[x])
					{
						return true;
					}
				}
			}
			st[v]=false;
			return false;
		}
		public static boolean isCycle(){
			boolean[] visited=new boolean[v];
			boolean[] st=new boolean[v];
			for(int i=0;i<v;i++){
				visited[i]=false;
				st[i]=false;
			}
			for(int i=0;i<v;i++)
			{
				if(isCycleUtill(i,visited,st))
					return true;
			}
			return false;
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
		g.addEdg(1, 5);
		if(g.isCycle())
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
