package org.algo.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;


public class HamiltonianCycleBacktrackingAlgorithm {

	static Scanner sc=new Scanner(System.in);
	static class Graph{
		static int MAX=100;
		static int n;
		static ArrayList<Integer>[] adj;
		static int NIL=-1;
		static boolean[] status;
		static int s;
		public  Graph(int n){
			Graph.n=n;
			status=new boolean[n];
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
		public static boolean checkHamiltonianCycleUtil(int source,boolean[] status ,int count){
			count++;
			status[source]=true;
			System.out.println();
			System.out.print(" Source-"+source+":");
			if(count==n){
				System.out.println("count:"+count);
				ArrayList<Integer> list=adj[source];
				Iterator<Integer> it=list.iterator();
				//System.out.println("3");
				while(it.hasNext()){
					int i=it.next();
					if(i==s) return true;
				}
				return false;
			}
			ArrayList<Integer> list=adj[source];
			Iterator<Integer> it=list.iterator();
			//System.out.println("3");
			while(it.hasNext()){
				int i=it.next();
				System.out.print("go "+i);
				if(!status[i]){
					
					if(checkHamiltonianCycleUtil(i, status, count))
						return true;
					status[i]=false;
				}
				System.out.println("back:"+i+"  count:"+count);
				System.out.println(Arrays.toString(status));
			}
			return false;
		}
		
		public static void checkHamiltonianCycle(int sr){
			s=sr;
			for(int i=0;i<n;i++)
				status[i]=false;
			
			System.out.println("1");
				if(checkHamiltonianCycleUtil(s, status,0))
					System.out.println("Hamiltonian Cycle is there");
				else
					System.err.println("Hamiltonian Cycle is Not there");
				
		}
		
		
	}
		
	
	public static void main(String[] args) {
		System.out.println("enter number of vertices!");
		int n=Integer.parseInt(sc.nextLine());
		Graph g=new Graph(n);
		Graph.createGraph(n);
		Graph.printGraph();
		Graph.checkHamiltonianCycle(0);
		
	}
}
