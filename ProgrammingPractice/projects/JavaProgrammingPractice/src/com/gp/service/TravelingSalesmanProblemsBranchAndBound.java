package com.gp.service;

import java.util.Arrays;
import java.util.Scanner;

import com.gp.service.TravellingSalesmanProblemMST.Edge;
import com.gp.service.TravellingSalesmanProblemMST.Graph;

public class TravelingSalesmanProblemsBranchAndBound {

	static Scanner sc=new Scanner(System.in);
	
	static class Graph{
		static int n;
		static int inf=99999;
		static int NIL=-1;
		static int resWeight=9999999;
		static boolean[] status;
		static int[] curpath;
		static int[] finalpath;
		static int[][] mat;
		Graph(int n){
			this.n=n;
			this.n=n;
			mat=new int[n][n];
			for(int i=0;i<n;i++){
				for(int v=0;v<n;v++)
					mat[i][v]=0;
			}	
			status=new boolean[n];
			curpath=new int[n+1];
			finalpath=new int[n+1];
			for(int i=0;i<n;i++){
				status[i]=false;
				curpath[i]=-1;
				finalpath[i]=-1;
			}
			
		}
		public static void addEdge(int orig,int dest,int weight){
			mat[orig][dest]=weight;
			mat[dest][orig]=weight;
		}
		
		public static void printGraph(){
			
			for(int i=0;i<n;i++){
				for(int v=0;v<n;v++)
				System.out.print(mat[i][v]+" ");
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
		public static int findFirstMin(int[][] adj,int vertex){
			int min=99999;
			for(int i=0;i<n;i++){
				
				if(adj[vertex][i]!=0&&adj[vertex][i]<min)
					min=adj[vertex][i];
			}
			return min;
		}
		public static int findSecondMin(int[][] adj,int vertex){
			int first=99999,second=99999;
			
			for(int i=0;i<n;i++){
				
				if(adj[vertex][i]!=0){
					
					
					if(adj[vertex][i]<first){
						second=first;
						first=adj[vertex][i];
					}
					else if((adj[vertex][i]!=first)&&(adj[vertex][i]<second)){
						second=adj[vertex][i];
					}
				}
				
			}
			return second;
		}
		public static void copyToFinal(int[] curpath){
			for(int i=0;i<=n;i++)
				finalpath[i]=curpath[i];
		}
		public static void travellingSalesManUtill(int[][] adj,int curbound,int curweight,int level,int[] curpath) throws Exception{
			
			if((level==n)&&adj[curpath[level-1]][curpath[0]]!=0){
				
				int curres=curweight+adj[curpath[level-1]][curpath[0]];
				if(curres<resWeight)
				{
					resWeight=curres;
					curpath[n]=curpath[0];
					copyToFinal(curpath);
					throw new Exception("Resultent Sales man path found!");
				}
				
			}
			if((level==n))
				return;
			
			// for any other level iterate for all vertices to
		    // build the search space tree recursively
			for(int i=0;i<n;i++){
				
				if(adj[curpath[level-1]][curpath[0]]!=0 && !status[i]){
					
					int temp=curbound;
					
					curweight+=adj[curpath[level-1]][curpath[0]];
					
					if(level==1)
						curbound-=(findFirstMin(adj,curpath[level-1])+findFirstMin(adj, i)/2);
					else
						curbound-=(findSecondMin(adj, curpath[level-1])+findFirstMin(adj, i)/2);
					
					if((curweight+curbound)<resWeight){
						
						curpath[level]=i;
						status[i]=true;
						travellingSalesManUtill(adj, curbound, curweight, level+1, curpath);
					}
					curbound=temp;
					curweight-=adj[curpath[level-1]][curpath[0]];
					
					Arrays.fill(status, false);
					
					for(int k=0;k<level-1;k++)
						status[curpath[k]]=true;
				}
			}
		}
		public static void travellingSalesMan(){
			int curweight=0,curbound=0;
			int level=1,s=0;
			curpath[level-1]=s;
			//calculatecurret loweroud .........
			
			for(int i=0;i<n;i++)
				curbound+=(findFirstMin(mat,i)+findSecondMin(mat, i));
			curbound=((curbound&1)!=0)?(curbound/2)+1:curbound/2;
			status[s]=true;
			try {
				travellingSalesManUtill(mat, curbound, curweight, level, curpath);
			} catch (Exception e) {
				System.out.println("Resultent Sales man path found! ");
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
		Graph.travellingSalesMan();
	}
}
