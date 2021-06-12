package com.bt.tree.mix;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;

public class ConvertATreeToForestOfEvenNodes {

	static class Answer{
		int ans;
	}
	public static int minEdgeUtill(Vector<Integer>[] tree,boolean[] visited,Answer ans,int node){
		
		visited[node]=true;
		
		int num=0,count=0;
		
		Iterator<Integer> it=tree[node].iterator();
			while(it.hasNext()){
				int v=it.next();
				if(visited[v]==false){
					count=minEdgeUtill(tree, visited, ans, v);
					if(count%2!=0){
						num+=count;
					}
					else ans.ans++;
				}
			}
		return num+1;
	}
	public static int minEdge(Vector<Integer>[] tree,int n){
		boolean[] visited=new boolean[n+2];
		Arrays.fill(visited, false);
		Answer ans=new Answer();
		minEdgeUtill(tree,visited,ans,1);
		return ans.ans;
	}
	public static void main(String[] args) {
		
		int n = 10;
		 
	    Vector<Integer>[] tree=new Vector[n+2];
	    for(int i=0;i<n+2;i++)
	    	tree[i]=new Vector<>();
	    tree[1].add(3);
	    tree[3].add(1);
	 
	    tree[1].add(6);
	    tree[6].add(1);
	 
	    tree[1].add(2);
	    tree[2].add(1);
	 
	    tree[3].add(4);
	    tree[4].add(3);
	 
	    tree[6].add(8);
	    tree[8].add(6);
	 
	    tree[2].add(7);
	    tree[7].add(2);
	 
	    tree[2].add(5);
	    tree[5].add(2);
	 
	    tree[4].add(9);
	    tree[9].add(4);
	 
	    tree[4].add(10);
	    tree[10].add(4);
	 System.out.println(minEdge(tree, n));
	 
	}
}
