package com.gfg.problems;

public class BacktrackingSet7Sudoku {
	static int N=9;
	static int UNASSIGNED=0;
	
	public static class Blok{
		int row;
		int col; 
	}
	private static void printGrid(int[][] grid) {
		// TODO Auto-generated method stub
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				System.out.print(grid[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	public static boolean FindUnassignedLocation(int grid[][],Blok b)
	{
	    for (b.row = 0; b.row < N;b.row++)
	        for (b.col = 0; b.col < N; b.col++)
	            if (grid[b.row][b.col] == UNASSIGNED)
	                return true;
	    return false;
	}
	public static boolean isSafe(int[][] grid,int row,int col,int num){
		for(int i=0;i<9;i++)
			if(grid[row][i]==num)
				return false;
		for(int i=0;i<9;i++)
			if(grid[i][col]==num)
				return false;
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(grid[i+(row-row%3)][j+(col-col%3)]==num)
					return false;
			}
		}
		return true;
	}
	private static boolean SolveSudoku(int[][] grid) {
		Blok b=new Blok();
		if(!FindUnassignedLocation(grid,b))
			return true;
		//System.out.println("["+Row.row+"]["+Col.col+"]"+"  ");
		for(int num=1;num<=9;num++){
			//System.out.print(num+" ");
			if(isSafe(grid, b.row, b.col, num)){
				grid[b.row][b.col]=num;
				
				if(SolveSudoku(grid))
					return true;
				grid[b.row][b.col]=UNASSIGNED;
				//System.out.print("R");
			}
			
		}
		return false;
	}
	public static void main(String[] args) {
		int [][]grid = { {3, 0, 6, 5, 0, 8, 4, 0, 0},
                 		 {5, 2, 0, 0, 0, 0, 0, 0, 0},
                 		 {0, 8, 7, 0, 0, 0, 0, 3, 1},
                 		 {0, 0, 3, 0, 1, 0, 0, 8, 0},
                 		 {9, 0, 0, 8, 6, 3, 0, 0, 5},
                 		 {0, 5, 0, 0, 9, 0, 6, 0, 0},
                 		 {1, 3, 0, 0, 0, 0, 2, 5, 0},
                 		 {0, 0, 0, 0, 0, 0, 0, 7, 4},
                 		 {0, 0, 5, 2, 0, 6, 3, 0, 0}
                 		};
		if (SolveSudoku(grid) == true)
			printGrid(grid);
		else
			System.out.println("No solution exists");
	}

}
