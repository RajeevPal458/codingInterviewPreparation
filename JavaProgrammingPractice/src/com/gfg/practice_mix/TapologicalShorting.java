package com.gfg.practice_mix;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class TapologicalShorting {

	static Scanner sc=new Scanner(System.in);
	static class Graph{
		static int MAX=100;
		static int initial=0;
		static int waiting=1;
		static int visited=2;
		static int n;
		static ArrayList<Integer>[] adj;
		static int NIL=-1;
		static int infinite=999999;
		static int[] toposhort;
		static int[] indeg;
		static int[] status;
		public  Graph(int n){
			
			toposhort=new int[n];
			indeg=new int[n];
			Graph.n=n;
			status=new int[n];
			adj=new ArrayList[n];
			for(int i=0;i<n;i++){
				adj[i]=new ArrayList<>();
				status[i]=initial;
			}
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
		static int front,rear;
		static int[] queue;
		static void initializeQueue(){
			front=-1;
			rear=-1;
			queue=new int[MAX];
			for(int i=0;i<MAX;i++)
				queue[i]=0;
		}
		static void inQue(int val){
			if(rear==MAX){
				System.out.println("queue is ovrflow!");
				return;
			}
			if(front==-1)
				front=0;
			rear+=1;
			queue[rear]=val;
		}
		static int deQueue(){
			if(front==-1||front==rear+1){
				System.out.println("Queue is underflow!");
				return -1;
			}
			int val=queue[front];
			front+=1;
			return val;
		}
		static boolean isEmpty(){
			if(rear==-1||front==rear+1)
				return true;
			else
				return false;
		}
	private static void dfsUtil() {
		
		initializeQueue();
		int indegree;
		for(int i=0;i<n;i++){
			indegree=inDegree(i);
			indeg[i]=indegree;
			System.out.println("Indegree:"+indegree);
			if(indegree==0){
				inQue(i);
			}
		}
		int V, count=0;
		
		while(!isEmpty()&&count<n){
			int source=deQueue();
			status[source]=visited;
			System.out.println("Del Source:"+source);
			toposhort[count++]=source;
			Iterator<Integer> it=adj[source].listIterator();
			while(it.hasNext()){
				V=it.next();
				if(status[V]==initial){
					indeg[V]--;
					if(indeg[V]==0)
						inQue(V);
					}
				}
				
			}
		
			if(count<n){
				System.out.println("No topological shorting order possible,graph contains cycle");
			}
			else{	
				System.out.println("Vertices in topological shorting order is !");
				for(int i=0;i<count;i++){
					System.out.print(toposhort[i]+" ");	
				}
			}
	
		}
		public static int inDegree(int v){
		
			int count=0;
			for(int i=0;i<n;i++){
				Iterator<Integer> it=adj[i].listIterator();
				while(it.hasNext()){
				int V=it.next();
				if(V==v)
					count++;
				}
			}
			return count++;
		}
	}
	public static void main(String[] args) {
		int s,v;
		System.out.println("enter number of vertices!");
		int n=Integer.parseInt(sc.nextLine());
		Graph g=new Graph(n);
		Graph.createGraph(n);
		Graph.printGraph();
		Graph.dfsUtil();
	}

}
