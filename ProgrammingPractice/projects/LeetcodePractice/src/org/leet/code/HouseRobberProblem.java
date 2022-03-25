package org.leet.code;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {4,1,2,7,5,3,1};
		int robbing = rob(arr);
		System.out.println("Robbing:-"+robbing);
		
	}
	
	public static int rob(int[] nums) {
	       
		int len =nums.length;
	    if(nums==null || len==0) return 0;
	    if(len==1) return nums[0] ;
	        
		Map<Integer,Integer> dp = new HashMap<>();
	    return solve(nums,0,dp);
	}
	

	static int solve(int arr[], int i, Map<Integer,Integer> dp){
        if(i>=arr.length) return 0;
        if(dp.containsKey(i)) return dp.get(i);
        
        int ans = Math.max(arr[i] +solve(arr,i+2,dp),solve(arr,i+1,dp));
        dp.put(i, ans);
        return ans;
    }
    
    
	

}
