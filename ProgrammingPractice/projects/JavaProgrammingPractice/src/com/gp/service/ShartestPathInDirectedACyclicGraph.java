package com.gp.service;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class ShartestPathInDirectedACyclicGraph 
{
		
	static class Edge
	{
			private int v;
			private int w;
			Edge(int V,int W){
				this.v=V;
				this.w=W;
			}
			public int getV(){return this.v;}
			public int getW(){return this.w;}
	}	
	static class Graph
	{
		private static int V;
		private static LinkedList<Edge>[] adjEdg;
		
		Graph(int v){
			this.V=v;
			adjEdg=new LinkedList[V];
			for(int i=0;i<V;i++)
				adjEdg[i]=new LinkedList<Edge>();
		}
		
		public static void addEdg(int u,int v,int w){
			Edge e=new Edge(v,w);
			adjEdg[u].add(e);
		}
		public static void sortUtill(int k,boolean[] visited,Stack<Integer> stack){
			visited[k]=true;
			Iterator<Edge> it=adjEdg[k].iterator();
			while(it.hasNext()){
				Edge i=it.next();
				
				if(visited[i.getV()]==false)
				sortUtill(i.getV(),visited, stack);
			}
			stack.push(new Integer(k));
		}
		public static void sort(Graph g,int s){
			Stack<Integer> stack=new Stack<>();
			boolean[] visited=new boolean[V];
			for(int i=0;i<V;i++){
				visited[i]=false;
			}
			for(int i=0;i<V;i++){
				if(visited[i]==false){
					sortUtill(i,visited, stack);
				}
			}
			int[] dist=new int[V];
			for(int i=0;i<V;i++)
				dist[i]=99999;
			dist[s]=0;
			while(!stack.isEmpty()){
				int u=stack.pop();
				if(dist[u]!=99999){
					Iterator<Edge> it=adjEdg[u].iterator();
					while(it.hasNext()){
						Edge e=it.next();
						if(dist[u]+e.getW()<dist[e.getV()])
							dist[e.getV()]=dist[u]+e.getW();
					}
				}
			}
			for(int i=0;i<V;i++){
				if(dist[i]==99999)
					System.out.print("99999 ");
				else
					System.out.print(dist[i]+" ");
			}
			
		}
		
		
	
	}
	public static void main(String[] args) {
		Graph g=new Graph(6);
		g.addEdg(0, 1, 5);
	    g.addEdg(0, 2, 3);
	    g.addEdg(1, 3, 6);
	    g.addEdg(1, 2, 2);
	    g.addEdg(2, 4, 4);
	    g.addEdg(2, 5, 2);
	    g.addEdg(2, 3, 7);
	    g.addEdg(3, 4, -1);
	    g.addEdg(4, 5, -2);
	 
		int s=1;
		System.out.println("Following are shortest distences from sources "+s);
		g.sort(g,s);
	}
}
