package org.algo.strarr;
import java.io.*;
import java.util.*;
public class FindAllSubSetOfAnArray {

	/*package whatever //do not write package name here */
		public static void
		findSubsets(List<List<Integer>> subset, ArrayList<Integer> nums, ArrayList<Integer> output, int index)
		{
		// Base Condition
			if (index == nums.size()) {
				//System.out.println("output:"+output);
				if(!output.isEmpty())
					subset.add(output);
				return;
			}
		
			// Not Including Value which is at Index
			//System.out.println("index1:"+index);
			findSubsets(subset, nums, new ArrayList<>(output), index + 1);
			//System.out.println("index2:"+index);
			// Including Value which is at Index
			output.add(nums.get(index));
			findSubsets(subset, nums, new ArrayList<>(output), index + 1);
		}
		
		public static void printPowerSet(int arr[], int n)
		{
		    List<String> list;
		 
		    /* Run counter i from 000..0 to 111..1*/
		    for (int i = 0; i < (int) Math.pow(2, n); i++)
		    {
		       StringBuffer sb = new StringBuffer();
		 
		        // consider each element in the set
		        for (int j = 0; j < n; j++)
		        {
		            // Check if jth bit in the i is set. If the bit
		            // is set, we consider jth element from set
		            if ((i & (1 << j)) != 0)
		            	sb.append(arr[j]+" ");
		        }
		 
		       System.out.println(sb.toString());
		    }
		 
		}
		
		//https://www.geeksforgeeks.org/print-all-possible-combinations-of-r-elements-in-a-given-array-of-size-n/
		//https://www.geeksforgeeks.org/print-subsets-given-size-set/
		private static void subSet(int[] arr, int n) {
			// TODO Auto-generated method stub
			/*
			 * for(int r=1;r<=n;r++) { int[] data = new int[r];
			 * printAllCombinationsUtill(arr, 0, n, r, data, 0,sum); }
			 */
			
		/*	for(int i=1;i<=arr.length;i++){
				int[] data = new int[i];
				//subSetUtill(arr, data, 0,0,i, n);
				subSetUtill2(arr, data, 0,0,i, n);
			}*/
			
			for(int i=0;i<=arr.length;i++){
				List<Integer> list = new ArrayList<Integer>();
				//subSetUtill(arr, data, 0,0,i, n);
				subSetUtill3(arr , 0,list,i, n);
			}
			
		}
		// subset with no duplicates
		public static void subSetUtill(int[] arr,int[] data,int start,int index,int size ,int n){
			if(index == size){
				System.out.println(Arrays.toString(data));
				return ;
			}
			for(int i=start;i<n&&index<n;i++){
				data[index]=arr[i];
				subSetUtill(arr,data,i+1,index+1 ,size ,n);
				data[index]=0;
				while(i+1<n && arr[i]==arr[i+1]) {
					i++;
				}
			}
		}
		
		public  static void subSetUtill2(int[] arr,int[] data,int start,int index,int size ,int n){
		// Current combination is ready to be printed, print it
			if (index == size)
			{
				System.out.println(Arrays.toString(data));
				return ;
			}
			
			// When no more elements are there to put in data[]
			if (start >= n)
			return;
			
			// current is included, put next at next location
			data[index] = arr[start];
			subSetUtill2(arr,data ,start+1,index+1 ,size, n);
			
			// current is excluded, replace it with next (Note that
			// i+1 is passed, but index is not changed)
			subSetUtill2(arr,data ,start+1,index ,size, n);
		}
		
		public  static void subSetUtill3(int[] arr,int start,List<Integer> list,int k ,int n){
			// Current combination is ready to be printed, print it 1 2 3
				if (list.size() == k)
				{
					System.out.println(list);
					return ;
				}
				
				// current is included, put next at next location
				for(int i=start;i<n;i++){
					list.add(arr[i]);
					subSetUtill3(arr,i+1,list ,k, n);
					if(list.size()>0)
						 list.remove(list.size()-1);
				}
		}
		
		

		public static void allSubsets(int[] arr ,int start , List<Integer> output) 
		{
		  if(start == arr.length) 
		  { 
			  if(!output.isEmpty())
		     System.out.println(output);
		     return ;
		  }
		  
		  allSubsets(arr,start+1, new ArrayList<Integer>(output) );
		  
		  output.add(arr[start]);
		  allSubsets(arr,start+1, new ArrayList<Integer>(output));
		}
		
		public static void allSubsetSequence(int[] arr , int n){
			String subset="";
			for(int i=0;i<n;i++){
				for(int j=i;j<n;j++){
					subset +=arr[j]+" ";
					System.out.println(subset);
				}
				subset="";
			}
			
		}
		public static void main(String[] args) {
		
		//Main List for storing all subsets
		List<List<Integer>> subset = new ArrayList<>();
		
		// Input ArrayList
		ArrayList<Integer> input = new ArrayList<>();
		input.add(1);
		input.add(2);
		input.add(3);
		
		findSubsets(subset, input, new ArrayList<>(), 0);
		
		int arr[] = { 1, 2, 3};
	    int n = arr.length;
	 
	    printPowerSet(arr, n);
		
	    
	    System.out.println("-printPowerSet---------------------------------------------------1");
	    allSubsets(arr, 0, new ArrayList<Integer>());
	    
	    System.out.println("----------------------------------------------------2");
	    
	    subSet(arr, n);
	    System.out.println("----------------------------------------------------3");
	    
	    allSubsetSequence(arr,n);
		// Printing Subset
		/*for(int i = 0; i < subset.size(); i++){
			for(int j = 0; j < subset.get(i).size(); j++){
				System.out.print(subset.get(i).get(j) + " ");
			}
			System.out.println();
		}*/
		
		}
}
