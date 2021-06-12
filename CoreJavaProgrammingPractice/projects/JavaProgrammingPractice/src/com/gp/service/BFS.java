package com.gp.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import com.gp.service.BellmanFordAlgorithm.Edge;
import com.gp.service.BellmanFordAlgorithm.Graph;

public class BFS {
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
		static int[] pred;
		static int[] status;
		static int[] pathlen;
		static int sorce;
		public  Graph(int n){
			Graph.n=n;
			pred=new int[n];
			status=new int[n];
			pathlen=new int[n];
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
			System.out.println("rear:"+rear+"  n:"+n+" val:"+val+" size of queue: "+queue.length);
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
			System.out.println("Distance of destination from source is:"+count+" "+pathlen[dest]);
		}
		private static void dfsUtil(int s) {
			
			inQue(s);
			status[s]=waiting;
			pathlen[s]=0;
			while(!isEmpty()){
				int source=deQueue();
				status[source]=visited;
				ArrayList<Integer> ad=adj[source];
					Iterator<Integer> it=ad.listIterator();
					while(it.hasNext()){
						int v=it.next();
						if((status[v]==initial)&&(pathlen[source]<pathlen[v])){
							inQue(v);
							pred[v]=source;
							pathlen[v]=pathlen[source]+1;
							status[v]=waiting;
						}
					}
			}
		}
		private static void dfs(int n) {
		// TODO Auto-generated method stub
			for(int v=0;v<n;v++){
				status[v]=initial;
				pred[v]=NIL;
				pathlen[v]=infinite;
			}
			initializeQueue();
			System.out.println("enter source vertex");
			int s=Integer.parseInt(sc.nextLine());
			sorce=s;
			dfsUtil(s);
		
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
			else if(g.pathlen[dest]==g.infinite)
				System.out.println("there is no path for this dest it might apear disconnected graph!");
			else
				Graph.findPathAndLength(dest);
			
		}
	}

}
