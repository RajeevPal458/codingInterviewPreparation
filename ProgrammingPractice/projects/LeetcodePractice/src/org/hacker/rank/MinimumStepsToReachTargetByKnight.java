package org.hacker.rank;

import java.util.Arrays;

public class MinimumStepsToReachTargetByKnight {
	static int[] pathx = {2,1,-1,2,1,-1,-2,-2};
	static int[] pathy = {1,2,2,-1,-2,-2,1,-1};
	
//	static int[] pathx = { 2, 1, -1, -2, -2, -1, 1, 2 };
//	static int[] pathy = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int[][] visited = null;
	static int minDist= Integer.MAX_VALUE;
	static boolean isPossible=false;
	public static void main(String[] args) {
		int N = 10;
        int knightPos[] = { 0, 0 };
        int targetPos[] = { 4, 5 };
        
	    visited = new int[N][N];
        // Function call
	    minStepToReachTarget(knightPos[0],knightPos[1],targetPos[0],targetPos[1], N,1);
        System.out.println(minDist);
        System.out.println(isPossible);
        for(int i=0;i<N;i++) {
        	System.out.println(Arrays.toString(visited[i]));
        }
	}
	
	public static boolean isSafe(int i,int j,int n) {
		return (i>=0&&i<n &&j>=0 && j<n && visited[i][j]==0);
	}

	private static void minStepToReachTarget(int i,int j, int ed1,int ed2, int board,int dist) {
		visited[i][j]=dist;
		if(i==ed1 && j==ed2) {
			minDist = Math.min(minDist, dist);
			// Print the current state of ChessBoard
            for (int k = 0; k < board; k++) {
                for (int l = 0; l < board; l++) {
                    System.out.print(visited[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
            
			visited[i][j]=0;
			isPossible=true;
			return;
		}
		for(int k=0;k<pathx.length;k++) {
			int nextx=i+pathx[k];
			int nexty=j+pathy[k];
			if(isSafe(nextx, nexty, board)) {
				minStepToReachTarget(nextx, nexty, ed1, ed2,board,dist+1);
			}
		}
		visited[i][j]=0;
	}
}
