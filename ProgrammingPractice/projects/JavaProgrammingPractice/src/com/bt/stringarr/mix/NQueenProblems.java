package com.bt.stringarr.mix;

public class NQueenProblems {
	final int N=4;
	int board[][];
	NQueenProblems(){
		board=new int[N][N];
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				board[i][j]=0;
	}
	public void printSolution(int[][] board){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++)
				System.out.print(board[i][j]+" ");
			System.out.println();
		}
	}
	public void solveNQ()
	{
	    if (!solveNQUtil(board, 0))
	      System.out.println("Solution does not exist");
	    System.out.println();
	    printSolution(board);
	}
	boolean isSafe(int board[][], int row, int col)
	{
	    int i, j;
	 
	    /* Check this row on left side */
	    for (i = 0; i < N; i++)
	        if (board[row][i]==1)
	            return false;
	 
	    /* Check upper diagonal on left side */
	    for (i=row, j=col; i>=0 && j>=0; i--, j--)
	        if (board[i][j]==1)
	            return false;
	 
	    /* Check lower diagonal on left side */
	    for (i=row, j=col; j>=0 && i<N; i++, j--)
	        if (board[i][j]==1)
	            return false;
	 
	    return true;
	}
	 public boolean solveNQUtil(int[][] board,int col){
		 if(col>=N)
			 return true;
		 //for each rows
		 for (int i = 0; i < N; i++)
		    {
		        if ( isSafe(board, i, col))
		        {
		            board[i][col] = 1;
		 
		            if ( solveNQUtil(board, col + 1) )
		                return true;
		            board[i][col] = 0; 
		        }
		    }
		    return false;
	 }

	public static void main(String[] args) {
		NQueenProblems nqp=new NQueenProblems();
		nqp.solveNQ();
	}
}
