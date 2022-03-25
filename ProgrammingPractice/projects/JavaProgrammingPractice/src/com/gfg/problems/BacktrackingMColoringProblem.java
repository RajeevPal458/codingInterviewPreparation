package com.gfg.problems;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class BacktrackingMColoringProblem {
		static Scanner sc=new Scanner(System.in);
		static class Graph{
			static int n;
			static ArrayList<Integer>[] adj;
			static int NIL=-1;
			static int[] color;
			public  Graph(int n){
				Graph.n=n;
				color=new int[n];
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
			public static boolean isSafe(int v,int c){
				boolean flage=true;
				ArrayList<Integer> list=adj[v];
				Iterator<Integer> it=list.listIterator();
				while(it.hasNext()){
					int a=it.next();
					if(color[a]==c){
						return false;
					}
				}
				return true;
			}
			private static boolean isColoringPossible(int m,int v) {
				if(v==n)
					return true;
				for(int c=1;c<=m;c++){
					if(isSafe(v,c)){
						color[v]=c;
						
						if(isColoringPossible(m,v+1))
							return true;
						color[v]=NIL;
					}
				}
				
				return false;
			}
			private static void isEnoughMColor(int m) {
				for(int i=0;i<n;i++){
					color[i]=NIL;
				}
				System.out.println("enter source vertex");
				int s=Integer.parseInt(sc.nextLine());
				if(isColoringPossible(m,s))
					System.out.println("Graph is  Cloarable using M color");
				else
					System.out.println("Graph is not Cloarable using M color");
			printSolution();
				
			}
			public static void printSolution()
		    {
		        System.out.println("Solution Exists: Following" +
		                           " are the assigned colors");
		        for (int i = 0; i < n; i++)
		            System.out.print(" " + color[i] + " ");
		        System.out.println();
		    }
		}
		public static void main(String[] args) {
			int s,v;
			System.out.println("enter number of vertices!");
			int n=Integer.parseInt(sc.nextLine());
			System.out.println("enter Max number of color!");
			int m=Integer.parseInt(sc.nextLine());
			Graph g=new Graph(n);
			Graph.createGraph(n);
			Graph.printGraph();
			Graph.isEnoughMColor(m);
			
			
		}

	

}
