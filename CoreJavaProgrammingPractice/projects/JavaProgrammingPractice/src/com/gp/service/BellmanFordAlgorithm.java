package com.gp.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

import com.gp.service.DijkstraAlgorithm.Edge;
import com.gp.service.DijkstraAlgorithm.Graph;

public class BellmanFordAlgorithm {
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
		static int MAX=100;
		static int NIL=-1;
		static int infite=9999999; 
		static boolean[] status;;
		static int[] pred;
		static int[] pathlen;
		static boolean[] isPresent;
		static ArrayList<Edge> adj[];
		static int n;
		
		Graph(int n){
			this.n=n;
			this.status=new boolean[n];
			this.pred=new int[n];
			this.pathlen=new int[n];
			this.adj=new ArrayList[n];
			this.isPresent=new boolean[n];
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
				System.out.println("Edge :"+i+++" please inter all Edges by separate one space( )within three non negative number separated by comma(,) in sequences origin,destination,weight(may be negative)");
				String str1=sc.nextLine();
				String[] arr1=str1.split(" ");
				for(int k=0;k<arr1.length;k++){
					
					String str=arr1[k];
					String[] arr=str.split(",");
					if(arr.length==3){
						orig=Integer.parseInt(arr[0]);
						dest=Integer.parseInt(arr[1]);
						weight=Integer.parseInt(arr[2]);
						if(orig<0||dest<0)
						{
							System.out.println("its input for break !");
							break;
						}	
					}
					else{System.out.println("Wrong Input!  \nplease inter three non negative number separated by comma(,) in sequences ");}
					Graph.addEdge(orig, dest, weight);
				}
		}
		static int front,rear;
		static int[] queue;
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
		static void initializeQueue(){
			front=-1;
			rear=-1;
			queue=new int[MAX];
			for(int i=0;i<MAX;i++)
				queue[i]=0;
		}
		public static int bellmanFord(int source){
			int count=0,k=0,cur;
			for(int i=0;i<n;i++){
				pathlen[i]=infite;
				isPresent[i]=false;
				pred[i]=NIL;
			}
			initializeQueue();
			inQue(source);
			pathlen[source]=0;
			isPresent[source]=true;
			while(!isEmpty()){
				
				cur=deQueue();
				System.out.println("cur:"+cur);
				isPresent[cur]=false;
				if(source==cur)
					k++;
				if(k>n)
					return -1;
				ArrayList<Edge> list=adj[cur];
				Iterator<Edge> it=list.listIterator();
				while(it.hasNext()){
					Edge e=it.next();
			System.out.println("e.dest :"+e.dest+"  e.w: "+e.weight);
						if(pathlen[cur]+e.weight<pathlen[e.dest]){
							System.out.println("1");
							pred[e.dest]=cur;
							System.out.println("2");
							pathlen[e.dest]=pathlen[cur]+e.weight;
							System.out.println("3");
							if(!isPresent[e.dest])
							{System.out.println("4");
								inQue(e.dest);
								System.out.println("5");
								isPresent[e.dest]=true;
								System.out.println("6");
							}
						}
				}
			}
			return 1;
		}
		
		public static void shortestPath(int source,int dest){
			int sortdis=0,u;
			int path[]=new int[MAX] ;
			int count=0;
			while(source!=dest){
				
				count++;
				
				path[count]=dest;
				u=pred[dest];
				//sortdis+=adj[source].get(dest).weight;
				dest=u;
			}
			count++;
			path[count]=source;
			System.out.println("Shortest path is:");
			for(int i=count;i>=1;i--){
				System.out.print(path[i]+" -->");
			}
			//System.out.println("Shortest Distence:"+sortdis);
			
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
		
		if(Graph.bellmanFord(s)<0)
			System.out.println("there is a cycle !");
		else
			System.out.println("Success!");
		
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
