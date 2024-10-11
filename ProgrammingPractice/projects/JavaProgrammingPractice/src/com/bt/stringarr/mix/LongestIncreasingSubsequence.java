package com.bt.stringarr.mix;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {
	static int[][] dp;
	static int[][] pointer;
	static final int s1=1,s2=2;
	public static void lcsubSequence(int[] col,int[] row,int clen,int rlen){
		dp=new int[rlen][clen];
		pointer=new int[rlen][clen];
		dp[0][0]=0;
		//pointer[0][0]=-1;
		
		System.out.println();
		for(int i=0;i<rlen;i++){
			for(int j=0;j<clen;j++){
				if(row[i]==col[j]){
					
					if(i==0&&j==0)
						dp[i][j]=1;
					else
						if(i>0&&j>0)
							dp[i][j]=dp[i-1][j-1]+1;
					pointer[i][j]=s1/s2;
				}
				else{
					if(i>0&&j>0){
						if(dp[i][j-1]>dp[i-1][j]){
							dp[i][j]=dp[i][j-1];
							pointer[i][j]=s1;
						}
						else{
							dp[i][j]=dp[i-1][j];
							pointer[i][j]=s2;
						}
					}
					if((i==0)&&(j>0)){
						dp[i][j]=dp[i][j-1];
						pointer[i][j]=s1;
					}
					else if((j==0)&&(i>0)){
						dp[i][j]=dp[i-1][j];
						pointer[i][j]=s2;
					}	
				}
			}
		}
		
		int i=rlen-1;
		int j=clen-1;
		StringBuffer sb=new StringBuffer();
		while(i>=0&&j>=0){
			switch(pointer[i][j]){
			
				case s1/s2:sb.append(col[j]);
							i--;j--;break;
				case s1: j--;break;
				
				case s2: i--;break;
			}
		}
		//for(int p=sb.length()-1;i>=0;i--)
		System.out.println(sb.toString());
		
	}
	
	static int CeilIndex(int temp[], int l, int r, int key)
    {
        while(l<=r){
        	
        	int mid=l+(r-l)/2;
        	if(temp[mid]<key)
        		l=mid+1;
        	else if(temp[mid]>key)
        		r=mid;
        	if(l==r)
        		return l;
        	System.out.println("1");
        }
        return r;
    }
	static int LongestIncreasingSubsequenceLength(int A[], int length)
    {
        // Add boundary case, when array size is one
 
        int[] temp   = new int[length];
        int end; // always points empty slot
 
        temp[0] = A[0];
        end = 1;
        for (int i = 1; i < length; i++)
        {
            if (A[i] < temp[0])
                // new smallest value
                temp[0] = A[i];
 
            else if (A[i] > temp[end-1])
                // A[i] wants to extend largest subsequence
                temp[end++] = A[i];
 
            else
                // A[i] wants to be current end candidate of an existing
                // subsequence. It will replace ceil value in tailTable
                temp[CeilIndex(temp, 0, end-1, A[i])] = A[i];
        }
        System.out.println();
        System.out.println(Arrays.toString(temp));
        
        System.out.println();
        return end;
    }
 
	private static void lis(int[] arr, int length) {
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
	
	
	 public static int getCeilingValue(int[] temp,List<Integer> arr,int len,int num){
	        int start =0;
	        int end =len;
	        
	        while(start<=end){
	            int mid =(start+end)/2;
	            
	            if(num==arr.get(temp[mid])){
	                return mid;
	            }
	            if (num < arr.get(temp[mid])) {
	                end = mid - 1;
	            }
	 
	            else {
	                start = mid + 1;
	            }
	        }
	        return start;
	    }
	  
	    public static int longestIncreasingSubsequence(List<Integer> arr) {
	        int n =arr.size();
	        int[] temp = new int[n];
	        int len=0;
	        temp[len] =0;
	        
	        for(int i=1;i<n;i++){
	            if(arr.get(i) > arr.get(temp[len])){
	                temp[++len]=i;
	            }else{
	                int index =getCeilingValue(temp,arr,len,arr.get(i));
	                temp[index] =i;
	            }
	            
	        }
	        return len+1;
	    }

	
	public static void main(String[] args) {
		int[] arr={5,2,7,4,3,8};
		int[] arr2={3,4,-1,5,8,2,3,12,7,9,10};
		
		Arrays.sort(arr2);
		lcsubSequence(arr,arr2,arr.length,arr2.length);
		System.out.println();
		System.out.println();
		lis(arr,arr.length);
		System.out.println(LongestIncreasingSubsequenceLength(arr, arr.length));
		
		List<Integer> list = Arrays.stream(arr).boxed().toList();
		
		int size =longestIncreasingSubsequence(list);
		System.out.println("size:-"+size);
		
		
	}
}
