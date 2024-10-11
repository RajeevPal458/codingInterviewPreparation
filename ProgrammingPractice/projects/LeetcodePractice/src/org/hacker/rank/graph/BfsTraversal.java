package org.hacker.rank.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * undirected graph
 * 
 */
public class BfsTraversal {
	int size;
	ArrayList<Integer>[] graph;
	boolean[] visited;
	public BfsTraversal(int size) {
		this.size=size;
		graph = new ArrayList[size];
		Arrays.fill(graph, new ArrayList<Integer>());
	}
	
	public void init() {
		visited = new boolean[size];
		Arrays.fill(visited, false);
	}
	
	public void addEdge(int u, int v) {
		graph[u].add(v);
		graph[v].add(u);
	}
	
	public void bfs(int s) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[size];
		Arrays.fill(visited, false);
		queue.add(s);
		visited[s]=true;
		while (!queue.isEmpty()) {
			int i = queue.poll();
			System.out.print(i+" ");
			for(int j:graph[i]) {
				if(!visited[j]) {
					queue.add(j);
					visited[j]=true;
				}
			}
		}
	}
	
	public void dfs(int s) {
		visited[s]=true;
		System.out.print(s+ " ");
		for(int j:graph[s]) {
			if(!visited[j]) {
				dfs(j);
			}
		}
	}
	
	
	
	
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int n = Integer.parseInt(sc.nextLine());
		BfsTraversal bfsTraversal=new BfsTraversal(n);
		int i=0;
		while (i++<n && sc.hasNext()) {
			String[] str = sc.nextLine().split(" ");
			bfsTraversal.addEdge(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
		}
		System.out.println();
		System.out.println("BFS Traversal");
		bfsTraversal.bfs(0);
		
		bfsTraversal.init();
		
		System.out.println();
		System.out.println("DFS Traversal");
		bfsTraversal.dfs(0);
	}
	

}
