package com.bt.stringarr.mix;
import java.util.Arrays;

public class MinimumNumberOfJumpsToReachEnd {
	int[] jumpPos;
	int jumpIndex=0;
	MinimumNumberOfJumpsToReachEnd(int n){
		jumpPos=new int[n];
	}
	public void findMinJumps(int[] arr,int n){
		int j,nextpos,netpos1,netpos2,min=999999,max=0;
		int i=0;
		boolean flage=false;
		jumpPos[jumpIndex++]=arr[0];
		while(i<n){

			if(arr[i]==0)
				break;
			if(arr[i]==1){ 
				i++;
				jumpPos[jumpIndex++]=arr[i];
				continue;
			}
			nextpos=i+arr[i];
			if(nextpos>=n)
			{
				jumpPos[jumpIndex++]=arr[n-1];
				break;
			}
			else
			while(nextpos>i){
				
				if(arr[nextpos]>=n-i-1&&arr[nextpos]<min){
					min=arr[nextpos];
					netpos1=nextpos;
					flage=true;
				}
				if(max<arr[nextpos])
				{
					max=arr[nextpos];
					netpos2=nextpos;
				}
				nextpos--;
			}
			if(flage)
				i=min;
			else
				i=max;
			jumpPos[jumpIndex++]=arr[i];
		}
		

	}
	public void printJumps(int[] jumpArr,int index){
		
		for(int i=0;i<index;i++)
		{
			System.out.print(jumpArr[i]+" ");
		}	
		System.out.println();
	}
	
	//Recursive approch
	public static  int minJumps_Recursive(int arr[], int jumps,int curr, int n){
	    if(curr>=n-1) return jumps;
	    
	    int min=Integer.MAX_VALUE;
	    for(int i=arr[curr];i>0;i--) {
	    	min = Math.min(min, minJumps_Recursive(arr, jumps+1, curr+i, n));
	    }
	    
	    return min;
	}
		
	//Dynamic approch
	public static  int minJumps(int arr[], int n){
    		int[] jumps = new int[n];  // jumps[n-1] will hold the result
    		int i, j;
 
    		if (n == 0 || arr[0] == 0)
        	return 99999;
    		jumps[0] = 0;
    		// Find the minimum number of jumps to reach arr[i]
    		// from arr[0], and assign this value to jumps[i]
    		for (i = 1; i < n; i++)
    		{
        		jumps[i] = Integer.MAX_VALUE;
        		for (j = 0; j < i; j++)
        		{
            		if (i <= j + arr[j] && jumps[j] != Integer.MAX_VALUE)
            		{
                 		jumps[i] = Math.min(jumps[i], jumps[j] + 1);
                 		break;
            		}
        		}
    		}
    		return jumps[n-1];
	}
	 
	public static void main(String[] args) {
		int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		int n=arr.length;
		MinimumNumberOfJumpsToReachEnd mjp=new MinimumNumberOfJumpsToReachEnd(n);
		mjp.findMinJumps(arr, n);
		System.out.println("Jump possissions!");
		mjp.printJumps(mjp.jumpPos,mjp.jumpIndex);
		System.out.println("Minimum jumps:"+(mjp.jumpIndex-1));
		
		System.out.println();
		int jumps = minJumps(arr, n);
		System.out.println("Jumps:-"+jumps);

		
		System.out.println();
		int jumps_rec = minJumps_Recursive(arr,0,0, n);
		System.out.println("jumps_rec:-"+jumps_rec);
	
	}
}
