package org.algo.strarr;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindSubArrayFromIntArrayWhoseSumK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,7, 3, 4, 9, 12 ,1};
		
		int maxsum = 13;
		int len = arr.length;
		//subArray(arr , len, maxsum);
		//boolean flag = sumOfSubSetRecursive(arr, len, 0, 0, maxsum);
		
		//System.out.println("is subset avail :"+flag);
		int[] temp = new int[len];
		sumOfSubSetRecursiveBackTrack(arr, len, 0, 0, maxsum, temp,false);
	}

	private static void subArray1(int[] arr , int len, int maxsum) {
		// TODO Auto-generated method stub
		int sum=0;
		int start = 0;
		int[] temp = new int[len];
		int end=0;
		for(int i=0;i<len;i++) {
			sum += arr[i];
			if(sum<maxsum) {
				temp[end++] = arr[i];
			}else if(sum>maxsum) {
				while(sum > maxsum) {
					sum = sum-temp[start];
					temp[start++]=0; 
				}
				temp[end++] = arr[i];
				if(sum==maxsum) {
					break;
				}
			}else {
				temp[end++] = arr[i];
				break;
			}
		}
		System.out.println(Arrays.toString(temp));
		System.out.print("{");
		for(int i=start;i<end;i++) {
			System.out.print(temp[i]+" ");
		}
		System.out.print("}");
	}
	private static void subArray(int[] arr , int len, int maxsum) {
		int sum = 0;
		int j=-1;
		int i=-1;
		boolean flag= false;
		for(i=0;i<len;i++) {
			sum= arr[i];
			if(sum==maxsum) {
				j=-1;
				break;
			}
			for(j=i+1;j<len;j++) {
				sum +=arr[j];
				if(sum>maxsum) break;
				if(sum==maxsum) {
					flag=true;
					break;
				}
			}
			if(flag) break;
		}
	    if(j==-1) {
	    	System.out.println("{ "+arr[i]+" }");
	    }else if(flag){
	    	System.out.print("{");
			for(int start=i;start<=j;start++) {
				System.out.print(arr[start]+" ");
			}
			System.out.print("}");
	    }else {
	    	System.out.println("Not found");
	    }
	}
	
	public  static boolean sumOfSubSetRecursive(int[] arr , int len,int i,int sum, int maxsum) {
		
		if(sum >maxsum) return false;
		
		if(sum==maxsum) return true;
		
		if(i>=len) return false;
		
		if(sumOfSubSetRecursive(arr, len,i+1 ,sum+arr[i], maxsum))return true;
		
		return sumOfSubSetRecursive(arr, len,i+1 ,sum, maxsum);
		
	}
	
	public static void sumOfSubSetRecursiveBackTrack(int[] arr , int len,int i,int sum, int maxsum , int[] temp ,boolean flag) {
		
		if(sum==maxsum && flag) {
			System.out.println(Arrays.toString(temp));
		}
		if(sum>maxsum) return ;
		
		if(i<len) {
			temp[i] =arr[i];
			flag=true;
			sumOfSubSetRecursiveBackTrack(arr, len,i+1 ,sum+arr[i], maxsum ,temp,flag);
			temp[i] =0;
			flag=false;
			sumOfSubSetRecursiveBackTrack(arr, len,i+1 ,sum, maxsum ,temp,flag);
		}
		
	}

}









