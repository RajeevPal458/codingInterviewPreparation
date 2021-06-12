package com.bt.stringarr.mix;
import java.util.Arrays;
import java.util.Scanner;

//how many ways a given number can be written using Two or more possitive integers...
//let N=5,1+1+1+1+1,1+1+1+2,1+2+2,1+1+3,2+3,1+4
public class HowManyWaysNcanBeWriteUsingDiffNum {
	int N;
	
	public HowManyWaysNcanBeWriteUsingDiffNum(int N){
		this.N=N;
	}
	private void printNumbers(int[] data, int index) {
		for(int i=0;i<index;i++)
		{
			System.out.print(data[i]);
			if(i!=index-1)
				System.out.print("+");
		}
		System.out.println();
		
	}
	int count=0;
	private void numberOfWaysUtill(int[] arr, int[] data, int start, int end, int index,int sum, int t_sum) {
		// TODO Auto-generated method stub
		if(sum==t_sum){
			printNumbers(data,index);
			count++;
			return ;
		}
		
		for(int i=start;i<=end&&index<data.length;i++){
			data[index]=arr[i];
			numberOfWaysUtill(arr,data,i,end,index+1,sum+arr[i],t_sum);
		}
		
	}
	public int numberOfWays(){
		int[] arr=new int[N-1];
		int[] data=new int[N];
		for(int i=1;i<N;i++)
			arr[i-1]=i;
		
		numberOfWaysUtill(arr,data,0,arr.length-1,0,0,N);
		return count;
	}
	//dp aproach!
	public int numberOfWaysDP(){
		int[] dp=new int[N+1];
		dp[0]=1;
		
		for(int i=1;i<N;i++){
			
			for(int j=i;j<=N;j++){
				dp[j]+=dp[j-i];
			}
			System.out.println(Arrays.toString(dp));
		}
		return dp[N];
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number \n");
		int N=Integer.parseInt(sc.nextLine());
		HowManyWaysNcanBeWriteUsingDiffNum sp= new HowManyWaysNcanBeWriteUsingDiffNum(N);
		System.out.println("Number of ways:"+sp.numberOfWays());
		
		System.out.println("DP Approach Number of ways:"+sp.numberOfWaysDP());
		
	}
}
