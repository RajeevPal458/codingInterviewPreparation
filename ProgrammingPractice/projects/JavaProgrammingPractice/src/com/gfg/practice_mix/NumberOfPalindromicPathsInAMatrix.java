package com.gfg.practice_mix;

import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.sound.midi.SysexMessage;

public class NumberOfPalindromicPathsInAMatrix {
	static int R=3;
	static int C=4;
	static boolean[][] status;
	static int p=0;
	NumberOfPalindromicPathsInAMatrix(){
		
	}
	
	public static boolean isPelindromic(char[] str){
		int len=str.length;
		for(int i=0,j=len-1;i<len;i++,j--){
			if(str[i]!=str[j]){
				return false;
			}
		}
		return true;
	}
	public static boolean isSafe(int r,int c){
		if(r<0||r>=R||c<0||c>=C||status[r][c])
			return false;
		return true;
	}
	private static void printstatus(boolean st[][]) {
		for(int k=0;k<R;k++){
			for(int l=0;l<C;l++){
				System.out.print(status[k][l]+" ");
			}
			System.out.println();
		}
	}
	private static void getPalindromicPaths(char[][] mat,int i,int j,String str) {
		
		//System.out.println(" i:"+i+"  j:"+j);
		if((i==R-1)&&(j==C-1)){
			//System.out.println(str.toString());
				//printstatus(status);
				if(isPelindromic(str.toCharArray()))
				{
						System.out.println(str.toString());
					p++;
					return ;
				}
			return ;
		}
		if(isSafe(i+1, j)){
			status[i+1][j]=true;
			getPalindromicPaths(mat, i+1, j,str+mat[i+1][j]);
			status[i+1][j]=false;
		}
		if(isSafe(i, j+1)){
			status[i][j+1]=true;
			getPalindromicPaths(mat, i, j+1,str+mat[i][j+1]);
			status[i][j+1]=false;
		}
			
		}

	public static void main(String[] args) {
		char[][] mat ={{'a', 'a', 'a','b'},
				       {'b', 'a', 'a', 'a'},
				       {'a', 'b', 'b', 'a'}
	    		  };
		new NumberOfPalindromicPathsInAMatrix();
		status=new boolean[R][C];
		status[0][0]=true;
		getPalindromicPaths(mat,0,0,"a");
		System.out.println("Total Path:"+p);
	}

}
