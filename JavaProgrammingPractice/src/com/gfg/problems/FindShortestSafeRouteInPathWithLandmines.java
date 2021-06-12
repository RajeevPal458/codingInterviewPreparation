package com.gfg.problems;

import java.util.Arrays;

public class FindShortestSafeRouteInPathWithLandmines{
	static int status[][];
	static int safeMat[][];
	static int[] movex={0,1,-1,0};
	static int[] movey={1,0,0,-1};
	static int M=12,N=10;
	FindShortestSafeRouteInPathWithLandmines(int[][] mat){
		status=new int[M][N];
		safeMat=new int[M][N];
		for(int i=0;i<M;i++){
			for(int j=0;j<N;j++){
				if(mat[i][j]==0){
					for(int k=0;k<movex.length;k++){
						if(isValid(i+movex[k],j+movey[k]))
							safeMat[i+movex[k]][j+movey[k]]=-1;
					}
				}
			}
		}
	}
	boolean isValid(int x, int y)
	{
	    if (x < M && y < M && x >= 0 && y >= 0)
	        return true;
	 
	    return false;
	}
	public static void initializeStatus(){
		for(int i=0;i<M;i++){
			for(int j=0;j<N;j++){
				status[i][j]=0;
			}
		}
	}
	public static void printPath(){
		for(int i=0;i<M;i++){
			for(int j=0;j<N;j++){
				System.out.print(status[i][j]+" ");
			}
			System.out.println();
		}
	}
	static int min=999999,pathlen=99999,path=0;
	static boolean flage=false;
	private static void findShortestPathUtil(int[][] mat,int row,int col) {
		//System.out.println("E");
		if(col==N){
			if(pathlen>path){
				pathlen=path;
				printPath();
			}
			flage=true;
			return ;
		}
		//System.out.println("1");
		if(row<0||row>=M||col<0||col>=N||(safeMat[row][col]==-1)||(mat[row][col]==0)||(status[row][col]==1))
			return ;
		//System.out.println(pathlen+" "+row+" "+col);
		for(int x=0;x<movex.length;x++){
			path++;
			status[row][col]=1;
			findShortestPathUtil(mat,row+movex[x],col+movey[x]);
			status[row][col]=0;
			path--;
		}
	}
	private static boolean findShortestPath(int[][] mat) {
		boolean f=false;
		for(int i=0;i<M;i++){
			//System.out.println(" "+i+" 0");
			if((safeMat[i][0]!=-1)&&(mat[i][0]!=0)){
				findShortestPathUtil(mat,i,0);
				if(flage==true){
					if(min>pathlen)
						min=pathlen;
					flage=false;
					f=true;
				}
				System.out.print("   :"+pathlen);
				System.out.println();
				initializeStatus();
				pathlen=99999;
				path=0;
			}
		}
		return f;
	}
	public static void main(String[] args) {
		int mat[][] =
		    {
		        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
		        { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
		        { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
		        { 1, 1, 1, 1, 0, 1, 1, 1, 1, 1 },
		        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
		        { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
		        { 1, 0, 1, 1, 1, 1, 1, 1, 0, 1 },
		        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
		        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
		        { 0, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
		        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
		        { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 }
		    };
		new FindShortestSafeRouteInPathWithLandmines(mat);
		    // find shortest path
		if( findShortestPath(mat))
		    System.out.println("Path  Found!"+min);
		else
			System.out.println("Path Not Found!");
		
	}

}
