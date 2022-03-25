package org.algo.strarr;
// https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/
// https://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
public class FindLongestIncreesingsubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,4,-1,0,6,2,3};
		int len =arr.length;
		//liss(arr,len);
		lissNlogN(arr, len);
		
		System.out.println(":longes increasing subsequence length:");
		liss(arr, len);
	}
	
	//Time complexity : n^2
	private static void liss(int[] arr, int len) {
		// TODO Auto-generated method stub 3,4,-1,0,6,2,3
		int[] temp = new int[len];
		int max=0;
		for(int i=0;i<len;i++)
			temp[i] =1;
		int j=0;
		for(int i=1;i<len;i++) {
			j=0;
			while (j<i) {
				if(arr[i]>arr[j]) {
					if(temp[i]<temp[j]+1) {
						temp[i]=temp[j]+1;
						if(temp[i]>max) max= temp[i];
					}
				}
				j++;
			}
		}
		
		System.out.println("MAX:"+max);
	}
	
	//Time complexity : nlogn  3,4,-1,0,6,2,3 longest increasing subsequence array and length
		private static void lissNlogN(int[] arr, int length) {
				int end=0;
				int temp[]=new int[length];
				int j,t=0;
				temp[t]=0;
				for(int i=1;i<length;i++){
					
					if(arr[temp[end]]<arr[i])
					{
						temp[++end]=i;
					}
					else{
						j=0;
						while(j<=end&&arr[i]>arr[temp[j]])
							j++;
						
						temp[j]=i;
						
					}
				}
				for(int i=0;i<=end;i++)
					System.out.print(arr[temp[i]]+" ");
				System.out.println();
				System.out.println("length of sub sequence:"+(end+1));
		}

}
