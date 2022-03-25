package org.leet.code.goldmansachs;

//560. Subarray Sum Equals K
//for non negative value
//https://www.geeksforgeeks.org/find-subarray-with-given-sum/
public class FindSubArrayOfGivenSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 15, 2, 4, 8, 9, 5, 10, 23 };
		int sum = 23;
		subArrayOfSum(arr,sum,arr.length);
				
	}

	private static void subArrayOfSum(int[] arr, int sum, int length) {
		
		int currSum=0;
		int j=0;
		for (int i = 0; i < arr.length; i++) {
			currSum +=arr[i];
			
			while (currSum>sum && j<i) {
				currSum -=arr[j++];
			}
			
			if(currSum==sum) {
				System.out.println("Ans : sub array > ("+j+","+i+") , sum :"+currSum);
				continue;
			}
			
			//System.out.println(":j:"+j+":i:"+i+":currSum:"+currSum);
		}
	}

}
