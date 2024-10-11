package org.hacker.rank.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import util.Pair;

public class DijkastrasShortestPath {

	int size;
	ArrayList<Pair>[] graph;
	int[] predecesor;
	int[] pathLength;
	boolean[] visited;
	public DijkastrasShortestPath(int size) {
		this.size=size;
		graph = new ArrayList[size];
		
		for(int i=0;i<size;i++) {
			graph[i] = new ArrayList<Pair>();
		}
	}
	
	
	
	public void addEdge(int u, int v,int weight) {
		graph[u].add(new Pair(weight, v));
		graph[v].add(new Pair(weight, u));
	}
	
	public void sortestPath(int s) {
		
		visited = new boolean[size];
		predecesor = new int[size];
		pathLength = new int[size];
		Arrays.fill(visited, false);
		Arrays.fill(predecesor, -1);
		Arrays.fill(pathLength, Integer.MAX_VALUE);
		predecesor[s]=-1;
		pathLength[s]=0;
		while (true) {
			int curr = getMin();
			if(curr==-1){
				return ;
			}
			System.out.println(curr);
			visited[curr]=true;
			for(Pair pair:graph[curr]) {
				if(!visited[pair.getVertex()] && 
						pathLength[curr]+pair.getWeight()<pathLength[pair.getVertex()]) {
					pathLength[pair.getVertex()] = pathLength[curr]+pair.getWeight();
					predecesor[pair.getVertex()] =curr;
				}
			}
		}
		
	}
	
	public void printDistance() {
		System.out.println();
		System.out.println("vertex           pathlength from vertex '0'");
		for(int i=0;i<size;i++) {
			System.out.println(i+"               "+pathLength[i]);
		}
	}
	
	private int getMin() {
		int k=-1;
		int min=Integer.MAX_VALUE;
		for(int i=0;i<size;i++) {
			if(!visited[i] && min>pathLength[i]) {
				min=pathLength[i];
				k=i;
			}
		}
		
		return k;
	}

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int n = Integer.parseInt(sc.nextLine());
		DijkastrasShortestPath dijkastrasShortestPath=new DijkastrasShortestPath(n);
		for(int i=0;i<n;i++){
			String line=sc.nextLine();
			if(line==null || line.length()==0) break;
			String[] str = line.split(" ");
			for (int j=0; j<n ;j++) {
				int weight =Integer.parseInt(str[j]);
				if(weight!=0)
					dijkastrasShortestPath.addEdge(i, j,weight);
			}
		}
		
		dijkastrasShortestPath.sortestPath(0);
		dijkastrasShortestPath.printDistance();
	}


}
