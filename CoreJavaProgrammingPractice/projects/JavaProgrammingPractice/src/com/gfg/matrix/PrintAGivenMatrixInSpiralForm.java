package com.gfg.matrix;

import java.util.Arrays;

public class PrintAGivenMatrixInSpiralForm {
	
	public static void spiralPrint(int R,int C,int[][] a){
		
		int r=0,c=0;
		int[] spiral=new int[R*C];
		int index=0;
		while (r<R&&c<C) {
			
			for(int i=c;i<C;i++){
				spiral[index++]=a[r][i];
			}
			r++;
			for(int i=r;i<R;i++){
				spiral[index++]=a[i][C-1];
			}
			C--;
			
			if(r<R){
				
				for(int i=C-1;i>=c;i--){
					spiral[index++]=a[R-1][i];
				}
				R--;
			}
			
			if(c<C){
				
				for(int i=R-1;i>=r;i--){
					spiral[index++]=a[i][c];
				}
				c++;
				
			}
			
		}
		
		System.out.println(Arrays.toString(spiral));
		
	}
	
	public static void main(String[] args) {
		int R=3,C=6;
		int a[][] = { {1,  2,  3,  4,  5,  6},
		        	  {7,  8,  9,  10, 11, 12},
		        	  {13, 14, 15, 16, 17, 18}
		    		};
		 
		    spiralPrint(R, C, a);
	}
}
