package com.gfg.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class CheckHamiltonianPathInGraph {
	static Scanner sc=new Scanner(System.in);

	static class Graph{
		static int n;
		static ArrayList<Integer>[] adj;
		public  Graph(int n){
			Graph.n=n;
			adj=new ArrayList[n];
			for(int i=0;i<n;i++)
				adj[i]=new ArrayList<>();
		}
		public static void addEdge(int u,int v){
			adj[v].add(u);
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
		public static void createGraph(int n,int Edges){
			int orig=0,dest=0;
			int i=0;
				System.out.println("Edge :"+i+++" please inter all Edges by separate one space( ) in pairs of origin & destination)");
				String[] arr1=sc.nextLine().split(" ");
				int ind=0;
				for(int k=0;k<Edges;k++){
						orig=Integer.parseInt(arr1[ind++]);
						dest=Integer.parseInt(arr1[ind++]);
						if(orig<0||dest<0)
						{
							System.out.println("its input for break !");
							break;
						}	
					Graph.addEdge(orig, dest);
				}
		}
		static int NIL=-1;
		static int initial=0;
		static int visited=1;
		static int[] path;
		static int pathIndex;
		static int[] status;
		public static void reInitialize(int n){
			path=new int[n];
			status=new int[n];
			pathIndex=0;
			for(int i=0;i<n;i++){
				path[i]=NIL;
				status[i]=initial;
			}
		} 
		private static void dfs(int s) {
			status[s]=visited;
			System.out.println(pathIndex+" s:"+s);
			
			if((pathIndex>0)&&((pathIndex<n))&&adj[path[pathIndex-1]].contains(new Integer(s)))
			{
				path[pathIndex]=s;
				pathIndex++;
			}
			if(pathIndex==0){
				path[pathIndex]=s;
				pathIndex++;
			}
			ArrayList<Integer> ad=adj[s];
				Iterator<Integer> it=ad.listIterator();
				while(it.hasNext()){
					int v=it.next();
					if((status[v]==initial)){
						dfs(v);
					}
				}
		}
		public static boolean isPathContainsAllVertices(int[] path,int n){
			int[] arr=new int[n];
			for(int i=0;i<n;i++){
				arr[i]=path[i];
			}
			Arrays.sort(arr);
			for(int i=0;i<n;i++){
				if(arr[i]!=i)
					return false;
			}
			return true;
		}
		public static void isHamiltonian(int n){
			int s;
			for(s=0;s<n;s++){
				reInitialize(n);
				dfs(s);
				if(isPathContainsAllVertices(path,n)){
					System.out.println("Graph Contains Hamiltonian path!");
					System.out.println(Arrays.toString(path));;
					break;
				}
				System.out.println(Arrays.toString(path));;
			}
			if(s==n)
				System.out.println("Graph does not Contains Hamiltonian path!");
		}
	}
	public static void main(String[] args) {
		System.out.println("enter number of vertices & Edges separated by spaces!");
		String[] ve=sc.nextLine().split(" ");
		int n=Integer.parseInt(ve[0]);
		int edges=Integer.parseInt(ve[1]);
		Graph g=new Graph(n);
		Graph.createGraph(n,edges);
		Graph.printGraph();
		Graph.isHamiltonian(n);
	}
}
