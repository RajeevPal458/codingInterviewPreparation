package com.bt.arrTree.mix;

import java.util.Arrays;
import java.util.Comparator;

public class CountInversionsInAnArrayUsingBit {

	// Returns sum of arr[0..index]. This function assumes
	// that the array is preprocessed and partial sums of
	// array elements are stored in BITree[].
	public static int getSum(int BITree[], int index)
	{
	    int sum = 0; // Initialize result
	 
	    // Traverse ancestors of BITree[index]
	    while (index > 0)
	    {
	        // Add current element of BITree to sum
	        sum += BITree[index];
	 
	        // Move index to parent node in getSum View
	        index -= index & (-index);
	    }
	    return sum;
	}
	 
	// Updates a node in Binary Index Tree (BITree) at given index
	// in BITree.  The given value 'val' is added to BITree[i] and
	// all of its ancestors in tree.
	public static void updateBIT(int BITree[], int n, int index, int val){
	    // Traverse all ancestors and add 'val'
	    while (index <= n){
	       // Add 'val' to current node of BI Tree
	       BITree[index] += val;
	       // Update index to that of parent in update View
	       index += index & (-index);
	    }
	}
	// Returns inversion count arr[0..n-1]
	public static int getInvCount(int arr[], int n){
	    int invcount = 0; // Initialize result
	    // Find maximum element in arr[]
	    int maxElement = 0;
	    for (int i=0; i<n; i++)
	        if (maxElement < arr[i])
	            maxElement = arr[i];
	    // Create a BIT with size equal to maxElement+1 (Extra
	    // one is used so that elements can be directly be
	    // used as index)
	    int[] BIT=new int[maxElement+1];
	    for (int i=1; i<=maxElement; i++)
	        BIT[i] = 0;
	    // Traverse all elements from right.
	    for (int i=n-1; i>=0; i--){
	        // Get count of elements smaller than arr[i]
	        invcount += getSum(BIT, arr[i]-1);
	        System.out.println("invcount:"+invcount);
	        // Add current element to BIT
	        updateBIT(BIT, maxElement, arr[i], 1);
	        
	        System.out.println(Arrays.toString(BIT));
	    }
	    return invcount;
	}
	static class Node{
		int index;
		int val;
		public Node(int index,int val){
			this.index=index;
			this.val=val;
		}
	}
	public static void convert(int arr[], int n)
	{
	    // Create a copy of arrp[] in temp and sort the temp array
	    // in increasing order
	    Node[] temp=new Node[n];
	    for(int i=0;i<n;i++)
	        temp[i] = new Node(i,arr[i]);
	    Arrays.sort(temp,new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return (new Integer(o1.val)).compareTo(o2.val);
			}
		});
	    // Traverse all array elements
	    for (int i=0; i<n; i++)
	    {
	        System.out.print(temp[i].index+" : ");
	        System.out.print(temp[i].val);
	        System.out.println();
	    }
	    for (int i=0; i<n; i++)
	    {
	        arr[temp[i].index]=i+1;
	    }
	}
	 
	// Returns inversion count arr[0..n-1]
	public static int getInvCount1(int arr[], int n)
	{
	    int invcount = 0; // Initialize result
	    convert(arr,n);
	    System.out.println(Arrays.toString(arr));
	    int[] BIT=new int[n+1];
	    for (int i=1; i<=n; i++)
	        BIT[i] = 0;
	    // Traverse all elements from right.
	    for (int i=n-1; i>=0; i--){
	        // Get count of elements smaller than arr[i]
	        invcount += getSum(BIT, arr[i]-1);
	        // Add current element to BIT
	        updateBIT(BIT, n, arr[i], 1);
	    }	 
	    return invcount;
	}
	/*The update function and getSum function runs for O(log(n)) and we are iterating over n elements. So overall time complexity is : O(nlogn).
Auxiliary space : O(n)
	 * */
	// Driver program
	public static void main(String[] args){
	    int arr[] = {1,20,6,4,5};
	    int n = arr.length;
	    System.out.println("Number of inversions are : "+getInvCount1(arr,n));
	}
}
