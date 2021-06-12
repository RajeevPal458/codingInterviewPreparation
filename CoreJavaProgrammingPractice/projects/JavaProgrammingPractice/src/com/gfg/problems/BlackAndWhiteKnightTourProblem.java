package com.gfg.problems;

public class BlackAndWhiteKnightTourProblem {
	
	public static boolean isSafe(int[][] board,int row,int col,int n){
		boolean flage=true;
		
		for(int i=0;i<n;i++)
			if(board[row][i]==1)
				flage=false;
		for(int i=0;i<n;i++)
			if(board[i][col]==1)
				flage=false;
		for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
			if(board[i][j]==1)
				flage=false;
		}
		for(int i=row-1,j=col+1;i>=0&&j<n;i--,j++){
			if(board[i][j]==1)
				flage=false;
		}
		return flage;
	}
	public static boolean knightTour(int[][] board,int col,int collen){
		if(col==collen)
			return true;
		else{
			
			for(int row=0;row<collen;row++){
				
				if(isSafe(board, row, col, collen))
				{
					board[row][col]=1;
					
					if(knightTour(board,col+1,collen))
						return true;
					board[row][col]=0;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		int[][] board=new int[4][4];
		int n=board.length;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				board[i][j]=0;
			}
		}
		
		knightTour(board,0,n);
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
}
