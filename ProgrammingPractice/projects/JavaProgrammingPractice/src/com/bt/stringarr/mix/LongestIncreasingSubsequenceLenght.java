package com.bt.stringarr.mix;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequenceLenght {
	//recursive approach....
	static int max_lis_length; // stores the final LIS
	 
	// Recursive implementation for calculating the LIS
	static int _lis(int arr[], int n)
	{
		//System.out.print(n+" ");
	    // base case
	    if (n == 1)
	        return 1;
	 
	    int current_lis_length = 1;
	    for (int i=0; i<n-1; i++)
	    {
	        // Recursively calculate the length of the LIS
	        // ending at arr[i]
	        int subproblem_lis_length = _lis(arr, i+1);
	 
	        // Check if appending arr[n-1] to the LIS
	        // ending at arr[i] gives us an LIS ending at
	        // arr[n-1] which is longer than the previously
	        // calculated LIS ending at arr[n-1]
	        if (arr[i] < arr[n-1] &&
	            current_lis_length < (1+subproblem_lis_length))
	            current_lis_length = 1+subproblem_lis_length;
	    }
	 
	    // Check if currently calculated LIS ending at
	    // arr[n-1] is longer than the previously calculated
	    // LIS and update max_lis_length accordingly
	    if (max_lis_length < current_lis_length)
	        max_lis_length = current_lis_length;
	 
	    return current_lis_length;
	}
	 
	// The wrapper function for _lis()
	static int lis(int arr[], int n)
	{    
	    max_lis_length = 1; // stores the final LIS
	 
	    // max_lis_length is declared static above 
	    // so that it can maintain its value
	    // between the recursive calls of _lis()
	    _lis( arr, n );
	 
	    return max_lis_length;
	}
	//dp approach..
	public static int lISubsequence(int[] arr,int n){
		int[] dp=new int[n+1];
		for(int i=0;i<=n;i++)
			dp[i]=1;
		for(int i=1;i<n;i++){
			for(int j=0;j<i;j++){
				if(arr[j]<arr[i]){
					if(dp[j]+1>dp[i])
						dp[i]=dp[j]+1;
				}
			}
		}
		System.out.println(Arrays.toString(dp));
		int max=0;
		for (int i = 0; i < n; i++ )
	        if (max < dp[i])
	            max = dp[i];
		return max;
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
		int[] arr={3,4,-1,0,6,2,3};
		System.out.println(lISubsequence(arr,arr.length));
		System.out.println(lis(arr,arr.length));
	}
}
