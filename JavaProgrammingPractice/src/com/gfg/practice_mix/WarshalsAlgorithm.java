package com.gfg.practice_mix;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.gfg.practice_mix.TapologicalShorting.Graph;

public class WarshalsAlgorithm {

	static Scanner sc=new Scanner(System.in);
	static class Graph{
		static int MAX=100;
		static int n;
		static int NIL=-1;
		static int infinite=999999;
		static int[][] adj;
		static int[][] path;
		public  Graph(int n){
			
			adj=new int[n][n];
			path=new int[n][n];
			Graph.n=n;
		}
		public static void addEdge(int u,int v){
			adj[u][v]=1;
		}
		public static void printGraph(){
			
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++)
				System.out.print(adj[i][j]+" ");
			System.out.println();
			}
		}
		
    	public static void createGraph(){
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
    	public static void pathMatrixWarshals(){
    		
    		for(int i=0;i<n;i++){
    			for(int j=0;j<n;j++){
    				path[i][j]=adj[i][j];
    			}
    		}
    		for(int k=0;k<n;k++){
    			for(int i=0;i<n;i++){
        			for(int j=0;j<n;j++){
        				if(path[i][j]!=1){
        					if((path[i][k]==1)&&(path[k][j]==1))
        						path[i][j]=1;
        				}
        			}
        		}
    		}
    		System.out.println("Path matrix is!");
    		for(int i=0;i<n;i++){
    			for(int j=0;j<n;j++){
    				System.out.print(path[i][j]+" ");
    			}
    			System.out.println();
    		}
    		
    		
    	}
	}
	public static void main(String[] args) {
		new Graph(4);
		Graph.createGraph();
		Graph.printGraph();
		Graph.pathMatrixWarshals();
	}
}