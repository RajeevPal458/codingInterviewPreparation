package com.gfg.practice_mix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

/*10 9
	2 1 3 1 4 3 5 2 6 1 7 2 8 6 9 8 10 8
 * */
public class DivisibilityTree {
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
		static int[] degree;
		static int[] status;
		static int sorce;
		public  Graph(int n){
			Graph.n=n;
			degree=new int[n];
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
		// 1,0 2,0 3,2 4,1 5,0 6,1 7,5 8,7 9,7
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
		private static int bfsUtil(int s,int adjOf) {
			inQue(s);
			int count=0;
			status[s]=waiting;
			while(!isEmpty()){
				int source=deQueue();
				System.out.print("surce:"+source);
				count++;
				status[source]=visited;
				ArrayList<Integer> ad=adj[source];
					Iterator<Integer> it=ad.listIterator();
					while(it.hasNext()){
						int v=it.next();
						if(status[v]==initial&&(v!=adjOf)){
							inQue(v);
							status[v]=waiting;
						}
					}
			}
			return count;
		}
		private static void degreeOfAllVertex(int n) {
		int count=0;
		boolean flage=true,addVertex=false;
		int maxDegVer=-1,maxDeg=0,ver=-1,max=0;
			for(int i=0;i<n;i++){
				
				Iterator<Integer> it=adj[i].iterator();
				while(it.hasNext()){
					it.next();
					count++;
				}
				degree[i]=count;
				count=0;
			}
			System.out.println(Arrays.toString(degree));
			count=0;
			for(int i=0;i<n;i++){
				ver=i;
				Iterator<Integer> it=adj[i].iterator();
				while(it.hasNext()){
				int v=it.next();
					max=bfsUtil(v,ver);
					System.out.println("MAX:"+max);
					if(!(max%2==0)&&!addVertex){
						max+=1;
						addVertex=true;
					}
					if((max%2==0)){
						count++;
					}
					System.out.println("count:"+count);
					max=0;
				}
				addVertex=false;
				if(maxDeg<count){
					maxDeg=count;
					maxDegVer=ver;
				}
				System.out.println("maxDeg:"+maxDeg+"maxDegVer:"+maxDegVer);
				/*if(maxDeg==degree[maxDegVer]){
					System.out.println("We can remove maximun edges:"+maxDeg+" from vertex:"+maxDegVer);
					flage=false;
					break;
				}*/
				count=0;
				/*if(!flage)
					break;*/
			}
			if(flage)
				System.out.println("We can remove maximun edges:"+maxDeg+" from vertex:"+maxDegVer);
		}
		
		
	}
	public static void main(String[] args) {
		int s,v;
		System.out.println("enter number of vertices!");
		int n=Integer.parseInt(sc.nextLine());
		Graph g=new Graph(n);
		Graph.initializeQueue();
		Graph.createGraph(n);
		Graph.printGraph();
		Graph.degreeOfAllVertex(n);
		
	}

}
