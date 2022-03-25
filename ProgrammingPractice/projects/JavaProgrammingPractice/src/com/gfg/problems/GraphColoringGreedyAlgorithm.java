package com.gfg.problems;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.gfg.problems.BacktrackingMColoringProblem.Graph;

public class GraphColoringGreedyAlgorithm {

	static Scanner sc=new Scanner(System.in);
	static class Graph{
		static int n;
		static ArrayList<Integer>[] adj;
		static int NIL=-1;
		static int[] result;
		static boolean[] available;
		public  Graph(int n){
			Graph.n=n;
			result=new int[n];
			available=new boolean[n];
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
		public static void printSolution(int[] color)
	    {
	        System.out.println("Solution Exists: Following" +
	                           " are the assigned colors");
	        for (int i = 0; i < n; i++)
	            System.out.print(" " + color[i] + " ");
	        System.out.println();
	    }
		public void greedyColoring() {
			// TODO Auto-generated method stub
			for(int i=0;i<n;i++){
				result[i]=NIL;
			}
			result[0]=0;
			
			for(int i=0;i<n;i++){
				available[i]=true;
			}
			
			for(int v=1;v<n;v++){
				
				ArrayList<Integer> list=adj[v];
				Iterator<Integer>it=list.listIterator();
				while(it.hasNext()){
					int a=it.next();
					if(result[a]!=NIL)
						available[result[a]]=false;
				}
				int j;
				for(j=0;j<n;j++){
					if(available[j])
						break;
				}
				result[v]=j;
				Iterator<Integer> it1=list.listIterator();
				while(it1.hasNext()){
					int a=it1.next();
					if(result[a]!=NIL)
						available[result[a]]=true;
				}
			}
		}
	}
	public static void main(String[] args) {
		 Graph g1 = new Graph(5);
	        g1.addEdge(0, 1);
	        g1.addEdge(0, 2);
	        g1.addEdge(1, 2);
	        g1.addEdge(1, 3);
	        g1.addEdge(2, 3);
	        g1.addEdge(3, 4);
	        System.out.println("Coloring of graph 1");
	        g1.greedyColoring();
	        Graph.printSolution(Graph.result);;
	        System.out.println();
	        Graph g2 = new Graph(5);
	        g2.addEdge(0, 1);
	        g2.addEdge(0, 2);
	        g2.addEdge(1, 2);
	        g2.addEdge(1, 4);
	        g2.addEdge(2, 4);
	        g2.addEdge(4, 3);
	        System.out.println("Coloring of graph 2 ");
	        g2.greedyColoring();
	        Graph.printSolution(Graph.result);;
	        
	}

}
