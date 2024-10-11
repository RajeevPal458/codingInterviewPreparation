package org.hacker.rank;

public class ShortestPathInBinaryMaze {
	static boolean[][] visited = null;
	static int minDist=Integer.MAX_VALUE;
	static int[] pathx= {1,0,-1,0};
	static int[] pathy= {0,1,0,-1};
	public static void main(String[] args) {

		int[][] mat = new int[][] {
		      { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
		      { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
		      { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
		      { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
		      { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
		      { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
		      { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
		      { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
		      { 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }
		    };
		 
		    int[] src = { 0, 0 };
		    int[] dest = { 3, 4 };
		    int m= mat.length;
		    int n= mat[0].length;
		    
		    visited = new boolean[m][n];
//		    findShortestPathLength(mat, 0,0, 3,4,m,n,0);
//		    if (minDist != -1)
//		      System.out.print("Shortest Path is " + minDist);
//		 
//		    else
//		      System.out.print("Shortest Path doesn't exist");
//		    
		    findShortestPathLength2(mat, 0,0, 3,4,m,n,0);
		    if (minDist != -1)
		      System.out.print("Shortest Path is " + minDist);
		 
		    else
		      System.out.print("Shortest Path doesn't exist");
	}
	
	
	
	private static void findShortestPathLength(int[][] mat, int i,int j, int ed1, int ed2, int m, int n,int dist) {
		if(i==ed1 && j==ed2) {
			minDist = Math.min(minDist, dist);
			return;
		}
		
		visited[i][j]=true;
		//bottom
		if(isSafe(mat, i+1, j, m, n)) {
			findShortestPathLength(mat, i+1, j, ed1, ed2, m, n, dist+1);
		}
		
		if(isSafe(mat, i, j+1, m, n)) {
			findShortestPathLength(mat, i, j+1, ed1, ed2, m, n, dist+1);
		}
		
		if(isSafe(mat, i-1, j, m, n)) {
			findShortestPathLength(mat, i-1, j, ed1, ed2, m, n, dist+1);
		}
		if(isSafe(mat, i, j-1, m, n)) {
			findShortestPathLength(mat, i, j-1, ed1, ed2, m, n, dist+1);
		}
		visited[i][j]=false;
	}
	
	private static void findShortestPathLength2(int[][] mat, int i,int j, int ed1, int ed2, int m, int n,int dist) {
		if(i==ed1 && j==ed2) {
			minDist = Math.min(minDist, dist);
		}
		visited[i][j]=true;
		//bottom
		for(int k=0;k<pathx.length;k++) {
			int nextx=i+pathx[k];
			int nexty=j+pathy[k];
			if(isSafe(mat, nextx, nexty, m, n)) {
				findShortestPathLength(mat, nextx, nexty, ed1, ed2, m, n, dist+1);
			}
		}
		visited[i][j]=false;
	}

	public static boolean isSafe(int[][] mat,int i,int j,int m,int n) {
		return (i>=0&&i<m &&j>=0 && j<n && mat[i][j]==1 && !visited[i][j]);
	}



}
