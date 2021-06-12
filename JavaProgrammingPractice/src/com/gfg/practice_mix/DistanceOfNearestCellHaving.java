package com.gfg.practice_mix;

import java.util.Arrays;

public class DistanceOfNearestCellHaving {
	static int R=3;
	static int C=4;
	static int[] movex={0,1};
	static int[] movey={1,0};
	static boolean[][] status;
	static int[][] pathlen;
	static int maxpath=0,min=10;
	public static boolean isSafe(int i,int j){
		if(i<0||i>=R||j<0||j>=C||status[i][j]==true)
			return false;
		return true;
	}
	public static void nearestCellUtil(int[][] mat,int i,int j){
		if(!isSafe(i, j))
			return ;
		if(mat[i][j]==1){
			if(min>maxpath)
				min=maxpath;
			return ;
		}
		//System.out.println();
		//System.out.print("MIN:"+min+" MaxPth:"+maxpath);
		for(int k=0;k<movex.length;k++){
			status[i][j]=true;
			maxpath++;
			nearestCellUtil(mat, i+movex[k], j+movey[k]);
			status[i][j]=false;
			maxpath--;
		}
	}
	public static void reInitialize(){
		status=new boolean[R][C];
		for(int i=0;i<R;i++){
			for(int j=0;j<C;j++){
				status[i][j]=false;
			}
		}
		min=10;
		maxpath=0;
	}
	public static void nearestCell(int[][] mat){
		reInitialize();
		pathlen=new int[R][C];
		for(int i=0;i<R;i++){
			for(int j=0;j<C;j++){
				if(mat[i][j]==0)
				{
					//System.out.println("MIN"+min+" MaxPth"+maxpath);
					nearestCellUtil(mat,i,j);
					pathlen[i][j]=min;
					reInitialize();
				}
			}
		}

	}
	public static void main(String[] args) {
		int[][] mat={
					  {0, 0, 0, 1},
					  {0, 0, 1, 1},
					  {0, 1, 1, 0}
					};
		nearestCell(mat);
		for(int i=0;i<R;i++)
			System.out.println(Arrays.toString(pathlen[i]));
		
	}
}
