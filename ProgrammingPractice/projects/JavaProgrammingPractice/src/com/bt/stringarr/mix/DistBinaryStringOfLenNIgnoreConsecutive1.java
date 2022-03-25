package com.bt.stringarr.mix;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DistBinaryStringOfLenNIgnoreConsecutive1 {

	public static void printBinaryStringOfGivenLen(int n){
		List<String> end0=new ArrayList<>() ;
		end0.add(0, "0");
		List<String> end1=new ArrayList<>() ;
		end1.add(0, "1");
		for(int i=1;i<n;i++){
			List<String> next0=new ArrayList<>() ;
			List<String> next1=new ArrayList<>();
			
			for(int j=0;j<end0.size();j++){
				next0.add(end0.get(j).concat("0"));
				next1.add(end0.get(j).concat("1"));
			}
			for(int j=0;j<end1.size();j++){
				next0.add(end1.get(j).concat("0"));			}
			end0=new ArrayList<>(next0);
			end1=new ArrayList<>(next1);
			
		}
		end0.addAll(end1);
			System.out.print(end0.toString());
		System.out.println();
	}
	static int count=0;
	public static void recursiveUtill(int[] data,int k,int n){
		if(k==n){
			System.out.println(Arrays.toString(data)+" ");
			count++;
			return ;
		}
		if(data[k-1]==0)
		{
			data[k]=0;
			recursiveUtill(data,k+1,n);
			data[k]=1;
			recursiveUtill(data, k+1, n);
		}
		if(data[k-1]==1)
		{
			data[k]=0;
			recursiveUtill(data, k+1, n);
		}
	}
	public static void recursive(int n){
		int[] data=new int[n];
		data[0]=0;
		recursiveUtill(data,1, n);
		data[0]=1;
		recursiveUtill(data,1, n);
	}
	public static  int findbinaryStrings(int n){
		int a[];
		int b[];
		a=new int[n];
		b=new int[n];
		a[0]=b[0]=1;
		for(int i=1;i<n;i++){
			a[i]=a[i-1]+b[i-1];
			b[i]=a[i-1];
		}
		return a[n-1]+b[n-1];
	}
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		System.out.println("Please enter number to find max number of Binary strings");;
		int n=Integer.parseInt(sc.nextLine());
		System.out.println(findbinaryStrings(n));
		printBinaryStringOfGivenLen(n);
		System.out.println();
		recursive(n);
		System.out.println("Count:"+count);
		
	}
}
