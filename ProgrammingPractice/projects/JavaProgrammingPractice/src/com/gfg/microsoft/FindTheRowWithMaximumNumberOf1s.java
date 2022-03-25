package com.gfg.microsoft;

public class FindTheRowWithMaximumNumberOf1s {

	public static void main(String[] args) {
		 int mat[][] = { {0, 0, 0, 1},
			             {0, 1, 1, 1},
			             {1, 1, 1, 1},
			             {0, 0, 0, 0}
			           };
			 
			    System.out.println("Index of row with maximum 1s is:"+rowWithMax1s(mat,4,4));
			    System.out.println("Index of row with maximum 1s is:"+rowWithMax1sUseBS(mat,4,4));
			 
	}
	//simple concept.............
	private static int rowWithMax1s(int[][] mat,int m,int n) {

		int maxCount=-1,index=-1,count=0;
		
		for(int i=0;i<m;i++){
			
			for(int j=0;j<n;j++){
				
				if(mat[i][j]==1){
					count++;
				}
			}
			if(maxCount<count){
				maxCount=count;
				count=0;
				index=i;
			}
		}
		return index;
	}
	//use Binary Search to count of 1s in each row.............
	static int count=0;
	public static int count1sUsingBinarySearch(int[] mat,int low,int high){
		
		if(high >= low)
		 {
		    int mid = low + (high - low)/2; 
		    if(mat[mid]==1)
		    	count++;
		 
		    count1sUsingBinarySearch(mat,low,mid-1);
		    
		    count1sUsingBinarySearch(mat,mid+1,high);
		 }
		  return count;
	}
	private static int rowWithMax1sUseBS(int[][] mat,int m,int n) {

		int maxCount=-1,index=-1,count=0;
		
		for(int i=0;i<m;i++){
			
			count=count1sUsingBinarySearch(mat[i],0,n-1);
			if(maxCount<count){
				maxCount=count;
				count=0;
				index=i;
			}
		}
		return index;
	}
}
