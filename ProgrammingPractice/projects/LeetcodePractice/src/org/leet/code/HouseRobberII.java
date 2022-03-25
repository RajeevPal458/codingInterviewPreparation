package org.leet.code;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//{2,3,2}
		//[1,2,1,1]
		//[200,3,140,20,10]
		int[] arr = {200,3,140,20,10};
		int robbing = rob(arr);
		System.out.println("Robbing:-"+robbing);
	}
	
	 public static int rob(int[] nums) {
	        int len =nums.length;
	        if(nums==null || len==0) return 0;
	        if(len==1) return nums[0] ;
	        
	        int[] arr = new int[nums.length];
		    for(int i=0;i<nums.length;i++)
		        arr[i] = nums[i];
		    
		    nums[0]=0;
		    arr[arr.length-1]=0;
		   return Math.max(solve(nums,0,new HashMap<>()),solve(arr,0,new HashMap<>()));
	    }
	   
	 public static int solve(int arr[], int i, Map<Integer,Integer> dp){
	        if(i>=arr.length) return 0;
	        if(dp.containsKey(i)) return dp.get(i);
	        
	         int ans = Math.max(arr[i] +solve(arr,i+2,dp),solve(arr,i+1,dp));
	        dp.put(i, ans);
	        return ans;
	    }

}
