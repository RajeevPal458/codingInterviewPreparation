package org.algo.graph;

public class SearchAnElementInASortedAndRotatedArray {

	public static int binarySearch(int[] arr,int l,int h,int key){
		
		if(l>h)
			return -1;
		int mid=(l+h)/2;
		if(key==arr[mid])
			return mid;
		if(arr[l]<arr[mid]){
			
			if(key>=arr[l]&&key<arr[mid])
				return binarySearch( arr, l,mid-1, key);
			return binarySearch(arr, mid+1, h, key);
		}
		
		if(key>arr[mid]&&key<=arr[h])
			return binarySearch(arr, mid+1, h, key);
		return binarySearch(arr, l, mid-1, key);
	}
	public static void main(String[] args) {
		
		int[] arr={4,5,6,7,8,1,2,3};
		
		int len=arr.length;
		
		int index=binarySearch(arr, 0, len-1, 9);
		if(index!=-1)
			System.out.println("Search key index:"+index);
		else
			System.out.println("key is not found !");
		
	}
}
