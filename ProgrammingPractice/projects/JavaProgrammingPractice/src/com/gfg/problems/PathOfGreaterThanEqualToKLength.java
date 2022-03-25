package com.gfg.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class PathOfGreaterThanEqualToKLength {

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
		static boolean[] status;
		static int[] pred;
		static ArrayList<Edge> adj[];
		static int n;
		static int MAX=100;
		Graph(int n){
			this.n=n;
			this.status=new boolean[n];
			this.pred=new int[n];
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
		public static int isSafe(int s,int d){
			int weight=0;
			ArrayList<Edge> list=adj[s];
			Iterator<Edge> it=list.iterator();
			while(it.hasNext()){
				Edge e=it.next();
				if((e.dest==d)&&!status[d]){
					weight=e.weight;
				}
			}
			return weight;
		}
		public static boolean isPath(int start,int destVertex,int t_pathdist,int n){
			if((t_pathdist<=0)){
				return true;
			}
				ArrayList<Edge> list=adj[start];
				Iterator<Edge> it=list.iterator();
					while(it.hasNext()){
						Edge e=it.next();
						
						if(status[e.dest])
							continue;
						if(e.weight>=t_pathdist)
							return true;
						status[e.dest]=perm;
						push(e.dest);
						if(isPath(e.dest,destVertex,t_pathdist-e.weight,n))
							return true;
						pop();
						status[e.dest]=temp;
					}
					System.out.println();
					printPath(stack);
					System.out.println();
					System.out.println(Arrays.toString(Graph.status));
					System.out.println();
					return false;		
					
				
				
		}
		private static boolean findPath(int source,int dest,int distsum) {
			// TODO Auto-generated method stub
			initializestack();
			for(int i=0;i<n;i++){
				status[i]=temp;
				pred[i]=NIL;
			}
			push(1);
			status[source]=perm;
			System.out.print(source+" ");
			return isPath(source,dest,distsum,n);
		}
		public static void printPath(int[] stack){
			for(int i=0;i<=top;i++){
				System.out.print(stack[i]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int s,v;
		System.out.println("enter number of vertices!");
		int n=Integer.parseInt(sc.nextLine());
		Graph g=new Graph(n);
		Graph.createGraph(n);
		Graph.printGraph();
		System.out.println("Graph creation Complete!");
		if(Graph.findPath(0,2,60)){
			System.out.println("findPath() Complete!");
			Graph.printPath(Graph.stack);
			System.out.println("YES");
		}
		else{
			System.out.println("NO");
			Graph.printPath(Graph.stack);
		}
		
		System.out.println(Arrays.toString(Graph.status));
	}
}
