package org.leet.code.goldmansachs;

import java.util.Scanner;

//https://www.geeksforgeeks.org/diameter-of-a-binary-tree/
public class DiameterOfBinaryTree {
	static Scanner sc = new Scanner(System.in);
	
	static int INF=99999;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int graph[][] ;
     
     int n = Integer.parseInt(sc.nextLine());
     graph = new int[n][n];
     for (int i = 0; i < n; ++i) {
         for (int j = 0; j < n; ++j) {
        	 graph[i][j] = INF;
         }
     }
     String str = sc.nextLine();
     do{
    	 String[] arr = str.split(" ");
    	 graph[Integer.parseInt(arr[0])-1][Integer.parseInt(arr[1])-1]=1;
    	 graph[Integer.parseInt(arr[1])-1][Integer.parseInt(arr[0])-1]=1;
    	 str = sc.nextLine();
     }while(str!=null && str.length()!=0);
     
     DiameterOfBinaryTree a = new DiameterOfBinaryTree();

     a.floydWarshall(graph);
     printSolution(graph);
     
     
     
     
	}
	static void printSolution(int graph[][])
    {
		int n = graph.length;
        System.out.println(
            "The following matrix shows the shortest "
            + "distances between every pair of vertices");
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (graph[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(graph[i][j] + "   ");
            }
            System.out.println();
        }
    }
	private void floydWarshall(int[][] graph) {
		int n = graph.length;
		for(int k=0;k<n;k++) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(graph[i][k] + graph[k][j] < graph[i][j])
						graph[i][j] = graph[i][k] + graph[k][j];
				}
			}
		}
		
	}


}
