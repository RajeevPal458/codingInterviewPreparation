package org.interview.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindPairEqualToTargetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {2,4,1,5,3,5,2,3,7,3,7,7,3};
		int targetSum = 10;
		
		findPair(arr,targetSum);

	}

	private static void findPair(int[] arr, int targetSum) {
		
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		
		for(int i=0;i<arr.length;i++) {
			if(map.containsKey(targetSum-arr[i])) {
				int count =map.get(targetSum-arr[i]);
				while(count-->0)
					System.out.println("("+arr[i]+","+(targetSum-arr[i])+")");
			}
			map.put(arr[i],map.getOrDefault(arr[i], 0)+1);
			System.out.println(i+"="+arr[i]);
			
		}
		
	}

}
