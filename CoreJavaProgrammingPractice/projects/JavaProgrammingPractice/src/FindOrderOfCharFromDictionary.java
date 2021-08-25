

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class FindOrderOfCharFromDictionary {
	static class Graph{
		static int v;
		static LinkedList<Integer>[] adjEdg;
		Graph(int V){
			v=V;
			adjEdg=new LinkedList[v];
			for(int i=0;i<v;i++)
				adjEdg[i]=new LinkedList<Integer>();
		}
		
		public static void addEdg(int u,int v){
			adjEdg[u].add(v);
		}
		public static void sortUtill(int k,boolean[] visited,Stack<Integer> stack){
			Integer i;
			visited[k]=true;
			Iterator<Integer> it=adjEdg[k].iterator();
			while(it.hasNext()){
				i=it.next();
				if(visited[i]==false)
				sortUtill(i, visited, stack);
			}
			stack.push(k);
		}
		public static void sort(){
		Stack<Integer> stack=new Stack<>();
		boolean[] visited=new boolean[v];
		for(int i=0;i<v;i++){
			visited[i]=false;
		}
		for(int i=0;i<v;i++){
			if(visited[i]==false){
				sortUtill(i, visited, stack);
			}
		}
		System.out.println();
		while(!stack.isEmpty())
		System.out.print((char)(stack.pop()+'a')+" ");
		}
	
		static int min(int a,int b){ return (a>b)?b:a;}
		public static void findOrder(String[] arr,Graph g,int v,int len){
			int k;
			for(int i=0;i<len-1;i++){
				String first=arr[i],second=arr[i+1];
				for(k=0;k<min(first.length(),second.length());k++)
					if(first.charAt(k)!=second.charAt(k))
						break;
				g.addEdg(first.charAt(k)-'a',second.charAt(k)-'a');
			}
			sort();
		}
	}
	public static void main(String[] args) {
		String arr[]={"baa","abcd","abca","cab","cad"};
		Graph g=new Graph(4);
		g.findOrder(arr,g,4,arr.length);
	}
}
