package com.gp.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.gp.service.DijkstraAlgorithm.Edge;
import com.gp.service.DijkstraAlgorithm.Graph;

public class PrimsAlgorithm {

static Scanner sc=new Scanner(System.in);
	
	static class Edge{
		int u,v;
	}
	
	static class Graph
	{
		static boolean perm=true,temp=false;
		static int NIL=-1,infine=9999999;
		static int n;
		static int[] pred;
		static int[] pathlen;
		static boolean[] status;
		static Edge[] tree;
		static int[][] adj;
		Graph(int n){
			pred=new int[n];
			pathlen=new int[n];
			status=new boolean[n];
			this.n=n;
			adj=new int[n][n];
			tree=new Edge[n+1];
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
		
		public static void primsAlgorithm(int source){
			int s,count=0;
			for(int i=0;i<n;i++){
				pred[i]=NIL;
				pathlen[i]=infine;
				status[i]=temp;
			}
			pathlen[source]=0;
			while(true){
				s=minPathLen();
				System.out.println("curr "+s);
				if(s==-1){
					if(count==n-1)
					{
						System.out.println("successfully completed!");
						break;
					}
					else{
						System.out.println("it might seems graphis disconnected!");
						break;
					}
				}
				status[s]=perm;
				if(s!=source){
					count++;
					System.out.println("count :"+count);
					tree[count].u=pred[s];
					tree[count].v=s;
				}
				for(int i=0;i<n;i++){
					if(adj[s][i]!=0&& !status[i]){
						System.out.println("adj[s][i] "+adj[s][i]+"  !status[i] "+!status[i]);
						if(pathlen[i]>adj[s][i]){
							pathlen[i]=adj[s][i];
							pred[i]=s;
						}
					}
				}
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
		public static int minPathLen(){
			int min=infine,k=NIL;
			for(int i=0;i<n;i++){
				if(!status[i]&&pathlen[i]<min){
					min=pathlen[i];
					k=i;
				}
			}
			return k;
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
		Graph.primsAlgorithm(s);
		Graph.printTree();
		
	}
}
	
	
