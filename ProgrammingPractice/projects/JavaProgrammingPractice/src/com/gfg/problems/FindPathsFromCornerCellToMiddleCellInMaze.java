package com.gfg.problems;

public class FindPathsFromCornerCellToMiddleCellInMaze {
	static int[][] status;
	static int[] movex={1,0,-1,0};
	static int[] movey={0,1,0,-1};
	static Possition[] positions;
	static int R=9,C=9,pos;
	public static void initialize(){
		positions=new Possition[30];
		status=new int[R][C];
		for(int i=0;i<R;i++){
			for(int j=0;j<C;j++){
				status[i][j]=0;
			}
		}
	} 
	public static boolean isValid(int i,int j){
		if(i<0||i>=R||j<0||j>=R||status[i][j]==1)
			return false;
		return true;
	}
	public static void printPath(Possition[] poss,int n){
		
		for(int i=0;i<n;i++){
			Possition p=poss[i];
			System.out.print("("+p.x+","+p.y+")"+" ");
		}
	}
	private static boolean findPathInMazeUtil(int[][] maze,int i,int j,int index) {
		
		if(!isValid(i, j))
			return false;
		if(maze[i][j]==0){
			positions[index]=new Possition(i,j);
			positions[index+1]=new Possition(4,4);
			printPath(positions, index);
			return true;
		}
		
		for(int mov=0;mov<movex.length;mov++){
			positions[index]=new Possition(i,j);
			status[i][j]=1;
			if(findPathInMazeUtil(maze,i+movex[mov]*maze[i][j],j+movey[mov]*maze[i][j], index+1))
				return true;
			status[i][j]=0;
			positions[index]=null;
		}
		
		return false;
	}
	private static void findPathInMaze(int[][] maze) {
		initialize();
		if(findPathInMazeUtil(maze,0,0,0))
		{
			System.out.println("Found!");
			
		}
		else
			System.out.println("Not Found!");
	}
	public static void main(String[] args) {
		int maze[][] ={
		        { 3, 5, 4, 4, 7, 3, 4, 6, 3 },
		        { 6, 7, 5, 6, 6, 2, 6, 6, 2 },
		        { 3, 3, 4, 3, 2, 5, 4, 7, 2 },
		        { 6, 5, 5, 1, 2, 3, 6, 5, 6 },
		        { 3, 3, 4, 3, 0, 1, 4, 3, 4 },
		        { 3, 5, 4, 3, 2, 2, 3, 3, 5 },
		        { 3, 5, 4, 3, 2, 6, 4, 4, 3 },
		        { 3, 5, 1, 3, 7, 5, 3, 6, 4 },
		        { 6, 2, 4, 3, 4, 5, 4, 5, 1 }
		    };
		 
		    findPathInMaze(maze);
	}

	static class Possition{
		int x,y;
		Possition(){}
		Possition(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
}
