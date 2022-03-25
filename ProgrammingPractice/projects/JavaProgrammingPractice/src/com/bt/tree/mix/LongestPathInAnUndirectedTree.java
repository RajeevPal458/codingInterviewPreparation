package com.bt.tree.mix;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class LongestPathInAnUndirectedTree {

	static Scanner sc=new Scanner(System.in);
	static class Graph{
		static int n;
		static ArrayList<Integer>[] adj;
		static int initial=0;
		static int visited=1;
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
		public static int longestPathLengthUtill(int node){
			
			status[node]=visited;
			int count=0, max=0;
			Iterator<Integer> it=adj[node].listIterator();
			while(it.hasNext()){
				int v=it.next();
				if(status[v]==initial){
					
					count=longestPathLengthUtill(v);
					max=Math.max(max, count);
				}
			}
			return 1+max;
		}
		//second concept............
		public static void longestPathLengthUtillSecondConcept(int node,int count,MaxCount max,To t){
			
			status[node]=visited;
			int countAdj=0;
			Iterator<Integer> it=adj[node].listIterator();
			while(it.hasNext()){
				int v=it.next();
				if(status[v]==initial){
					countAdj++;
					longestPathLengthUtillSecondConcept(v,count+1,max,t);
				}
			}
			if(countAdj==0){
				if(max.maxCount<count){
					max.maxCount=count;
					t.end=node;
				}
				
			}
			
		}
		static class MaxCount{
			int maxCount;
		}
		static class To{
			int end;
		}
		public static void longestPathLengthSecondConcept(){
			MaxCount max=new MaxCount();
			max.maxCount=-1;
			To t=new To();
			t.end=-1;
			int start=-1,end=-1,largestPath=0;
			for(int i=0;i<n;i++){
				longestPathLengthUtillSecondConcept(i,1,max,t);
				if(largestPath<max.maxCount){
					start=i;
					end=t.end;
					largestPath=max.maxCount;
				}
			}
			System.out.println("Longest path is:"+largestPath+"  From vertex:"+start+" To"+end);
		}
		public static void longestPathLength(){
			int longestPath=-1;
			int max=0;
			for(int i=0;i<n;i++){
				
				max=longestPathLengthUtill(i);
				if(longestPath<max)
					longestPath=max;
			}
			System.out.println("Longest path:"+longestPath);
		}
		
	}
	public static void main(String[] args) {
		Graph g=new Graph(10);
	    g.addEdge(0, 1);
	    g.addEdge(1, 2);
	    g.addEdge(2, 3);
	    g.addEdge(2, 9);
	    g.addEdge(2, 4);
	    g.addEdge(4, 5);
	    g.addEdge(1, 6);
	    g.addEdge(6, 7);
	    g.addEdge(6, 8);
	 
	    g.printGraph();
	   // g.longestPathLength();
	    g.longestPathLengthSecondConcept();
	}
}
