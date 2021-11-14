package org.algo.matrix;

public class RatMoveInAMaze {
	final int N = 4;
	int sol[][];
	int[][] maze;
	RatMoveInAMaze(){
		sol=new int[N][N];
		maze=new int[N][N];
		for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++){
            	sol[i][j]=0;
            	maze[i][j]=0;
        	}
        }
		maze[0][0]=1;
		maze[1][0]=1;
		maze[1][1]=1;maze[2][1]=1;maze[3][0]=1;maze[3][1]=1;maze[3][2]=1;maze[3][3]=1;
	}
    /* A utility function to print solution matrix
       sol[N][N] */
    void printSolution(int sol[][])
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
                System.out.print(" " + sol[i][j] +" ");
            System.out.println();
        }
    }
 
    /* A utility function to check if x,y is valid
        index for N*N maze */
    boolean isSafe(int maze[][], int x, int y){
        return (x >= 0 && x < N && y >= 0 &&
                y < N && maze[x][y] == 1);
    }
    
   public void solveMaze()
    {
        if (!solveMazeUtil( maze,0,0,sol))
        {
            System.out.print("Solution doesn't exist");
            System.out.println();
        }
 
        printSolution(sol);
    }
   private boolean solveMazeUtil(int[][] maze, int i, int j, int[][] sol) {
	   sol[i][j] = 1;
	   if (i == N - 1 && j == N - 1)
		   return true;
	   
	    if(isSafe(maze,i+1,j))  
		   if(solveMazeUtil(maze, i + 1,j, sol))
			   return true;
		   /* If moving in x direction doesn't give
           	solution then  Move down in y direction */
	    if(isSafe(maze,i,j+1))  
		   if(solveMazeUtil(maze, i,j + 1, sol))
			   return true;
	   
	   return false;
   }

	public static void main(String[] args) {
		RatMoveInAMaze rmp=new RatMoveInAMaze();
		rmp.solveMaze();
	}
}
