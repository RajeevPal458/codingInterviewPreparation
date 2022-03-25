package org.leet.code;

import java.util.HashMap;
import java.util.Map;

public class DeleteAndEarn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] nums = { 2,2,3,3,3,4} ;
				//[2,2,3,3,3,4] ,[8,7,3,8,1,4,10,10,10,2]
				//int nums[] = {8,3,4,7,6,6,9,2,5,8,2,4,9,5,9,1,5,7,1,4};
				int nums[] = {8,7,3,8,1,4,10,10,10,2};
				int result = deleteAndEarn1(nums);
				System.out.println(result);
	}

	static int solve(int arr[], int i, Map<Integer,Integer> dp){
        if(i>=arr.length) return 0;
        //if(dp.containsKey(i)) return dp.get(i);
        if(arr[i]==0){
            int ans = solve(arr,i+1,dp);
            //dp.put(i,ans);
            return ans;
        }
        int ans = Math.max(arr[i]*i+solve(arr,i+2,dp),solve(arr,i+1,dp));
       // dp.put(i,ans);
        return ans;
    }
    
    public static int deleteAndEarn1(int[] nums) {
        int max = 0;
        for(int i: nums) max = Math.max(max,i);
        int arr[] = new int[max+1];
        for(int i: nums) arr[i]++;
        Map<Integer,Integer> dp = new HashMap<>();
        return solve(arr,0,dp);
    }
}
