package com.gfg.practice_mix;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ModifiedFloyedWarshalsAlgoForAllPairShortestPath {

	static Scanner sc=new Scanner(System.in);
	static class Graph{
		static int MAX=100;
		static int n;
		static int[][] adj;
		static int NIL=-1;
		static int infinite=999999;
		static int[][] pred;
		static int[][] shortestPath;
		public  Graph(int n){
			Graph.n=n;
			pred=new int[n][n];
			shortestPath=new int[n][n];
			adj=new int[n][n];
			
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++)
					adj[i][j]=0;
			}
		}
		public static void addEdge(int u,int v,int w){
			adj[u][v]=w;
		}
		public static void printGraph(){
			
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++)
					if(adj[i][j]!=infinite)
						System.out.println("Edge:-("+i+" , "+j+")->"+adj[i][j]);
			}
			System.out.println();
		}
		public static void printMat(int[][] mat){
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++)
						System.out.print(mat[i][j]+" ");
				System.out.println();
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
		public static void findPathAndLength(int s,int d){
			int count=0;
			int[] path=new int[n];
			
			if(shortestPath[s][d]==infinite){
				System.err.println("No Path exist!");
				return;
			}
			count=-1;
			do{
				path[++count]=d;
				d=pred[s][d];
			}while(d!=s);
			path[++count]=s;
			
			for(int i=count;i>=0;i--)
				System.out.print(path[i]+" ");
			
		}
		public static void floyedWarsharls(){
			
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					if(adj[i][j]==0){
						shortestPath[i][j]=infinite;
						pred[i][j]=-1;
					}
					else{
						shortestPath[i][j]=adj[i][j];
						pred[i][j]=i;
					}
				}
			}
			
			for(int k=0;k<n;k++){
				
				for(int i=0;i<n;i++){
					for(int j=0;j<n;j++){
						
						if((shortestPath[i][k]+shortestPath[k][j]<shortestPath[i][j])){
							shortestPath[i][j]=adj[i][k]+adj[k][j];
							pred[i][j]=pred[k][j];
						}
					}
				}
			}
			System.out.println("Shortest path matrix is:");
			printMat(shortestPath);
			
			System.out.println();
			System.out.println("Predessessor matrix is :");
			printMat(pred);
			for(int i=0;i<n;i++){
				if(shortestPath[i][i]<0)
					System.err.println("Error Negative cycle:");
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
		Graph.floyedWarsharls();
		/*System.out.println("1");
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
*/	}

}
