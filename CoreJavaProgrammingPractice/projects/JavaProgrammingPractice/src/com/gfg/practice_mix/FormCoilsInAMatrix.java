package com.gfg.practice_mix;

import java.util.Scanner;

public class FormCoilsInAMatrix {

	static int n;
	static int R,C;
	public static void formCoils(int[][] mat,int[] coil1,int[] coil2,int l1,int l2){
		
		int step=1;
		
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("Entert a possitiv number ");
		n=Integer.parseInt(sc.nextLine());
		R=4*n;
		C=4*n;
		int[][] mat=new int[R][C];
		System.out.println(mat[0].length);
		int num=1;
		for(int i=0;i<R;i++){
			for(int j=0;j<C;j++){
				mat[i][j]=num++;
			}
		}
		for(int i=0;i<R;i++){
			for(int j=0;j<C;j++){
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
		int[] coil1=new int[R*(C/2)];
		int[] coil2=new int[R*(C/2)];
		FormCoilsInAMatrix.formCoils(mat, coil1, coil2,coil1.length,coil2.length);
		
	}
}
