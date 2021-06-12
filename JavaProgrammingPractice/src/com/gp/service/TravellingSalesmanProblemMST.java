package com.gp.service;

import java.util.Arrays;
import java.util.Scanner;

import com.gp.service.TravellingSalesmanProblemNaive.Graph;

public class TravellingSalesmanProblemMST {
	
static Scanner sc=new Scanner(System.in);
	
	static class Edge{
		int u;
		int v;
		Edge(int u,int v){
			this.u=u;
			this.v=v;
		}
	}
	static class Graph{
		static int n;
		static int inf=99999;
		static int NIL=-1;
		static boolean[] status;
		static int[] pathlen;
		static int[] pred;
		static int[][] mat;
		static Edge[] tree;
		Graph(int n){
			this.n=n;
			this.n=n;
			mat=new int[n][n];
			for(int i=0;i<n;i++){
				for(int v=0;v<n;v++)
					mat[i][v]=0;
			}	
			status=new boolean[n];
			pathlen=new int[n];
			pred=new int[n+1];
			for(int i=0;i<n;i++){
				status[i]=false;
				pathlen[i]=inf;
				pred[i]=NIL;
			}
			
			tree=new Edge[n];
		}
		public static void addEdge(int orig,int dest,int weight){
			mat[orig][dest]=weight;
			mat[dest][orig]=weight;
		}
		
		public static void printGraph(){
			
			for(int i=0;i<n;i++){
				for(int v=0;v<n;v++){
					if(mat[i][v]!=0)
					System.out.println("Edge:-("+i+" , "+v+")->"+mat[i][v]);
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
		public static int findMin(){
			int min=inf,k=-1;
			
			for(int i=0;i<n;i++){
				if(!status[i]&&pathlen[i]<min){
					min=pathlen[i];
					k=i;
				}
			}
			return k;
		}
		public static void travellingSalesMan(){
			int source=0;
			pathlen[source]=0;
			int count=0;
			int totalw=0;
			while(true){
				
				int s=findMin();
				System.out.println("s1:"+s);
				if(s==NIL){
					if(count==n-1)
						break;
					else{
						System.out.println("graph is not connected no spanning tree are possible!");
						break;
					}
				}
				
				status[s]=true;
				if(s!=source){
					count++;
					tree[count]=new Edge(pred[s],s);
				}
				
				for(int i=0;i<n;i++){
					if((mat[s][i]>0)&&!status[i]){
						if((mat[s][i]<pathlen[i])){
							pathlen[i]=mat[s][i];
							pred[i]=s;
							System.out.println("i:"+i);
						}
					}
				}
			}
			int i;
			System.out.println(Arrays.toString(pred));
			
			for(i=1;i<n;i++){
				System.out.println(tree[i].u+"->"+tree[i].v);
				totalw+=mat[tree[i].u][tree[i].v];
			}
			
			System.out.println("Total WT:"+totalw);
			
		}
	}
	public static void prOrderTraversal(){
		
		
	}
	public static void main(String[] args) {
		int s,v;
		System.out.println("enter number of vertices!");
		int n=Integer.parseInt(sc.nextLine());
		Graph g=new Graph(n);
		Graph.createGraph(n);
		Graph.printGraph();
		Graph.travellingSalesMan();
	}
}









