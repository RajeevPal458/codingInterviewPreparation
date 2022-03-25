package org.algo.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class DFS {

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
		public static void findPathAndLength(int dest){
			System.out.println("Path Length of vertex "+dest+" from source "+sorce);
			int sortdis=0,u;
			int path[]=new int[MAX] ;
			int count=0;
			while(dest!=sorce){
				
				count++;
				
				path[count]=dest;
				u=pred[dest];
				//sortdis+=adj[source].get(dest).weight;
				dest=u;
			}
			count++;
			path[count]=sorce;
			System.out.println("Shortest path is:");
			for(int i=count;i>=1;i--){
				System.out.print(path[i]+" -->");
			}
			
			System.out.println();
			System.out.println("Distance of destination from source is:"+count);
		}
		static int time=-1;
		private static void dfsUtil(int component,int s) {
				System.out.println();
				System.out.print("component:"+component+" V:"+s);
				System.out.println();
				time+=1;
				searchTime[s]=time;
				status[s]=visited;
				ArrayList<Integer> ad=adj[s];
					Iterator<Integer> it=ad.listIterator();
					while(it.hasNext()){
						int v=it.next();
						if((status[v]==initial)){
							pred[v]=s;
							dfsUtil(component,v);
						}
					}
					status[s]=finished;
					time+=1;
					finishTime[s]=time;
			}
		public static void dfs(int n){
			for(int v=0;v<n;v++){
				status[v]=initial;
				pred[v]=NIL;
				searchTime[v]=0;
				finishTime[v]=0;
			}
			int component=0;
			initializestack();
			System.out.println("enter source vertex");
			int s=Integer.parseInt(sc.nextLine());
			sorce=s;
			component++;
			dfsUtil(component,s);
			for(int v=0;v<n;v++){
				if(status[v]==initial){
					component++;
					dfsUtil(component,s);
				}
			}
			if(component==1)
				System.out.println("Grapth is connected !");
			else
				System.out.println("Graph is disconnected!");
			System.out.println();
			for(int i=0;i<n;i++){
				System.out.println("Searching Time of Vertex "+i+" is "+searchTime[i]);
				System.out.println("Finished Time of Vertex "+i+" is "+finishTime[i]);
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
		Graph.dfs(n);
		System.out.println("1");
		while(true){
			System.out.println("enter destination vertex for shortest path from given source to break enter -1 !");
			int dest=Integer.parseInt(sc.nextLine());
			
			if(dest>=n||dest<0)
				break;
			else if(Graph.sorce==dest)
				System.out.println("source and destination are same!");
			else
				Graph.findPathAndLength(dest);
			
		}
	}
}
