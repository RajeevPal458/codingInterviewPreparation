package com.gfg.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class CheckWhetherGivenGraphIsBipartite {
	static Scanner sc=new Scanner(System.in);
	static class Graph{
		static int MAX=100;
		static int n;
		static ArrayList<Integer>[] adj;
		static int initial=0;
		static int waiting=1;
		static int visited=2;
		static int NIL=-1;
		static int infinite=999999;
		static int[] status;
		static int red=1;
		static int blue=0;
		static int[] color;
		static int[] u;
		static int[] v;
		static int sorce;
		public  Graph(int n){
			Graph.n=n;
			color=new int[n];
			status=new int[n];
			u=new int[n];
			v=new int[n];
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
		static int uIndex=0;
		static int vIndex=0;
		private static boolean isBipartiteUtil(int s) {
			
			inQue(s);
			color[s]=red;
			Graph.u[uIndex++]=s;
			while(!isEmpty()){
				int source=deQueue();
				ArrayList<Integer> ad=adj[source];
					Iterator<Integer> it=ad.listIterator();
					while(it.hasNext()){
						int v=it.next();
						if((color[v]==NIL)){
							
								color[v]=1-color[source];
								inQue(v);
							if(vIndex<n&&(color[v]!=red))
								Graph.v[vIndex++]=v;
							else
								Graph.u[uIndex++]=v;
							
						}
						else if(color[source]==color[v])
							return false;
					}
			}
			return true;
		}
		private static void isBipartite(int n) {
		// TODO Auto-generated method stub
			for(int i=0;i<n;i++){
				status[i]=initial;
				color[i]=NIL;
				u[i]=NIL;
				v[i]=NIL;
			}
			initializeQueue();
			System.out.println("enter source vertex");
			int s=Integer.parseInt(sc.nextLine());
			sorce=s;
			if(isBipartiteUtil(s))
				System.out.println("Graph is  Bipartite");
			else
				System.out.println("Graph is not  Bipartite");
		
			System.out.println("Set U:"+Arrays.toString(u)+" ");
			System.out.println("Set V:"+Arrays.toString(v));
			
		}
	}
	public static void main(String[] args) {
		int s,v;
		System.out.println("enter number of vertices!");
		int n=Integer.parseInt(sc.nextLine());
		Graph g=new Graph(n);
		Graph.createGraph(n);
		Graph.printGraph();
		Graph.isBipartite(n);
		
		
	}

}
