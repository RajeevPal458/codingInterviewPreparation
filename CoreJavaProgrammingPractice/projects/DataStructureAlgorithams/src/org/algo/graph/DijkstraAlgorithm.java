package org.algo.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class DijkstraAlgorithm {
	static Scanner sc=new Scanner(System.in);
	
	static class Edge{
		int dest;
		int weight;
		Edge(int v,int w){
			this.dest=v;
			this.weight=w;
		}
	}
	
	static class Graph{
		static boolean perm=true,temp=false;
		static int NIL=-1;
		static int infite=9999999; 
		static boolean[] status;;
		static int[] pred;
		static int[] pathlen;
		static ArrayList<Edge> adj[];
		static int n;
		
		Graph(int n){
			this.n=n;
			this.status=new boolean[n];
			this.pred=new int[n];
			this.pathlen=new int[n];
			this.adj=new ArrayList[n];
			for(int i=0;i<n;i++)
				adj[i]=new ArrayList<>();
		}
		public static void addEdge(int orig,int dest,int weight){
			Edge e=new Edge(dest,weight);
			adj[orig].add(e);
		}
		
		public static void printGraph(){
			
			for(int i=0;i<adj.length;i++){
				ArrayList<Edge> list=adj[i];
				Iterator<Edge> it=list.listIterator();
				while(it.hasNext()){
					Edge e=it.next();
					System.out.println("Edge:-("+i+" , "+e.dest+")  ->"+e.weight);
				}
			}
		}
		public static void createGraph(int n){
			int orig=0,dest=0,weight=0;
			int i=0;
				System.out.println("Edge :"+i+++" please inter all Edges by separate one space( )within three non negative number separated by comma(,) in sequences origin,destination,weight");
				String str1=sc.nextLine();
				String[] arr1=str1.split(" ");
				for(int k=0;k<arr1.length;k++){
					
					String str=arr1[k];
					String[] arr=str.split(",");
					if(arr.length==3){
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
		
		public static void dijkstra(int source){
			int cur;
			System.out.println(n+" ststuslen:"+status.length);
			
			for(int i=0;i<n;i++){
				status[i]=temp;
				pred[i]=NIL;
				pathlen[i]=infite;
			}
			pathlen[source]=0;
			while (true) {
				cur=minPathLen();
			System.out.println("cur:"+cur);
				if(cur==NIL){
					return ;
				}
				status[cur]=perm;
				
				ArrayList<Edge> list=adj[cur];
				Iterator<Edge> it=list.listIterator();
				while(it.hasNext()){
					Edge e=it.next();
			System.out.println("4");
					if(!status[e.dest]){
						if(pathlen[cur]+e.weight<pathlen[e.dest]){
							pred[e.dest]=cur;
							pathlen[e.dest]=pathlen[cur]+e.weight;
						}
					}
				}
			}
		}
		public static void shortestPath(int source,int dest){
			System.out.println("shortest path from source "+source+" to dest "+dest);
			int i=dest;
			int count=0;
			while(true){
				System.out.print(i);
				if(i!=source)
					System.out.print(" <--> ");
				int pre=pred[i];
				if(pre==NIL)
				{
					System.out.println();
					System.out.println("sucessfully find complete path");
					break;
				}
				else
					i=pre;
				
				count++;
				if(count>n)
					break;
			}
		}
		public static int minPathLen(){
			int min=infite,k=NIL;
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
		
		Graph.dijkstra(s);
		
		while(true){
			System.out.println("enter destination vertex for shortest path from given source to break enter -1 !");
			int dest=Integer.parseInt(sc.nextLine());
			
			if(dest>=n||dest<0)
				break;
			else if(s==dest)
				System.out.println("source and destination are same!");
			else if(g.pathlen[dest]==g.infite)
				System.out.println("there is no path for this dest it might apear disconnected graph!");
			else
				Graph.shortestPath(s, dest);
			
		}
	}
}
