package com.gp.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import com.gp.service.PrimsAlgorithm.Edge;
import com.gp.service.PrimsAlgorithm.Graph;

public class KrushkalsAlgorithm {

static Scanner sc=new Scanner(System.in);
	
	static class Edge{
		int u,v,w;
	}
	
	static class Graph
	{
		static int NIL=-1;
		static int n;
		static int[] pred;
		static Edge[] tree;
		static int[][] adj;
		static List<Edge> list;
		Graph(int n){
			pred=new int[n];
			this.n=n;
			adj=new int[n][n];
			tree=new Edge[n+1];
			list=new ArrayList<>();
			for(int i=0;i<tree.length;i++)
				tree[i]=new Edge();
		}
		
		public static void printGraph(){
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					System.out.print(adj[i][j]+" ");
				}
				System.out.println();
			}
		}
		
		public static void addEdge(int u,int v,int w){
			adj[u][v]=w;
			adj[v][u]=w;
			Edge e=new Edge();
			e.u=u;
			e.v=v;
			e.w=w;
			int i=0;
			if(!list.isEmpty()){
				for(i=0;i<list.size();i++){
					if(w<list.get(i).w)
						break;
				}
				list.add(i,e);
			}
			else{
				list.add(e);
			}
		}
		public static void createGraph(int n){
			int orig=0,dest=0,weight=0;
			int i=0;
				System.out.println("Edge :"+i+++" please inter all Edges by separate one space( )within three non negative number separated by comma(,) in sequences origin,destination,weight");
				String str1=sc.nextLine();
				String[] arr1=str1.split(" ");
				for(int k=0;k<arr1.length;k++)
				{
					
					String str=arr1[k];
					String[] arr=str.split(",");
					if(arr.length==3)
					{
						orig=Integer.parseInt(arr[0]);
						dest=Integer.parseInt(arr[1]);
						weight=Integer.parseInt(arr[2]);
						if(orig<0||dest<0||weight<0)
						{
							System.out.println("its input for break !");
							break;
						}	
					}
					else{System.out.println("Wrong Input!  \nplease inter three non negative number separated by comma(,) in sequences ");}
					Graph.addEdge(orig, dest, weight);
				}
		}
		
		public static void krushkalAlgorithm(int source){
			int count=0;
			int u,v,u_=0,v_=0;
			for(int i=0;i<n;i++)
				pred[i]=NIL;
			while(!list.isEmpty()&&count<n-1){
				Edge e=list.get(0);list.remove(0);
				u=e.u;
				v=e.v;
				while(v!=NIL){
					v_=v;
					v=pred[v];
				}
				while(u!=NIL){
					u_=u;
					u=pred[u];
				}
				if(v_!=u_){
					count++;
					tree[count].u=e.u;
					tree[count].v=e.v;
					tree[count].w=e.w;
					pred[v_]=u_;
							
				}
			}
			if(count<n-1){
				System.out.println("graph is not connected spaining tree not possible!");
			}
		}
		public static void printTree(){
			int wt=0;
			System.out.println("Edges to be included in Min Spanning Tree");
			for(int i=1;i<n;i++){
				System.out.print(tree[i].u+" -> "+tree[i].v);
				System.out.println();
				wt+=adj[tree[i].u][tree[i].v];
			}
			System.out.println();
			System.out.println("weight of spanning tree is:"+wt);
		}
		
	}
	public static void main(String[] args) {
		int s,v;
		System.out.println("enter number of vertices!");
		int n=Integer.parseInt(sc.nextLine());
		Graph g=new Graph(n);
		Graph.createGraph(n);
		Graph.printGraph();
		System.out.println("enter source vertex");
		s=Integer.parseInt(sc.nextLine());
		Graph.krushkalAlgorithm(s);
		Graph.printTree();
		
	}
}
