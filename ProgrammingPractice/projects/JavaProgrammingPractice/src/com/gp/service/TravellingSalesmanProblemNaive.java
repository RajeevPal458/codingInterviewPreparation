package com.gp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import com.gp.service.DijkstraAlgorithm.Graph;

public class TravellingSalesmanProblemNaive {

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
		static int n;
		static int[][] mat;
		Graph(int n){
			this.n=n;
			this.n=n;
			mat=new int[n][n];
			for(int i=0;i<n;i++){
				for(int v=0;v<n;v++)
					mat[i][v]=0;
			}	
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
		public static int fact(int n){
			if(n==1)
				return 1;
			return n*fact(n-1);
		}
		public static int totalwaight(int[] arr){
			int totalWt=0;
			int node=-1;
			int i;
			for(i=0;i<arr.length;i++){
				
				if(node==-1)
				{
					node=arr[i];
					continue;
				}
				if(mat[node][arr[i]]!=0)
				{
					totalWt+=mat[node][arr[i]];
					node=arr[i];
				}
				else{
					totalWt=0;
					break;
				}
			}
			if(i==arr.length&&mat[arr[i-1]][arr[0]]!=0)
				totalWt+=mat[arr[i-1]][arr[0]];
			return totalWt;
		}
		public static void swap(int[] arr,int i,int j){
			int temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
		}
		public static int[] copy(int[] a,int[] b){
			
			for(int i=0;i<n;i++){
				a[i]=b[i];
			}
			return a;
		}
		public static void travellingSalesMan(){
			int ft=fact(n);
			System.out.println("ft"+ft);
			int[] arr=new int[n];
			for(int i=0;i<arr.length;i++)
				arr[i]=i;
			int m=0,j=1;
			int[] ans=new int[n+1];
			int[] temp=new int[n];
			int totalw=0,minPath=999999;
			for(int i=0;i<ft; ){
				System.out.println("Copyied:"+Arrays.toString(temp));
				temp=copy(temp,arr);
				int k=0;
				while(k!=ft/n){
					
					while(j!=n-1){
						
						totalw=totalwaight(temp);
						System.out.println("TW:"+totalw);
						if(minPath>totalw){
							minPath=totalw;
							ans=copy(ans, temp); 
						}
						
						swap(temp, j, j+1);
						k++;
						i++;
						j++;
					}
					j=1;
				}
				
				m++;
				if(m==n)
					break;
				swap(temp, m, 0);
			}
			
			System.out.println("Travelling SalesMan Path"+minPath);
			System.out.println(Arrays.toString(ans));
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
