package com.gfg.problems;

public class LongestPossibleRouteInAMatrixWithHurdles {
	static boolean[][] status;
	static int[] pathArrx={1,0,-1,0};
	static int[] pathArry={0,1,0,-1};
	static int R=3,C=10;
	public LongestPossibleRouteInAMatrixWithHurdles(){
		status=new boolean[3][10];
		for(int i=0;i<3;i++){
			for(int j=0;j<10;j++){
				status[i][j]=false;
			}
		}
	}
	public static boolean visited(int row,int col){
		
		return status[row][col];
	}
	public static boolean isSafe(int mat[][],int i,int j){
		return mat[i][j]!=0;
	}
	static int maxPath=0,path=0;
	static boolean found=false;
	private static void findLongestPath(int[][] mat, int i, int j, int m, int n) {
		// TODO Auto-generated method stub
		if((i==m)&&(j==n))
		{
			if(maxPath<path)
				maxPath=path;
			return ;
		}
		if (i < 0 || i >=R || j < 0 || j >=C || mat[i][j] == 0 || status[i][j])
	        return ;
		
		for(int x=0;x<pathArrx.length;x++){
			path++;
			status[i][j]=true;
			findLongestPath(mat,i+pathArrx[x],j+pathArry[x],m,n);
			
			status[i][j]=false;
			path--;
		}
	}
	public static void main(String[] args) {
		int mat[][] ={  { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
						{ 1, 1, 0, 1, 1, 0, 1, 1, 0, 1 },
		        		{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
		    		  };
		    // find longest path with source (0, 0) and
		    // destination (1, 7)
		new LongestPossibleRouteInAMatrixWithHurdles();
		findLongestPath(mat, 0, 0, 1, 7);
		 System.out.println("Longest path possible route is:"+maxPath);
	}
}
