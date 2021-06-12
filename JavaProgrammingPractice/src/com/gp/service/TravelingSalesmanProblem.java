package com.gp.service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

import com.gp.service.TravelingSalesmanProblemsBranchAndBound.Graph;

public class TravelingSalesmanProblem {

static Scanner sc=new Scanner(System.in);
	
	static class Graph{
		static int n;
		static int[][] mat;
		static int inf=999999999;
		static int[][] rcMtrix;
		Graph(int n){
			this.n=n;
			this.n=n;
			mat=new int[n][n];
			for(int i=0;i<n;i++){
				for(int v=0;v<n;v++)
					mat[i][v]=inf;
			}	
			rcMtrix=new int[n][n];
		}
		
		static class LiveNode{
			int lowerBound;
			int level;
			int finalResult;
			int[] curpath;
			int[][] rcm;
			boolean[] visited;
			public LiveNode(){
				this.curpath=new int[n+1];
				this.rcm=new int[n][n];
				this.lowerBound = 0;
				this.level = -1;
				this.finalResult=0;
				this.visited=new boolean[n];
				Arrays.fill(visited, false);
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
		
		public static void copy(int[][] first,int[][] second){
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++)
					first[i][j]=second[i][j];
			}
				
		}
		public static int findMin(int[] arr){
			int min=inf;
			for(int i=0;i<n;i++)
				if(arr[i]<min)
					min=arr[i];
			if(min==inf)
				min=0;
			return min;
		}
		
		public static void printMatrix(int[][] mat){
			
			System.out.println();
			for(int p=0;p<n;p++){
				for(int q=0;q<n;q++)
					System.out.print(mat[p][q]+"           ");
				System.out.println();
			}
		}
		public static int getLowerBoundUsingRowAndColReduction(int[][] rcm,int i,int j){
			int[][] tempRcm=new int[n][n];
			int[] arr=new int[n];
			int totalReduction=0,rowReduction=0,colReduction=0;
			copy(tempRcm, rcm);
			//int val=0;
			
			if(i!=j){
				
				for(int p=0;p<n;p++)
					tempRcm[i][p]=inf;
				for(int x=0;x<n;x++)
					tempRcm[x][j]=inf;
				//val=tempRcm[j][i];   //...........
				tempRcm[j][i]=inf;
			}
				//  row reduction 
				for(int k=0;k<n;k++){
					int min=findMin(tempRcm[k]);
					for(int x=0;x<n;x++){
						if(tempRcm[k][x]!=inf)
							tempRcm[k][x]-=min;
					}
					rowReduction +=min;
				}
				//  Collumn reduction 
				for(int k=0;k<n;k++){
					
					for(int x=0;x<n;x++)
						arr[x]=tempRcm[x][k];
					int min=findMin(arr);
					for(int x=0;x<n;x++){
						if(tempRcm[x][k]!=inf)
							tempRcm[x][k]-=min;
					}
					colReduction +=min;
				}
				/*if(i!=j)
					tempRcm[j][i]=val;*/
				copy(rcMtrix, tempRcm);
				totalReduction=rowReduction+colReduction;
			return totalReduction;
		}
		public static void travellingSalesMan(){
			int reductionSum=0;
			int[][] tempRCM;
			Queue<LiveNode> queue=new PriorityQueue<>(new Comparator<LiveNode>() {

				@Override
				public int compare(LiveNode o1, LiveNode o2) {
					if(o1.lowerBound<o2.lowerBound)
						return -1;
					else if(o1.lowerBound>o2.lowerBound)
						return 1;
					else
						return 0;
				}
			});
			int source=0,level=1;
			int finalRes=0;
			LiveNode node =new LiveNode();
			node.level=level;
			node.curpath[level-1]=source;
			node.lowerBound=getLowerBoundUsingRowAndColReduction(mat, 0, 0);
			int[][] mt=new int[n][n];
			copy(mt, rcMtrix);
			node.rcm=mt;
			System.out.println("I:"+source+"    Lower Bound:"+node.lowerBound);
			printMatrix(mt);
			
			node.finalResult=finalRes;
			queue.add(node);
			while(!queue.isEmpty()){
				LiveNode ln=queue.poll();
				int prevertex=ln.curpath[ln.level-1];
				System.out.println(prevertex+" Level started MIN!"+ln.lowerBound+"  Answer:"+ln.finalResult);
				System.out.println(Arrays.toString(ln.curpath));
				ln.visited[prevertex]=true;
				if(ln.level==n){
					
					if(mat[prevertex][ln.curpath[0]]!=0 ){
						finalRes=ln.finalResult+mat[prevertex][ln.curpath[0]];
						ln.curpath[ln.level]=ln.curpath[0];
						
						System.out.println("Smallest Travelling Salesman path:"+Arrays.toString(ln.curpath)+": Distance: "+finalRes);
						break;
					}
					else
						ln=queue.poll();
				}
				
				for(int i=0;i<n;i++){
					
					if(mat[prevertex][i]!=0&&!ln.visited[i]){
						
						System.out.print("I:"+i+"  LB:");
						LiveNode newNode=new LiveNode();
						ln.curpath[ln.level]=i;
						newNode.curpath=ln.curpath;
						newNode.visited=ln.visited;
						//int Aij=ln.rcm[prevertex][i];
						int lb=getLowerBoundUsingRowAndColReduction(node.rcm,prevertex,i);
						
						int totalLowerBound=ln.lowerBound+ln.rcm[prevertex][i]+lb;
						System.out.print(totalLowerBound);
						int[][] m=new int[n][n];
						copy(m, rcMtrix);
						newNode.rcm=m;
						newNode.lowerBound=totalLowerBound;
						newNode.level=ln.level+1;
						newNode.finalResult=ln.finalResult+mat[prevertex][i];
						printMatrix(m);
						System.out.println();
						System.out.println(Arrays.toString(newNode.curpath));
						System.out.println(Arrays.toString(newNode.visited)+"  finalResult: "+newNode.finalResult);
						
						System.out.println();
						queue.add(newNode);
					}
					
				}
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
