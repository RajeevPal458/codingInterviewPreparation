package com.bt.stringarr.mix;
//Given an array of integers where each element points to the   index of the next element how would you detect if there is a cycle in this array? 
public class DetectCycleInArray {

	public static boolean DetectCycle1(int arr[], int len) {
	    
	    int slow = 0;
	    int fast = 0;
	    int cur = 0;
	    
	    while (cur < len) {
	    
	        if (arr[slow] >= 0 && arr[slow] < len) {
	        
	            slow = arr[slow];
	            System.out.println("slow :"+slow);
	        } else {
	        	System.out.println("slow :"+slow);
	            ++slow;
	            fast = slow;
	            cur = slow;
	            continue;
	        }
	        
	        int i = 0;
	        while (i < 2 && arr[fast] >= 0 && arr[fast] < len) { //move fast two steps one time
	        	
	            fast = arr[fast];
	            System.out.println("fast :"+fast);
	            ++i;
	        }
	        
	        if (i < 2) { //less than two steps
	        
	            ++fast;
	            slow = fast;
	            cur = fast;
	            
	        } else { //already move two steps
	        
	                 if (fast == slow) { //if a cycle exists, they must meet
	                	 System.out.println("index :"+fast);
	                     return true;
	                     
	                 } 
	            
	        }
	    }
	    
	    return false;
	}

	
	public void detectCycle(int[] arr,int n){
		int slow=0,fast=0;
		boolean flag=false;
		while(true){
			slow=arr[slow];
			fast=arr[arr[fast]];
			System.out.println(" fast:"+fast);
			if(slow==fast)
			{
				flag=true;
				System.out.println("fount cycle at :"+slow);
				break;
			}	
		}
		if(fast>=n)
			System.out.println("Cycle not present in arr");
	}
	public static void main(String[] args) {
		int[] arr={1,5,8,4,7,2,6,4,3};
		int e[] = {3,-2,-3,0};
		DetectCycleInArray dc=new DetectCycleInArray();
		dc.detectCycle(arr,arr.length);
		System.out.println();
		System.out.println();
		DetectCycle1(e,arr.length);
	}
}
