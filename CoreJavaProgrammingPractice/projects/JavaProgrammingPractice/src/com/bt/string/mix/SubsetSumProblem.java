package com.bt.string.mix;

public class SubsetSumProblem {
	public static boolean isAvailSum(int arr[],int n,int num){
		boolean flage=false;
		int sum=0;
		for(int i=0;i<1<<n;i++){
			for(int j=0;j<n;j++){
				if(( i & (1 << j) )>0)
					sum +=arr[j];
			}
			if(sum==num)
				flage=true;
			sum=0;
		}	
		return flage;
	}
	public static boolean isSumAvail(int arr[],int n,int sum){
		if(sum==0)
			return true;
		if(n==0&&sum!=0)
			return false;
		if(arr[n-1]>sum)
			isSumAvail(arr, n-1,sum);
		return isSumAvail(arr, n-1, sum)||isSumAvail(arr, n-1,sum-arr[n-1]);
	}
	public static void main(String[] args) {
		int arr[]={3,34,4,12,5,2};
		System.out.println(isSumAvail(arr,arr.length,11));;
		
	}
}
