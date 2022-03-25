package org.algo.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
//to Prove graph is strongly connected  
public class IdentifiedGraphIsStronglyConnected {
	static Scanner sc=new Scanner(System.in);
	static class Graph{
		static int MAX=100;
		static int n;
		static ArrayList<Integer>[] adj;
		static ArrayList<Integer>[] revAdj;
		static int initial=0;
		static int visited=1;
		static int finished=2;
		static int NIL=-1;
		static int infinite=999999;
		static int[] status;
		static int sorce;
		public  Graph(int n){
			Graph.n=n;
			status=new int[n];
			adj=new ArrayList[n];
			revAdj=new ArrayList[n];
			for(int i=0;i<n;i++)
			{
				revAdj[i]=new ArrayList<>();
				adj[i]=new ArrayList<>();
			}
		}
		public static void addEdge(int u,int v){
			adj[u].add(v);
			//adj[v].add(u);
		}
		public static void revAddEdge(int u,int v){
			revAdj[u].add(v);
			//revAdj[v].add(u);
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
		public static void revPrintGraph(){
			
			for(int i=0;i<revAdj.length;i++){
				ArrayList<Integer> list=revAdj[i];
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
		static int top;
		static int[] stack;
		static void initializestack(){
			top=-1;
			stack=new int[MAX];
			for(int i=0;i<MAX;i++)
				stack[i]=0;
		}
		static void push(int val){
			if(top==MAX){
				System.out.println("stack is ovrflow!");
				return;
			}
			top+=1;
			stack[top]=val;
		}
		static int pop(){
			if(top==-1){
				System.out.println("stack is underflow!");
				return -1;
			}
			int val=stack[top];
			top-=1;
			return val;
		}
		static boolean isEmpty(){
			if(top==-1)
				return true;
			else
				return false;
		}
		
		static int time=-1;
		private static void dfsUtil(int s) {
				status[s]=visited;
				ArrayList<Integer> ad=adj[s];
					Iterator<Integer> it=ad.listIterator();
					while(it.hasNext()){
						int v=it.next();
						if((status[v]==initial)){
							dfsUtil(v);
						}
					}
					status[s]=finished;
		}
		public static void reverseGraph(){
			for(int i=0;i<n;i++){
				ArrayList<Integer> ad=adj[i];
				Iterator<Integer> it=ad.listIterator();
				while(it.hasNext()){
					int v=it.next();
					revAddEdge(v,i);
				}

			}
		}
		public static void isGraphStronglyConnected(int n){
			for(int v=0;v<n;v++){
				status[v]=initial;
			}
			initializestack();
			System.out.println("enter source vertex");
			int s=Integer.parseInt(sc.nextLine());
			sorce=s;
			dfsUtil(s);
			boolean flage=true;
			for(int v=0;v<n;v++){
				if(status[v]==initial){
					flage=false;
				}
			}
			if(!flage)
				System.out.println("Grapth is not connected !");
			else{
				System.out.println("2");
				reverseGraph();
				System.out.println("3");
				revPrintGraph();
				for(int v=0;v<n;v++){
					status[v]=initial;
				}
				initializestack();
				System.out.println("enter source vertex");
				s=Integer.parseInt(sc.nextLine());
				sorce=s;
				dfsUtil(s);
				flage=true;
				for(int v=0;v<n;v++){
					if(status[v]==initial){
						flage=false;
					}
				}
				if(!flage)
					System.out.println("Grapth is not strongly connected !");
				else
					System.out.println("Grapth is strongly connected !");
			}
		}
		
	}
		
	
	public static void main(String[] args) {
		int s,v;
		System.out.println("enter number of vertices!");
		int n=Integer.parseInt(sc.nextLine());
		Graph g=new Graph(n);
		Graph.createGraph(n);
		Graph.printGraph();
		Graph.isGraphStronglyConnected(n);
	}
}
