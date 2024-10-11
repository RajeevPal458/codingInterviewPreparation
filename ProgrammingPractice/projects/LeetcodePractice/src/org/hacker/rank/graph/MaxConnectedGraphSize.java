package org.hacker.rank.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MaxConnectedGraphSize {
	

	static int counter=0;
    
    /*
     * Complete the 'componentsInGraph' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts 2D_INTEGER_ARRAY gb as parameter.
     */
	 public static void graphSize(List<List<Integer>> graph, boolean[] status, int s ){
         status[s]=true;
         counter++;
         List<Integer> list = graph.get(s);
         for(int v : list){
            if(!status[v]){
            	graphSize(graph, status, v);
            }
          }
	 }
	 
//    public static int graphSize(List<List<Integer>> graph, boolean[] status, int s ){
//          int count=0;
//          Queue<Integer> queue = new LinkedList<>();
//          queue.add(s);
//          status[s]=true;
//          while(!queue.isEmpty()){
//             int curr = queue.poll();
//             status[curr]=true;
//             count++;
//             List<Integer> list = graph.get(curr);
//             for(int v : list){
//                if(!status[v]){
//                    queue.add(v);
//                }
//              }
//          }
//         return count;
//    }
    public static void addEdge(List<List<Integer>> graph,int u,int v){
       graph.get(u).add(v);
       graph.get(v).add(u);
    }
    public static List<Integer> componentsInGraph(List<List<Integer>> gb) {
    // Write your code here
        List<List<Integer>> graph = new ArrayList<>();
        int max =0;
        for(List<Integer> list : gb){
            max = Math.max(max, Math.max(list.get(0), list.get(1)));
        }
        //System.out.println(max);
        for(int i=0;i<=max;i++){
            graph.add(new ArrayList<>());
        }
        //System.out.println(graph);
        for(List<Integer> list : gb){
            addEdge(graph, list.get(0), list.get(1));
        }
        System.out.println(graph);
        boolean[] status = new boolean[max+1];
        int minSize=Integer.MAX_VALUE;
        int maxSize=Integer.MIN_VALUE;
        for(int i=0;i<=max;i++){
        	counter=0;
            if(!status[i] && !graph.get(i).isEmpty()){
                graphSize(graph,status,i);
                minSize = Math.min(minSize, counter>1?counter:maxSize);
                maxSize = Math.max(maxSize, counter);
            }
        }
        List<Integer> result = new ArrayList<>();
        result.add(minSize);
        result.add(maxSize);
       return result; 
    }

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
        int n = Integer.parseInt(sc.nextLine());

        List<List<Integer>> gb = new ArrayList<>();
        int i=0;
        while (i++ < n) {
			String[] str = sc.nextLine().split(" ");
			List<Integer> list = new ArrayList<Integer>();
			list.add(Integer.parseInt(str[0]));
			list.add(Integer.parseInt(str[1]));
			gb.add(list);
		}
      
        System.out.println(gb);

        List<Integer> result = componentsInGraph(gb);

       System.out.println(result);
    }
}
