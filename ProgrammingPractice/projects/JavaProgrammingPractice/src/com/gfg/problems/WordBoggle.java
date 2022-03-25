package com.gfg.problems;

import java.util.Arrays;
import java.util.Scanner;
/*
 * Input: dictionary[] = {"GEEKS", "FOR", "QUIZ", "GO"};
       boggle[][]   = {{'G','I','Z'},
                       {'U','E','K'},
                       {'Q','S','E'}};

Output:  Following words of dictionary are present
         GEEKS, QUIZ
 * */
public class WordBoggle {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Length of Dictionary!");
		int len=Integer.parseInt(sc.nextLine());
		System.out.println("Enter Strings separated by space");
		String[] str=(sc.nextLine()).split(" ");
		System.out.println("Enter size of matrix M*N separated by space(Row*Collumn)");
		String[] str1=(sc.nextLine()).split(" ");
		int m=Integer.parseInt(str1[0]);
		int n=Integer.parseInt(str1[1]);
		System.out.println("Enter elements of Matrix separated by spaces row wise");
		String[] str2=sc.nextLine().split(" ");
		char[][] boggle=new char[m][n];
		int x=0;
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				boggle[i][j]=str2[x++].charAt(0);
			}
		}
		System.out.println("dictionary[] "+Arrays.toString(str));
		System.out.println();
		System.out.println("boggle[][]  ");
		for(int i=0;i<m;i++){
			System.out.print(Arrays.toString(boggle[i]));
			System.out.println();
		}
		
	}
}
