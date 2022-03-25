package com.gp.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class EulerianPathForUndirectedGraph {

	static Scanner sc=new Scanner(System.in);
	static class Graph{
		static int n;													
		static ArrayList<Integer>[] adj;
		static int initial=0;
		static int visited=2;
		static int[] status;
		public  Graph(int n){
			Graph.n=n;
			status=new int[n];
			adj=new ArrayList[n];
			for(int i=0;i<n;i++)
				adj[i]=new ArrayList<>();
		}
		public static void addEdge(int u,int v){
			adj[u].add(v);
			adj[v].add(u);
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
		public static void createGraph(int n){
			/*int orig=0,dest=0;
			int i=0;
				System.out.println("Edge :"+i+++" please inter all Edges by separate one space( )within three non negative number separated by comma(,) in sequences origin,destination)");
				String str1=sc.nextLine();
				String[] arr1=str1.split(" ");
				for(int k=0;k<arr1.length;k++){
					
					String str=arr1[k];
					String[] arr=str.split(",");
					if(arr.length==2){
						orig=Integer.parseInt(arr[0]);
						dest=Integer.parseInt(arr[1]);
						if(orig<0||dest<0)
						{
							System.out.println("its input for break !");
							break;
						}	
					}
					else{System.out.println("Wrong Input!  \nplease inter two non negative number separated by comma(,) in sequences ");}
					Graph.addEdge(orig, dest);
				}*/
			Graph g2=new Graph(n);
			/*Graph.addEdge(1, 0);
			Graph.addEdge(0, 2);
			Graph.addEdge(2, 1);
			Graph.addEdge(0, 3);
			Graph.addEdge(3, 4);*/
			g2.addEdge(1, 0);
		    g2.addEdge(0, 2);
		    g2.addEdge(2, 1);
		    g2.addEdge(0, 3);
		    g2.addEdge(3, 4);
		    g2.addEdge(4, 0);
		}
		
		
		private static void dfsUtil(int s) {
			
			status[s]=visited;
				ArrayList<Integer> ad=adj[s];
					Iterator<Integer> it=ad.listIterator();
					while(it.hasNext()){
						int v=it.next();
						if(status[v]==initial){
							dfsUtil(v);
						}
					}
		}
		private static boolean isConnected(int n) {
		// TODO Auto-generated method stub
			for(int v=0;v<n;v++){
				status[v]=initial;
			}
			int v;
			for(v=0;v<n;v++){
				if(adj[v].size()!=0)
					break;
			}
			if(v==n)
				return true;
			
			dfsUtil(v);
			for(v=0;v<n;v++){
				if((status[v]==initial)&&(adj[v].size()>0))
					return false;
			}
			return true;
		}
		
		private static int isEulerian(int n){
			
			if(isConnected(n)==false)
				return 0;
			int count=0;
			for(int v=0;v<n;v++){
				if((adj[v].size()%2)!=0)
					count++;
			}
			
			if (count > 2)
		        return 0;
			
			return (count==2)?1:2;
		} 
		private static void test(int n){
			
			int val=isEulerian(n);
			if(val==0){
				System.out.println("Graph is not Eulerian!");
			}
			else if(val==1){
				System.out.println("Graph has Eulerian path not cycle");
			}
			else{
				System.out.println("Graph is complete Eulerian!");
			}
		}
	}
	public static void main(String[] args) {
		int s,v;
		int n=5;
		Graph.createGraph(n);
		Graph.printGraph();
		Graph.test(n);
	}
}
