package com.gp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import com.gp.service.BFS.Graph;

public class HamiltonianCycle {
	Scanner sc=new Scanner(System.in);
	class Graph{
		int n;
		int[][] mat;
		int[] path;
		Graph(int n){
			this.n=n;
			mat=new int[n][n];
		}
		
		public void  addEdge(int u,int v){
			mat[u][v]=1;
			mat[v][u]=1;
		}
		public void printGraph(){
			
			for(int i=0;i<n;i++){
				for(int v=0;v<n;v++){
					if(mat[i][v]==1)
					System.out.println("Edge:-("+i+" , "+v+")");
				}
			}
		}
		public void createGraph(){
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
					this.addEdge(orig, dest);
				}
		}
		public void hamiltonianCycleUtill(int node,boolean[] status,int[] path,int count) throws Exception{
			
			if((mat[node][0]==1)&&(count==n))
					throw new Exception("Hamiltonian Cycle found!");
			if(count==n)
				return ;
			status[node]=true;
			for(int i=0;i<n;i++){
				
				if(mat[node][i]==1&&!status[i]){
					path[count]=i;
					hamiltonianCycleUtill(i, status, path, count+1);
				}
			}
		}
		public void hamiltonianCycle() throws Exception{
			
			boolean[] status=new boolean[n];
			Arrays.fill(status, false);
			
			path=new int[n];
			Arrays.fill(path, -1);
			int count=0;
			path[count]=0;
			this.hamiltonianCycleUtill(0, status, path, count+1);
			
		}
	}
	public static void main(String[] args) {
		HamiltonianCycle hc=new HamiltonianCycle();
		System.out.println("Enter Number of vertices!");
		int n=Integer.parseInt(hc.sc.nextLine());
		
		Graph g=hc.new Graph(n);
		g.createGraph();
		g.printGraph();
		
		try {
			g.hamiltonianCycle();
		} catch (Exception e) {
			System.out.println("HamilTonian Cycle found!");
			
			System.out.println("Path !");
			System.out.println(Arrays.toString(g.path));
			
		}
	}
}
