package org.algo.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;


public class TapologicalShorting {
	private static int n;
	static Scanner sc=new Scanner(System.in);
	static class Graph{
		static int MAX=100;
		static int n;
		static ArrayList<Integer>[] adj;
		static int initial=0;
		static int visited=1;
		static int finished=2;
		static int NIL=-1;
		static int infinite=999999;
		static int[] pred;
		static int[] status;
		static int[] finishTime;
		static int[] searchTime;
		static int sorce;
		public  Graph(int n){
			Graph.n=n;
			pred=new int[n];
			status=new int[n];
			finishTime=new int[n];
			searchTime=new int[n];
			adj=new ArrayList[n];
			
			for(int i=0;i<n;i++)
				adj[i]=new ArrayList<>();
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
		public static void createGraph(int n){
			int orig=0,dest=0;
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
				}
		}
		public static void sortUtill(int k,boolean[] visited,Stack<Integer> stack){
			visited[k]=true;
			Iterator<Integer> it=adj[k].iterator();
			while(it.hasNext()){
				int i=it.next();
				
				if(visited[i]==false){
					System.out.println("  Call:"+i);
				    sortUtill(i,visited, stack);
				}
				System.out.println();
			}
			System.out.print(" Push:"+k);			
			stack.push(new Integer(k));
		}
		public static void sort(){
			Stack<Integer> stack=new Stack<>();
			boolean[] visited=new boolean[n];
			for(int i=0;i<n;i++){
				visited[i]=false;
			}
			for(int i=0;i<n;i++){
				if(visited[i]==false){
					sortUtill(i,visited, stack);
				}
			}
			System.out.println("topological short: ");
			while(!stack.isEmpty()){
				int u=stack.pop();
				System.out.print(u+" ");
			}
			System.out.println();
			
		}
		
		
	}
		
	
	public static void main(String[] args) {
		int s,v;
		System.out.println("enter number of vertices!");
		n=Integer.parseInt(sc.nextLine());
		Graph g=new Graph(n);
		Graph.createGraph(n);
		Graph.printGraph();
		Graph.sort();;
		
	}
}
