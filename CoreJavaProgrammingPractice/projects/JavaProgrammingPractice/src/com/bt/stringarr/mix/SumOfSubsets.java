package com.bt.stringarr.mix;

public class SumOfSubsets {
	int total_nodes=0;
	
	public void printSubset(int[] data,int size){
		for(int i=0;i<size;i++){
			System.out.print(data[i]+" ");
		}
		System.out.println();
	}
	public void generateSubsets(int[] arr,int[] data,int n,int start,int dataindex,int sum,int t_sum){
		
		if(sum==t_sum){
			printSubset(data,dataindex);
			total_nodes++;
			return ;
		}
		//if(start<n && sum+arr[start]<=t_sum){
			for(int i=start;i<=n;i++){
				data[dataindex]=arr[i];
						//if(sum+arr[i]<=t_sum)
							generateSubsets(arr,data,n,i+1,dataindex+1,sum+arr[i],t_sum);
			}
		//}
	}
	public void generateSubsets(int[] arr,int n,int t_sum){
		int[] data=new int[100];
		generateSubsets(arr,data,n-1,0,0,0,t_sum);
	}

	public static void main(String[] args) {
		int weights[] = {10, 7, 5, 18, 12, 20, 15};
	    int size =weights.length;
	    SumOfSubsets gs=new SumOfSubsets();
	    gs.generateSubsets(weights, size, 35);
	    System.out.println("TotalNodes:"+gs.total_nodes);
	    
	}
}
